package com.musongzi.core.itf

import android.annotation.SuppressLint
import androidx.annotation.MainThread
import androidx.annotation.Nullable
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.StateFlow

/***
 * @Author : linhui
 * @Time : On 2024/8/30 16:16
 *
 * 一组数据集的容器
 * 负责组件基于数据的注入和返回
 *
 * 只有两个默认实现
 * [LocalSavedHandler] 本地数据集容器
 * [SaveStateHandleWrap] 具备数据保存基于生命周期业务的数据保存，具体实现参考内部解释
 */
interface ISaveStateHandle {
    @MainThread
    fun <T> getLiveData(key: String): MutableLiveData<T>

    @MainThread
    fun contains(key: String): Boolean

    @MainThread
    fun <T> getLiveData(key: String, initialValue: T): MutableLiveData<T>

    @MainThread
    fun keys(): Set<String?>

    @MainThread
    operator fun <T> get(key: String): T?

    @MainThread
    fun <T> remove(key: String): T?

    @MainThread
    operator fun <T> set(key: String, value: T?)

    @MainThread
    fun <T> getStateFlow(key: String, initialValue: T?): StateFlow<T?>

//    operator fun plus(other: Pair<String,*>):ISaveStateHandle{
//        set(other.first,other.second)
//        return this;
//    }

    companion object {

        fun ISaveStateHandle?.plus(other: Pair<String, *>): ISaveStateHandle? {
            this?.set(other.first, other.second)
            return this;
        }

    }
}