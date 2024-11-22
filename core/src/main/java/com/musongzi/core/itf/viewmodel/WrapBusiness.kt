package com.musongzi.core.itf.viewmodel

import com.musongzi.core.itf.IBusiness
import com.musongzi.core.itf.ISaveStateHandle
import com.musongzi.core.itf.holder.IHolderBusiness
import com.musongzi.core.itf.holder.IHolderLocalSavedStateHandle
import com.musongzi.core.itf.holder.IHolderSavedStateHandle
import com.musongzi.core.itf.holder.INext


/**
 * @Author : linhui

 * @Time : On 2024/9/6 14:23

 * @Description : WrapBusiness
 */
open class WrapBusiness : IHolderBusiness, IBusiness, IHolderSavedStateHandle, IHolderLocalSavedStateHandle, INext {

    private lateinit var owner: IBusinessOwner

    protected open fun innerOnCreate(owner: IBusinessOwner) {}


    private val brotherBusiness by lazy {
        hashMapOf<String, IBusiness>()
    }

    final override fun onCreate(owner: IBusinessOwner) {
        if (this::owner.isInitialized) {
            TODO("不允许调用两次")
        }
        this.owner = owner
        innerOnCreate(owner)
    }

    override fun onClear() {

    }

    override fun getHolderBusiness(): WrapBusiness = this


    @Synchronized
    override fun <T : IBusiness> getNext(clazz: Class<T>): T? {
        val business = brotherBusiness[clazz.name]
        return if (business == null) {
            (owner.createBusiness(clazz, owner) ?: nativeInstance(clazz)).apply {
                brotherBusiness[clazz.name] = this
            }
        } else {
            business as? T
        }
    }

    private fun <T> nativeInstance(clazz: Class<T>): T {
        return clazz.newInstance().apply {
            onCreate(owner)
        }
    }

    override fun getHolderSavedStateHandle(): ISaveStateHandle? {
        return owner.getHolderSavedStateHandle()
    }

    override fun getHolderLocalSavedStateHandle(): ISaveStateHandle? {
        return owner.getHolderLocalSavedStateHandle()
    }


}