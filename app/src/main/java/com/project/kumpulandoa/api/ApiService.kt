package com.project.kumpulandoa.api

import com.project.kumpulandoa.ResponseDoaAlquran
import com.project.kumpulandoa.ResponseDoaHadits
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("getdoa/3")
    fun getdoa() : Call<ResponseDoaAlquran>

    @GET("getdoa/4")
    fun getdoa2() : Call<ResponseDoaHadits>

    @GET("getdoa/1")
    fun getdoa3t() : Call<ResponseDoaHadits>

}