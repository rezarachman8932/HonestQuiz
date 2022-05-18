package com.assingment.android.view.score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assingment.android.model.QuizUserTaken
import com.assingment.android.view.rank.RankUseCase
import kotlinx.coroutines.launch

class ScoreViewModel(private val rankUseCase: RankUseCase) : ViewModel() {

    fun addToDatabase(newUser: QuizUserTaken) {
        viewModelScope.launch { rankUseCase.addNewUser(newUser) }
    }

}