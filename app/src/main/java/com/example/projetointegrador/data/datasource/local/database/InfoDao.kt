package com.example.projetointegrador.data.datasource.local.database

import androidx.room.*
import com.example.projetointegrador.data.datasource.local.model.Info

@Dao
interface InfoDao {

    @Query("Select * From info")
    fun getList(): List<Info>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateList(item: Info)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIntoDatabase(item: Info)
}