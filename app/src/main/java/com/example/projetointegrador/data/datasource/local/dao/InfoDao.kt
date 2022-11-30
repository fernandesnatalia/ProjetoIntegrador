package com.example.projetointegrador.data.datasource.local.dao

import androidx.room.*
import com.example.projetointegrador.data.model.LightPole

@Dao
interface InfoDao {

    @Query("Select * From pole_info")
    fun getList(): List<LightPole>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateList(items: LightPole)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIntoDatabase(item: LightPole)

}