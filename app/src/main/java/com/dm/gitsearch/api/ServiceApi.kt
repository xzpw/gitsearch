package com.dm.gitsearch.api

import com.dm.gitsearch.api.netmodels.GitHubSearchModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {

    @GET("search/repositories")
    suspend fun searchGitHubRepo(
        @Query("q")         searchParam : String,
        @Query("page")      page : Int,
        @Query("sort")      sort : String,
        @Query("order")     order : String,
        @Query("per_page")  perPage : Int ) : GitHubSearchModel
}

val BASE_URL = "https://api.github.com/"