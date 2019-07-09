package com.poq.philip.arnold.retrofit

import com.poq.philip.arnold.retrofit.data.ReposMain
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitRepoService {
    @GET("repos")
    suspend fun getRepos(): Response<ArrayList<ReposMain>>
}