package com.dm.gitsearch.di

import com.dm.gitsearch.ui.GitViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { GitViewModel(get()) }
}