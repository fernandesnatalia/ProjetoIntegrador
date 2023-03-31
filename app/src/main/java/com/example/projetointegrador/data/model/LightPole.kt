package com.example.projetointegrador.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "pole_info")
data class LightPole(
    @PrimaryKey(autoGenerate = false)
    var code: String = "",
    var street: String = "",
    var neighborhood: String = "",
    var city: String = "",
    var description: String = ""
): Parcelable