package com.musongzi.core.itf.holder

interface IHolderArguments<D>  {
    fun resetHolderArguments(d: D?);
    fun getHolderArguments(): D?
}