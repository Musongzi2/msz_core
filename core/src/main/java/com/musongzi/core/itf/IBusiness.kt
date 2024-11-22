package com.musongzi.core.itf

import com.musongzi.core.itf.viewmodel.IBusinessOwner

/**
 * @Author : linhui

 * @Time : On 2024/9/6 14:20

 * @Description : IBusiness
 * 业务对象的抽象
 * 具有基础的生命周期
 */
interface IBusiness {

    fun onCreate(owner: IBusinessOwner)

    fun onClear()

}