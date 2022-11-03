package com.pasichnyi.cleanarchitecturekmm.UI.presenter

import com.pasichnyi.cleanarchitecturekmm.UI.contract.BasePresenterContract
import com.pasichnyi.cleanarchitecturekmm.UI.contract.BaseViewContract
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

open class BasePresenter<V : BaseViewContract> : CoroutineScope, BasePresenterContract<V> {

    var view: V? = null
        private set

    override val coroutineContext = Dispatchers.Main +
            CoroutineExceptionHandler { _, _ ->
                showError()
            } + SupervisorJob()

    override fun showError() {
        view?.showUnexpectedError()
    }

    override fun attach(view: V) {
        this.view = view
    }

    override fun detach() {
        this.view = null
    }

}