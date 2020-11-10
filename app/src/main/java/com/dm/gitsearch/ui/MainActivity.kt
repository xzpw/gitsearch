package com.dm.gitsearch.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.dm.gitsearch.R
import com.dm.gitsearch.data.DataSource
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class MainActivity : AppCompatActivity() {
    val dataSource: DataSource by inject(DataSource::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launch {
            val d = dataSource.getRepos(1,"kot")
            Log.d("mylog", "count ${d.size} firs ${d.first().stars} last ${d.last().stars}")
        }
    }
}