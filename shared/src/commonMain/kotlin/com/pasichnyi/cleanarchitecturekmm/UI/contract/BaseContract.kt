package com.pasichnyi.cleanarchitecturekmm.UI.contract

interface BaseViewContract {

    fun showError(title: String? = null, content: String? = null)
}

interface BasePresenterContract<V : BaseViewContract> {

    fun attach(view: V)

    fun detach()

    fun showError(throwable: Throwable?)
}