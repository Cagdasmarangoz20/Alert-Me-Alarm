package com.cagdasmarangoz.alertme.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cagdasmarangoz.alertme.modul.Alarm
import com.cagdasmarangoz.alertme.modul.Days

@Entity
data class AlarmData(
    val title: String,
    val hour: Int,
    val minute: Int,
    val isActive: Boolean,
    val dayList: List<Days>,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0

) {
    fun toAlarm(): Alarm {
        return Alarm(
            title = title,
            hour = hour,
            minute = minute,
            isActive = isActive,
            dayList = dayList
        )
    }
}