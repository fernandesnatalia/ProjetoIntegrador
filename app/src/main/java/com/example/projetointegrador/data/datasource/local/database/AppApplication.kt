package com.example.projetointegrador.data.datasource.local.database

import android.app.Application
import androidx.room.Room

class AppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            InfoDatabase::class.java, "database-light-pole"
        )
            .fallbackToDestructiveMigration().allowMainThreadQueries()
            .build()
    }

    companion object {
        private lateinit var database: InfoDatabase
        fun getdatabase(): InfoDatabase {
            return database
        }
    }
}