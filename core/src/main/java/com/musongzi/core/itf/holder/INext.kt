package com.musongzi.core.itf.holder

import androidx.lifecycle.ViewModel
import com.musongzi.core.itf.IBusiness

/**
 * @Author : linhui

 * @Time : On 2024/9/6 14:21

 * @Description : INext
 * 可以获许一个business对象，实现单个对象的注入
 * 一般是[IViewModel] 实现，也就是[ViewModel]
 */
interface INext {

    fun <T : IBusiness> getNext(clazz: Class<T>): T?

}