package com.musongzi.core.itf.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import kotlinx.coroutines.flow.StateFlow
import android.os.Parcelable
import com.musongzi.core.itf.ISaveStateHandle

/**
 *  * @Author : linhui
 *
 *  * @Time : On 2024/8/30 16:16
 *
 *  * @Description : ISaveStateHandle
 *  一组数据集容器
 *  只是一个包裹类型，具体实现是jectpack的[SavedStateHandle]
 *  注意！！！！->此数据只能保存基本数据8大类型和可序列化[Serializable]和android的[Parcelable]的类型
 *  数据会保存在remote 的ActivitymanagerServer 中用来当异常情况的数据保存
 */
class SaveStateHandleWrap(private val stateHandle: SavedStateHandle) : ISaveStateHandle {
    override fun <T> getLiveData(key: String): MutableLiveData<T> {
        return stateHandle.getLiveData(key)
    }

    override fun <T> getLiveData(key: String, initialValue: T): MutableLiveData<T> {
        return stateHandle.getLiveData(key, initialValue)
    }

    override fun contains(key: String): Boolean {
        return stateHandle.contains(key)
    }

    override fun keys(): Set<String?> {
        return stateHandle.keys()
    }

    override fun <T> get(key: String): T? {
        return stateHandle.get(key)
    }

    override fun <T> remove(key: String): T? {
        return stateHandle.remove(key)
    }

    override fun <T> set(key: String, value: T?) {
        return stateHandle.set(key, value)
    }

    override fun <T> getStateFlow(key: String, initialValue: T?): StateFlow<T?> {
        return stateHandle.getStateFlow(key, initialValue)

    }


}