package com.assingment.android.view.share

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.assingment.android.model.QuizQuestion

class SharedViewModel(
    private val sharedUseCase: SharedUseCase
) : ViewModel() {

    private val _name = MutableLiveData<String>()
    val name : LiveData<String> = _name

    private val _correctAnswers = MutableLiveData<MutableList<QuizQuestion>>()
    val correctAnswers : LiveData<MutableList<QuizQuestion>> = _correctAnswers

    val pairedViewModel = SharedPairLiveData(_name, _correctAnswers)

    fun setName(name: String) {
        _name.postValue(name)

        // If we need an access to API or local database
        sharedUseCase.setName(name)
    }

    fun addNewCorrectAnswer(item: QuizQuestion) {
        var answerList = correctAnswers.value

        if (answerList.isNullOrEmpty()) {
            answerList = mutableListOf()
        }

        answerList.add(item)
        answerList.let { _correctAnswers.postValue(it) }
    }

}
