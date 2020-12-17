package com.example.tablesrelationships.relations.NtoM

import androidx.room.Entity

//  this is relation table with student & subject table primary keys
//  combination of both fields is the primary key
@Entity(primaryKeys = ["studentName", "subjectName"])
data class StudentSubjectCrossRef(
    val studentName: String, //  primary key of `student` table
    val subjectName: String //  primary key of `subject` table
)