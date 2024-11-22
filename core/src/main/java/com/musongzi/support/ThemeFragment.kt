package com.musongzi.support

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.musongzi.core.itf.holder.IHolderFragment
import com.musongzi.core.itf.holder.IHolderLayoutInflater
import com.musongzi.core.itf.holder.IHolderLayoutRes
import com.musongzi.core.itf.holder.IViewModel
import com.trello.rxlifecycle4.LifecycleTransformer

/**
 * @Author : linhui

 * @Time : On 2024/11/22 16:20

 * @Description : CoreFragment
 */
abstract class ThemeFragment : Fragment(), IHolderLayoutInflater, IHolderFragment, IHolderLayoutRes {

    protected val fragmentSupport by lazy {
        FragmentSupport(this)
    }

    override fun getHolderFragment() = fragmentSupport.getHolderFragment()

    override fun getHolderActivity() = fragmentSupport.getHolderActivity()

    override fun topViewModelProvider() = fragmentSupport.topViewModelProvider()

    override fun thisViewModelProvider() = fragmentSupport.thisViewModelProvider()


    final override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return createView(getHolderLayoutInflater() ?: inflater, container, savedInstanceState)
    }

    protected open fun createView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getHolderLayoutRes, container, false)
    }

    override fun <T> bindToLifecycle(): LifecycleTransformer<T>? {
        TODO("Not yet implemented")
    }

    override fun showDialog(action: Int) {

    }

    override fun dismissDialog() {

    }

    override fun getHolderViewModel(): IViewModel = fragmentSupport.getHolderViewModel()


}