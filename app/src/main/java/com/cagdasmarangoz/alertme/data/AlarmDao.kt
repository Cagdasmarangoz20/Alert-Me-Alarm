package com.cagdasmarangoz.alertme.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
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
   fun getAlarmList(): List<AlarmData>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(alarmData: AlarmData)




}