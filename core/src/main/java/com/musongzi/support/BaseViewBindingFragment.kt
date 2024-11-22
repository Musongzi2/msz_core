package com.musongzi.support

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import java.lang.reflect.Method
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * @Author : linhui

 * @Time : On 2024/11/22 16:38

 * @Description : BaseViewBindingFragment
 */
abstract class BaseViewBindingFragment<V : ViewBinding> : ThemeFragment() {


    companion object {

        val CACHE_BINDING_LIST = hashMapOf<String, Method>()

    }


    final override val getHolderLayoutRes: Int = -1

    internal lateinit var viewBinding: V

    override fun createView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return super.fragmentSupport.findViewBinding(this, this::class.java, inflater, container)
    }


    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        safeOnViewCreated(viewBinding, savedInstanceState)
    }

    protected abstract fun safeOnViewCreated(viewBinding: V, savedInstanceState: Bundle?)
}