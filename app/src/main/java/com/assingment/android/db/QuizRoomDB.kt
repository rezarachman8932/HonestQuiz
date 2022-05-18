package com.assingment.android.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.assingment.android.db.dao.QuizTakenDao
import com.assingment.android.db.entity.QuizUserScoreEntity

@Database(
    entities = [QuizUserScoreEntity::class],
    version = 3
)
abstract class QuizRoomDB : RoomDatabase() {
    abstract fun quizTakenDao(): QuizTakenDao

    companion object {
        private const val DATABASE_VERSION = "v1"

        @Volatile
        private var INSTANCE: QuizRoomDB? = null

        fun getDatabase(context: Context): QuizRoomDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuizRoomDB::class.java,
                    context.packageName + DATABASE_VERSION
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}