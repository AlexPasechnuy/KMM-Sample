package com.pasichnyi.cleanarchitecturekmm.UI.contract

interface BaseViewContract {

    fun showUnexpectedError()
}

interface BasePresenterContract<V : BaseViewContract> {

    fun attach(view: V)

    fun detach()

    fun showError()
}