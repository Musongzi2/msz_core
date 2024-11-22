package com.musongzi.core.itf.holder

import androidx.viewbinding.ViewBinding


interface IHolderDataBinding<D : ViewBinding> {

    fun getHolderDataBinding(): D?

}