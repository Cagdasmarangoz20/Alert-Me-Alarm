package com.cagdasmarangoz.alertme.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [AlarmData::class],
    version = 1
)
abstract class AlarmDatabase: RoomDatabase() {
    abstract val dao: AlarmDao

}