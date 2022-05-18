package com.assingment.android.view.quiz

import com.assingment.android.model.QuizQuestion

class QuizUseCase(private val quizRepository: QuizRepository) {

    fun getQuiz(): List<QuizQuestion> {
        return quizRepository.getQuiz()
    }

}