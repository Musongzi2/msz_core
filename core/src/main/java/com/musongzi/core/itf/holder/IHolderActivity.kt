package com.musongzi.core.itf.holder

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import com.musongzi.core.itf.IClient
import com.musongzi.core.itf.INotifyDataSetChanged
import com.musongzi.core.itf.IWant
import com.musongzi.core.itf.client.IContextClient
import com.musongzi.core.itf.viewmodel.NormalViewModel

interface IHolderActivity : IHolderArguments<Bundle>, IHolderProviderContext, IWant, IContextClient, INotifyDataSetChanged, IHolderLifecycle,
    IHolderFragmentManager,IHolderViewModel {
    fun getHolderActivity(): FragmentActivity?
    override fun getHolderContext(): Context? = getHolderActivity()
    override fun getHolderLifecycle():LifecycleOwner? = getHolderActivity()
    override fun getHolderLayoutInflater() = getHolderActivity()?.layoutInflater
    override fun getHolderArguments(): Bundle? = getHolderActivity()?.intent?.extras
    override fun resetHolderArguments(d: Bundle?) {}

    override fun getHolderFragmentManager(): FragmentManager? = getHolderActivity()?.supportFragmentManager


}