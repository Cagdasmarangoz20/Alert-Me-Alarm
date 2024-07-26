package com.cagdasmarangoz.alertme.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class AlarmModel(
    private val dao: AlarmDao
) : ViewModel() {
    private val alarmAdded: MutableState<Boolean> = mutableStateOf(true)

    fun onEvent(event: AlarmEvents) {
        when (event) {
            is AlarmEvents.DeleteAlarm -> {
                viewModelScope.launch {
                    dao.deleteAlarm(event.alarm)
                }
            }

            is AlarmEvents.SaveAlarm -> {
            }

            AlarmEvents.SortAlarm -> {

            }
        }
    }
}
