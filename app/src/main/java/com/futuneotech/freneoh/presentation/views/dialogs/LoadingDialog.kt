package com.futuneotech.freneoh.presentation.views.dialogs

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.futuneotech.freneoh.R

class LoadingDialog(context: Context) {

    private var loader: AlertDialog? = null
    private var isVisible = false
    private var context: Context

    init {
        this.context = context
        createLoader()
    }

    private fun createLoader() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(
            context,
            R.style.progress_dialog
        )
        builder.setCancelable(false)
        builder.setView(R.layout.progress_bar_dialog)
        loader = builder.create()
    }

    fun show() {
        if (loader == null) {
            createLoader()
        }
        if (!isVisible) {
            loader?.show()
            isVisible = true
        }
    }

    val isShowing: Boolean
        get() = !(loader == null && !isVisible)

    fun dismiss() {
        loader?.dismiss()
        isVisible = false
    }
}