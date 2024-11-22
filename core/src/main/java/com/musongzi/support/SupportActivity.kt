package com.musongzi.support

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.musongzi.core.itf.holder.IHolderActivity
import com.musongzi.core.itf.holder.IViewModel
import com.trello.rxlifecycle4.LifecycleTransformer

/**
 * @Author : linhui

 * @Time : On 2024/11/22 16:47

 * @Description : SupportActivity
 */
class SupportActivity : FragmentActivity(), IHolderActivity {

    private val holderActivity = ActivitySupport(this)

    override fun getHolderActivity() = holderActivity.getHolderActivity()


    override fun topViewModelProvider() = holderActivity.topViewModelProvider()
    override fun thisViewModelProvider() = holderActivity.thisViewModelProvider()

    override fun <T> bindToLifecycle(): LifecycleTransformer<T>? {
        TODO("Not yet implemented")
    }

    override fun dismissDialog() {

    }

    override fun getHolderViewModel() = holderActivity.getHolderViewModel()


}