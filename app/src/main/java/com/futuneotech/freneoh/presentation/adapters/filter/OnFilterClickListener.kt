package com.futuneotech.freneoh.presentation.adapters.filter

import com.futuneotech.freneoh.presentation.fragments.list.Item

interface OnFilterClickListener {
    fun onFilterClick(position:Int,filter: Item)
}