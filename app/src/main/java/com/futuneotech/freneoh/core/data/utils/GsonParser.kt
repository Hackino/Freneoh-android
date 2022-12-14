package com.futuneotech.freneoh.core.data.utils

import com.futuneotech.freneoh.core.domain.utils.JsonParser
import com.google.gson.Gson
import java.lang.reflect.Type

class GsonParser(
    private val gson: Gson
): JsonParser {

    override fun <T> fromJson(json: String, type: Type): T? {
        return gson.fromJson(json, type)
    }

    override fun <T> toJson(obj: T, type: Type): String? {
        return gson.toJson(obj, type)
    }
}