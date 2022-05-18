package com.assingment.android.view.rank

import com.assingment.android.db.dao.QuizTakenDao
import com.assingment.android.db.entity.QuizUserScoreEntity

class RankRepository(private val dao: QuizTakenDao) {

    suspend fun getScoreRankData(): MutableList<QuizUserScoreEntity> {
        return dao.getQuizTakenUser()
    }

    suspend fun addNewQuizTakenUser(newQuizUserTaken: QuizUserScoreEntity) {
        dao.insertNewUser(newQuizUserTaken)
    }

    suspend fun getUserByName(name: String): QuizUserScoreEntity? {
        return dao.getUserByName(name)
    }

}