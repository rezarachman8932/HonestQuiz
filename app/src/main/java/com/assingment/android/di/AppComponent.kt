package com.assingment.android.di

import com.assingment.android.db.QuizRoomDB
import com.assingment.android.view.home.HomeViewModel
import com.assingment.android.view.quiz.QuizRepository
import com.assingment.android.view.quiz.QuizUseCase
import com.assingment.android.view.quiz.QuizViewModel
import com.assingment.android.view.rank.RankRepository
import com.assingment.android.view.rank.RankUseCase
import com.assingment.android.view.rank.RankViewModel
import com.assingment.android.view.score.ScoreViewModel
import com.assingment.android.view.share.SharedUseCase
import com.assingment.android.view.share.SharedViewModel
import com.assingment.android.view.share.SharedViewRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val localModule = module {
    single { QuizRoomDB.getDatabase(get()).quizTakenDao() }
}

val dataSourceModule = module {
    single { SharedViewRepository() }
    single { QuizRepository() }
    single { RankRepository(get()) }
}

val useCaseModule = module {
    single { SharedUseCase(get()) }
    single { QuizUseCase(get()) }
    single { RankUseCase(get()) }
}

val viewModelModule = module {
    viewModel { SharedViewModel(get()) }
    viewModel { QuizViewModel(get()) }
    viewModel { RankViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { ScoreViewModel(get()) }
}

val appComponent: List<Module> = listOf(
    localModule,
    dataSourceModule,
    viewModelModule,
    useCaseModule
)