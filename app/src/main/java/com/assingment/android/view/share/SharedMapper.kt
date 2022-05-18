package com.assingment.android.view.share

import com.assingment.android.db.entity.QuizUserScoreEntity
import com.assingment.android.model.QuizUserTaken

fun QuizUserScoreEntity.toDomain(): QuizUserTaken {
    return QuizUserTaken(
        name = name,
        score = score
    )
}

fun QuizUserTaken.toEntity(): QuizUserScoreEntity {
    return QuizUserScoreEntity(
        name = name,
        score = score
    )
}