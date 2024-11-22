package com.musongzi.support

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.musongzi.core.itf.IDialogSupport
import com.musongzi.core.itf.holder.IHolderFragment
import com.musongzi.core.itf.holder.IViewModel
import com.musongzi.core.itf.viewmodel.NormalViewModel
import com.musongzi.support.BaseViewBindingFragment.Companion.CACHE_BINDING_LIST
import com.trello.rxlifecycle4.LifecycleTransformer
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * @Author : linhui

 * @Time : On 2024/11/22 16:17

 * @Description : FragmentSupport
 */
class FragmentSupport(private val fragment: Fragment) : IHolderFragment {

    private val mViewModelProvider = ViewModelProvider(fragment)

    override fun getHolderFragment(): Fragment = fragment

    override fun getHolderActivity(): FragmentActivity? = fragment.activity

    override fun topViewModelProvider(): ViewModelProvider? {
        return getHolderActivity()?.let {
            ViewModelProvider(it)
        }
    }

    override fun thisViewModelProvider(): ViewModelProvider = mViewModelProvider

    override fun <T> bindToLifecycle(): LifecycleTransformer<T>? {
        TODO("Not yet implemented")
    }


    override fun getHolderViewModel(): IViewModel {
        return thisViewModelProvider()[NormalViewModel::class.java]
    }

    override fun showDialog(action: Int) {

    }

    override fun dismissDialog() {

    }

    internal fun <V : ViewBinding> findViewBinding(
        f: BaseViewBindingFragment<V>,
        clazz: Type?,
        inflater: LayoutInflater,
        container: ViewGroup?
    ): View {
        if (clazz is Class<*>) {
            if (CACHE_BINDING_LIST.containsKey(clazz.name)) {
                val method = CACHE_BINDING_LIST[clazz.name]
                f.viewBinding = method!!.invoke(null, inflater, container, false) as V
                Log.d("findViewBinding", "Class: find cache")
                return f.viewBinding.root
            } else if (clazz.name == Object::class.java.name) {
                TODO()
            }
        }
        val c = (clazz as? Class<*>)?.genericSuperclass
        if (c is Class<*>) {
            return findViewBinding(f,c, inflater, container)
        } else {
            (c as ParameterizedType).actualTypeArguments.forEach {

                if (it is Class<*> && ViewBinding::class.java.isAssignableFrom(it)) {
                    val method = it.getDeclaredMethod(
                        "inflate",
                        LayoutInflater::class.java,
                        ViewGroup::class.java,
                        Boolean::class.java
                    )
                    f.viewBinding = method.invoke(null, inflater, container, false) as V
                    Log.d("findViewBinding", "ParameterizedType: new method , save cache")
                    CACHE_BINDING_LIST[this::class.java.name] = method
                    return f.viewBinding.root
                }

            }
        }

        TODO()
    }
}