package com.assingment.android.view.rank

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assingment.android.model.QuizUserTaken
import kotlinx.coroutines.launch

class RankViewModel(private val rankUseCase: RankUseCase) : ViewModel() {

    private val _rankScoreList = MutableLiveData<MutableList<QuizUserTaken>>()
    val rankScoreList : LiveData<MutableList<QuizUserTaken>> = _rankScoreList

    fun getScoreRankFromDB() {
        viewModelScope.launch { _rankScoreList.postValue(rankUseCase.getScoreRank()) }
    }

}