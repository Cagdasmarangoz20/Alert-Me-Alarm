package com.cagdasmarangoz.alertme.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.cagdasmarangoz.alertme.modul.Alarm
import com.cagdasmarangoz.alertme.modul.Days

data class AlarmState (

    val alarms: List<Alarm> = emptyList(),
    val title: MutableState<String> = mutableStateOf(""),
    val hour: MutableState<String> = mutableStateOf(""),
    val minute: MutableState<String> = mutableStateOf(""),
    val isActive: MutableState<Boolean> = mutableStateOf(false),
    val dayList: MutableState<List<Days>> = mutableStateOf(emptyList())
)