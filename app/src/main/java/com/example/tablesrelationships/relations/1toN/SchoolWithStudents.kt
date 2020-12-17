package com.example.tablesrelationships.relations.`1toN`

import androidx.room.Embedded
import androidx.room.Relation
import com.example.tablesrelationships.entities.School
import com.example.tablesrelationships.entities.Student

data class SchoolWithStudents(
    @Embedded
    val school: School,
    @Relation(
        parentColumn = "schoolName",    //  from `School` table
        entityColumn = "schoolName" //  from `Student` table
    )
    val students: List<Student>
)