package com.example.projetointegrador.data.datasource.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.projetointegrador.data.datasource.local.dao.InfoDao
import com.example.projetointegrador.data.model.LightPole

@Database(entities = [LightPole::class],version = 3)
abstract class InfoDatabase : RoomDatabase() {

    abstract fun InfoDao(): InfoDao
}