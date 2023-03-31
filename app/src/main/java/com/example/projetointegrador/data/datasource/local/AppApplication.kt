package com.example.projetointegrador.data.datasource.local

import android.app.Application
import androidx.room.Room
import com.example.projetointegrador.data.datasource.local.database.InfoDatabase

class AppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            InfoDatabase::class.java, "database-lightpole"
        )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    companion object {
        private lateinit var database: InfoDatabase
        fun getdatabase(): InfoDatabase {
            return database
        }
    }
}