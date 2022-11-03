package com.pasichnyi.cleanarchitecturekmm.android.view

import android.app.AlertDialog
import android.content.Context
import androidx.fragment.app.Fragment
import com.pasichnyi.cleanarchitecturekmm.UI.contract.BasePresenterContract
import com.pasichnyi.cleanarchitecturekmm.UI.contract.BaseViewContract

abstract class BaseFragment<V : BaseViewContract, P : BasePresenterContract<V>> : Fragment(),
    BaseViewContract {

    lateinit var presenter: P
        private set

    override fun onAttach(context: Context) {
        super.onAttach(context)
        presenter = initPresenter()
        presenter.attach(this as V)
    }

    override fun onDetach() {
        presenter.detach()
        super.onDetach()
    }

    override fun showUnexpectedError() {
        AlertDialog
            .Builder(context)
            .setMessage("R.string.unexpected_error_message")
            .setPositiveButton("R.string.ok", null)
            .show()
    }

    protected abstract fun initPresenter(): P
}