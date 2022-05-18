package com.assingment.android.view.quiz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.assingment.android.model.Data
import com.assingment.android.model.QuizQuestion

class QuizViewModel(private val quizUseCase: QuizUseCase): ViewModel() {

    private var _quizQuestions = MutableLiveData<List<QuizQuestion>>()
    var quizQuestions : LiveData<List<QuizQuestion>> = _quizQuestions

    var page = 0

    fun getQuiz() {
        _quizQuestions.postValue(quizUseCase.getQuiz().shuffled())
    }

}
