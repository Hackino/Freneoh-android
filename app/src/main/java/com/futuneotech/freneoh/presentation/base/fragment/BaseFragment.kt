package com.futuneotech.freneoh.presentation.base.fragment

import androidx.fragment.app.Fragment
import com.futuneotech.freneoh.presentation.activities.MainActivity
import com.futuneotech.freneoh.presentation.views.dialogs.LoadingDialog

open class BaseFragment(contentLayoutId:Int):Fragment(contentLayoutId) {
    val mLoader: LoadingDialog by lazy { LoadingDialog(requireContext()) }

    fun isExpanded() = (activity as MainActivity).isExpanded()
}