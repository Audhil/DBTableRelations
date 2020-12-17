package com.example.tablesrelationships.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "School_table")
data class School(
    @PrimaryKey(autoGenerate = false)
    val schoolName: String
)