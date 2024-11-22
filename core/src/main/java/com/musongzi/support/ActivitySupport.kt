package com.musongzi.support

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.musongzi.core.itf.holder.IHolderActivity
import com.musongzi.core.itf.holder.IViewModel
import com.musongzi.core.itf.viewmodel.NormalViewModel
import com.trello.rxlifecycle4.LifecycleTransformer

/**
 * @Author : linhui

 * @Time : On 2024/11/22 16:15

 * @Description : ActivitySupport
 */
open class ActivitySupport(private val fragmentActivity: FragmentActivity) : IHolderActivity {


    private val mViewModelProvider = ViewModelProvider(fragmentActivity)

    override fun getHolderActivity(): FragmentActivity = fragmentActivity

    override fun topViewModelProvider() = mViewModelProvider

    override fun thisViewModelProvider() = mViewModelProvider

    override fun <T> bindToLifecycle(): LifecycleTransformer<T>? {
        TODO("Not yet implemented")
    }

    override fun showDialog(action: Int) {

    }

    override fun dismissDialog() {

    }

    override fun getHolderViewModel(): IViewModel {
       return thisViewModelProvider()[NormalViewModel::class.java]
    }
}