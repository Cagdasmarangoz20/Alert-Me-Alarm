package com.cagdasmarangoz.alertme.data

import com.cagdasmarangoz.alertme.modul.Days

sealed interface AlarmEvents {
    object SortAlarm : AlarmEvents

    data class DeleteAlarm(val alarm: AlarmData) : AlarmEvents


    data class SaveAlarm(
        val title: String,
        val hour: Int,
        val minute: Int,
        val isActive: Boolean,
        val dayList: List<Days>
    ) : AlarmEvents
}