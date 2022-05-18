package com.assingment.android.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.assingment.android.db.entity.QuizUserScoreEntity

@Dao
interface QuizTakenDao {
    @Query("SELECT * FROM user_score")
    suspend fun getQuizTakenUser(): MutableList<QuizUserScoreEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewUser(vararg newUser: QuizUserScoreEntity)

    @Query("SELECT * FROM user_score WHERE name = :name")
    suspend fun getUserByName(name: String): QuizUserScoreEntity?
}