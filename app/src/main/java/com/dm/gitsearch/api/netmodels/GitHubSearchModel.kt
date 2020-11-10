package com.dm.gitsearch.api.netmodels

import com.google.gson.annotations.SerializedName

data class GitHubSearchModel(
    @SerializedName("total_count")
    val totalCount : Int,
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    @SerializedName("items")
    val items : List<GitHubSearchItemModel>?
)