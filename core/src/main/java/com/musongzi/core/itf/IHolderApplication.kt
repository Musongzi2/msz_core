package com.musongzi.core.itf

import android.app.Application
import android.content.Context
import com.musongzi.core.itf.holder.IHolderContext
import com.musongzi.core.itf.holder.IHolderLifecycle

/*** created by linhui * on 2022/8/25 */
interface IHolderApplication :IHolderContext {

    override fun getHolderContext(): Application

}