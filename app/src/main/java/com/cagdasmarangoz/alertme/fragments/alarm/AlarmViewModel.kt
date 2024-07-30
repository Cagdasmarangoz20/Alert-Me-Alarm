package com.cagdasmarangoz.alertme.fragments.alarm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

import androidx.lifecycle.viewModelScope
import com.cagdasmarangoz.alertme.data.AlarmDao
import com.cagdasmarangoz.alertme.data.AlarmData
import com.cagdasmarangoz.alertme.data.AlarmDatabase
import com.cagdasmarangoz.alertme.data.AlarmEvents
import com.cagdasmarangoz.alertme.modul.Alarm
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AlarmViewModel @Inject constructor(
    private val alarmDatabase: AlarmDatabase
) : ViewModel() {

    private val alarmAdded: MutableState<Boolean> = mutableStateOf(true)

    private val _alarmList: MutableStateFlow<List<AlarmData>> = MutableStateFlow(listOf())
    val alarmList: StateFlow<List<AlarmData>> get() = _alarmList

    init {
        getAlarmList()
    }


    fun getAlarmList() {
        viewModelScope.launch(Dispatchers.IO) {
            _alarmList.value = alarmDatabase.alarmDao().getAlarmList()
        }
    }

    fun updateAlarm(alarm: Alarm) {
        viewModelScope.launch {
        }
    }
}