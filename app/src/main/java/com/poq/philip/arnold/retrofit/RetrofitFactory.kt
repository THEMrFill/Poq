package com.poq.philip.arnold.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {
    val repoBaseUrl = "https://api.github.com/orgs/square/"
    val repoRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl(repoBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}