package com.assingment.android.view.rank

import com.assingment.android.model.QuizUserTaken
import com.assingment.android.view.share.toDomain
import com.assingment.android.view.share.toEntity

class RankUseCase(private val rankRepository: RankRepository) {

    suspend fun getScoreRank(): MutableList<QuizUserTaken> {
        val tempList = mutableListOf<QuizUserTaken>()
        val scoreDataList = rankRepository.getScoreRankData()

        if (!scoreDataList.isNullOrEmpty()) {
            scoreDataList.forEach { tempList.add(it.toDomain()) }
        }

        return tempList
    }

    suspend fun addNewUser(user: QuizUserTaken) {
        rankRepository.addNewQuizTakenUser(user.toEntity())
    }

    suspend fun getUserByName(name: String): QuizUserTaken? {
        return rankRepository.getUserByName(name)?.let { it.toDomain() }
    }

}