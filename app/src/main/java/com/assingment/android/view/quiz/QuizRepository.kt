package com.assingment.android.view.quiz

import com.assingment.android.model.Data
import com.assingment.android.model.QuizQuestion

class QuizRepository {

    fun getQuiz(): List<QuizQuestion> {
        //get quiz is very long and heavy operation. To simulate it we add a nested for loop
        for (i in 1..100000) {
            for (j in 1..100000) {}
        }
        return Data.quizQuestions
    }
}
