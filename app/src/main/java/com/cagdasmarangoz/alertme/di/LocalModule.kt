package com.cagdasmarangoz.alertme.di

import android.content.Context
import com.cagdasmarangoz.alertme.data.AlarmDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

   @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): AlarmDatabase {
        return AlarmDatabase.getDatabase(context)
    }
}