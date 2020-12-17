package com.example.tablesrelationships.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity //  we are happy with table name as `Student`
data class Student(
    @PrimaryKey(autoGenerate = false)
    val studentName: String,
    val semester: Int,
    val schoolName: String
)