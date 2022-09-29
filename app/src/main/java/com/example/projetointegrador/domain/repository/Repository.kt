package com.example.projetointegrador.domain.repository

import com.example.projetointegrador.data.datasource.local.database.InfoDao
import com.example.projetointegrador.data.datasource.local.model.Info

class Repository(private val dao: InfoDao){

    fun insertIntoDatabase(item:Info) = dao.insertIntoDatabase(item)

    fun getList():List<Info> = dao.getList()
}