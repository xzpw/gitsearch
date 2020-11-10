package com.dm.gitsearch.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dm.gitsearch.R
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    val viewModel: GitViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getSearchData("cs")
        viewModel.dataLiveData.observe(this) {
            Log.d("mylog","${it.size}")
        }
    }
}