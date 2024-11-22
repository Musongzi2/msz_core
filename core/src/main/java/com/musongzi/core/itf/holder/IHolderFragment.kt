package com.musongzi.core.itf.holder

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.musongzi.core.itf.client.IContextClient

interface IHolderFragment : IHolderActivity {

    fun getHolderFragment(): Fragment

    override fun getHolderLayoutInflater(): LayoutInflater? = getHolderFragment().layoutInflater
    override fun getHolderContext(): Context? =  getHolderFragment().context
    override fun getHolderArguments(): Bundle?  = getHolderFragment().arguments

    override fun resetHolderArguments(d: Bundle?) {
        getHolderFragment().arguments = d
    }
    override fun getHolderFragmentManager(): FragmentManager? = getHolderFragment().childFragmentManager

    override fun getHolderLifecycle() = getHolderFragment()
}