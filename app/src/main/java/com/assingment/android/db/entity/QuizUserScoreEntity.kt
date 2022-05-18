package com.assingment.android.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_score")
data class QuizUserScoreEntity(
    var name: String?,
    var score: Int?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}