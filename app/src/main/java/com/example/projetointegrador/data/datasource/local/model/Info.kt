package com.example.projetointegrador.data.datasource.local.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "info")
data class Info(
    @PrimaryKey(autoGenerate = false)
    var keycode:String,
    var rua:String,
    var bairro:String,
    var city:String
) : Parcelable