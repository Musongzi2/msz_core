package com.musongzi.core.itf.holder

import com.musongzi.core.itf.ISaveStateHandle

/**
 * [ISaveStateHandle]持有者
 */
interface IHolderSavedStateHandle {
   fun getHolderSavedStateHandle(): ISaveStateHandle?
}