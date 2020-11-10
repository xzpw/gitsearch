package com.dm.gitsearch.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.dm.gitsearch.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    val viewModel: GitViewModel by viewModel()
    val adapter = GitAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter

        viewModel.dataLiveData.observe(this) {
            Log.d("mylog","${it.size}")
            adapter.setGitData(it)
        }

        button.setOnClickListener {
            viewModel.getSearchData(editText.text.toString())
        }
    }
}