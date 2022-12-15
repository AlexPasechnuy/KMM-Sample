package com.pasichnyi.cleanarchitecturekmm.android.view

import android.app.AlertDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.pasichnyi.cleanarchitecturekmm.UI.contract.BasePresenterContract
import com.pasichnyi.cleanarchitecturekmm.UI.contract.BaseViewContract

abstract class BaseActivity<V : BaseViewContract, P : BasePresenterContract<V>> :
    ComponentActivity(),
    BaseViewContract {

    lateinit var presenter: P
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = initPresenter()
        presenter.attach(this as V)
    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
    }

    override fun showError(title: String?, content: String?) {
        AlertDialog
            .Builder(this)
            .setTitle(title ?: "Error")
            .setMessage(content ?: "Unexpected error occurred")
            .setPositiveButton("ok", null)
            .show()
    }

    protected abstract fun initPresenter(): P
}