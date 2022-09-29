package com.example.projetointegrador.data.datasource.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.projetointegrador.data.datasource.local.model.Info

@Database(entities = [Info::class],version = 1)
abstract class InfoDatabase : RoomDatabase() {

    abstract fun InfoDao(): InfoDao
}