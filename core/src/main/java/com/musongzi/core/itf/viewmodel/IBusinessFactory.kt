package com.musongzi.core.itf.viewmodel

import com.musongzi.core.itf.IBusiness

/**
 * @Author : linhui

 * @Time : On 2024/9/6 14:24

 * @Description : IBusinessFactory
 */
interface IBusinessFactory {

    fun <T: IBusiness> createBusiness(clazz: Class<T>?, owner: IBusinessOwner):T?

}