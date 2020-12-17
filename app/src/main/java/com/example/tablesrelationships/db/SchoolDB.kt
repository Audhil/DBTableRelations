package com.example.tablesrelationships.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tablesrelationships.dao.SchoolDao
import com.example.tablesrelationships.entities.Director
import com.example.tablesrelationships.entities.School
import com.example.tablesrelationships.entities.Student
import com.example.tablesrelationships.entities.Subject
import com.example.tablesrelationships.relations.NtoM.StudentSubjectCrossRef

@Database(
    entities = [
        Director::class,
        School::class,
        Student::class,
        Subject::class,
        StudentSubjectCrossRef::class
    ],
    version = 1
)
abstract class SchoolDB : RoomDatabase() {

    abstract val schoolDao: SchoolDao

    companion object {

        @Volatile
        private var INSTANCE: SchoolDB? = null

        fun getInstance(context: Context): SchoolDB {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDB::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}