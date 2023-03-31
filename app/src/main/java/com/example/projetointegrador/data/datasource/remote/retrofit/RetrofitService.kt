package com.example.projetointegrador.data.datasource.remote.retrofit

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitService {

    const val URL_BASE = ""
/*
    fun getAPI(): /* TODO instanciar a api */ {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        return Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(
            URL_BASE
        ).build().create(
            /* TODO instanciar a api */ ::class.java)
    }
*/
}