package com.musongzi.core.itf.holder

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.musongzi.core.itf.IClear
import kotlinx.coroutines.CoroutineScope

interface IHolderLifecycle : IHolderCoroutineScope {
    fun getHolderLifecycle(): LifecycleOwner?
    override fun getHolderCoroutineScope(): CoroutineScope? = getHolderLifecycle()?.lifecycleScope
}