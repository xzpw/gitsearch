package com.dm.gitsearch.data

import android.util.Log
import com.dm.gitsearch.api.ServiceApi
import com.dm.gitsearch.api.netmodels.GitHubSearchItemModel

class DataSource(val api: ServiceApi) {
    suspend fun getRepos(page: Int, query:String): List<GitHubSearchItemModel> {
        Log.d("mylog", Thread.currentThread().name)
        return api.searchGitHubRepo(
            query, page, "", "desc",15
        ).items ?: listOf()
    }
}