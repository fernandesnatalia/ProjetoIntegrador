package com.example.projetointegrador.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class LightPole(
    var code: String = "",
    var street: String = "",
    var neighborhood: String = "",
    var city: String = ""
): Parcelable