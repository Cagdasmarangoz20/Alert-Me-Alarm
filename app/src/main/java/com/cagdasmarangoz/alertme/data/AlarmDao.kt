package com.cagdasmarangoz.alertme.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
@Dao
interface AlarmDao {
    @Update
    suspend fun updateAlarm(alarmData: AlarmData)

    @Delete
    suspend fun deleteAlarm(alarmData: AlarmData)

    @Query("SELECT * FROM AlarmData ORDER BY title ASC")
   suspend fun getAlarmTitle(): List<AlarmData>

    @Query("SELECT * FROM AlarmData ORDER BY hour ASC")
    suspend fun getAlarmHour(): List<AlarmData>

    @Query("SELECT * FROM AlarmData ORDER BY minute ASC")
    suspend fun getAlarmMinute(): List<AlarmData>

    @Query("SELECT * FROM AlarmData ORDER BY isActive ASC")
    suspend fun getAlarmIsActive(): List<AlarmData>

    @Query("SELECT * FROM AlarmData ORDER BY dayList ASC")
    suspend fun getAlarmDayList(): List<AlarmData>



}