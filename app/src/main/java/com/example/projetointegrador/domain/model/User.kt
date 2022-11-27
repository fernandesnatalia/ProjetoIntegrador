package com.example.projetointegrador.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class User(
    var name: String = "",
    var cpf: String = "",
    var phone: String = "",
    var email:String = "",
    var password: String = ""
): Parcelable