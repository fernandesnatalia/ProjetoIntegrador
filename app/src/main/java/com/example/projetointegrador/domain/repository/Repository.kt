package com.example.projetointegrador.domain.repository

import com.example.projetointegrador.data.datasource.local.database.InfoDao
import com.example.projetointegrador.domain.model.LightPole

class Repository(private val dao: InfoDao){

    fun insertIntoDatabase(item:LightPole) = dao.insertIntoDatabase(item)

    fun getList():List<LightPole> = dao.getList()

}