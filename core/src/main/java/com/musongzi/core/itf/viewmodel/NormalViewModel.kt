package com.musongzi.core.itf.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.musongzi.core.itf.IBusiness
import com.musongzi.core.itf.ISaveStateHandle
import com.musongzi.core.itf.holder.IViewModel
import kotlinx.coroutines.CoroutineScope

/**
 * @Author : linhui

 * @Time : On 2024/8/29 12:06

 * @Description : NormalViewModel
 *
 * 一个普通的viewmodel实现了 [IViewModel],也是基础的Base
 * 实现数据集容器持有一个本地数据集[IHolderSavedStateHandle]，和远端数据集[IHolderLocalSavedStateHandle]
 * 实现业务容器[IBusinessOwner],用于管理业务对象注入和寻找
 *
 */
open class NormalViewModel : ViewModel, IBusinessOwner {

    private var savedStateHandle: SavedStateHandle? = null
    private var saveStateHandleWrap: ISaveStateHandle? = null
    private val business: WrapBusiness by lazy {
        WrapBusiness().apply {
            onCreate(this@NormalViewModel)
        }
    }

    private val localSavedHandler: ISaveStateHandle by lazy {
        LocalSavedHandler()
    }

    constructor()

    constructor(savedStateHandle: SavedStateHandle) {
        this.savedStateHandle = savedStateHandle
        this.saveStateHandleWrap = SaveStateHandleWrap(savedStateHandle)
    }


    operator fun <T> get(key: String): T? {
        return savedStateHandle?.get(key)
    }

    override fun getHolderSavedStateHandle() = saveStateHandleWrap

    override fun getHolderLocalSavedStateHandle(): ISaveStateHandle = localSavedHandler

    override fun <T : IBusiness> createBusiness(clazz: Class<T>?, owner: IBusinessOwner): T? {
        return clazz?.newInstance()?.apply {
            onCreate(owner)
        }
    }


    override fun <T : IBusiness> getNext(clazz: Class<T>): T? = business.getNext(clazz)

    override fun getHolderCoroutineScope(): CoroutineScope = viewModelScope


}