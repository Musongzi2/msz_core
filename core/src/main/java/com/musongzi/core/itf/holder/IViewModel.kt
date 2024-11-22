package com.musongzi.core.itf.holder

import kotlinx.coroutines.CoroutineScope


interface IViewModel : IHolderLocalSavedStateHandle, IHolderSavedStateHandle, IHolderCoroutineScope, INext {


}