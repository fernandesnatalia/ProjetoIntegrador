package com.example.projetointegrador.data.datasource.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.projetointegrador.domain.model.LightPole

@Database(entities = [LightPole::class],version = 2)
abstract class InfoDatabase : RoomDatabase() {

    abstract fun InfoDao(): InfoDao
}