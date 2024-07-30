package com.cagdasmarangoz.alertme.data

import androidx.room.TypeConverter
import com.cagdasmarangoz.alertme.modul.Days
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class DayTypeConverter {

    @TypeConverter
    fun fromStringToDays(value: String): List<Days> {
        return try {
            Gson().fromJson(value, object : TypeToken<List<Days?>?>() {}.type) ?: listOf()
        } catch (_: Exception) {
            listOf()
        }
    }

    @TypeConverter
    fun fromDaysToString(days: List<Days>): String {
        return  Gson().toJson(days)
    }
}