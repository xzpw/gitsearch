package com.dm.gitsearch.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dm.gitsearch.api.netmodels.GitHubSearchItemModel
import com.dm.gitsearch.data.DataSource
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

class GitViewModel(val dataSource: DataSource): ViewModel() {
    private  val dataMutableLiveData = MutableLiveData<List<GitHubSearchItemModel>> ()
    val dataLiveData: LiveData<List<GitHubSearchItemModel>> = dataMutableLiveData

    val coroutineExceptionHandler = CoroutineExceptionHandler {
        coroutineContext, throwable ->
        Log.e("${GitViewModel::class.simpleName}",throwable.message.toString())
    }

    fun getSearchData (q: String) {
        viewModelScope.launch(coroutineExceptionHandler) {
            supervisorScope {
                val listData = mutableListOf<GitHubSearchItemModel>()
                val call1 = async {dataSource.getRepos(0,q)}
                val call2 = async {dataSource.getRepos(1,q)}

                listData.addAll(try {
                    call1.await()
                } catch (e: Exception) {
                    listOf()
                })

                listData.addAll(try {
                    call2.await()
                } catch (e: Exception) {
                    listOf()
                })
                dataMutableLiveData.postValue(listData)
            }
        }
    }
}