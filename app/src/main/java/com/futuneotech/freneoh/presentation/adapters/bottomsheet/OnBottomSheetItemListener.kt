package com.futuneotech.freneoh.presentation.adapters.bottomsheet

import com.futuneotech.freneoh.presentation.fragments.list.Item

interface OnBottomSheetItemListener {
    fun onBottomSheetItemClicked(position:Int,item: Item)
}
