package com.example.tablesrelationships.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Dir_table")
data class Director(
    @PrimaryKey(autoGenerate = false)
    val directorName: String,
    val schoolName: String
)