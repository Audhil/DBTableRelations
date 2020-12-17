package com.example.tablesrelationships.relations.`1to1`

import androidx.room.Embedded
import androidx.room.Relation
import com.example.tablesrelationships.entities.Director
import com.example.tablesrelationships.entities.School

data class SchoolAndDirector(
    @Embedded
    val school: School,
    @Relation(
        parentColumn = "schoolName",    //  schoolName of School table
        entityColumn = "schoolName" //  schoolName of Director table
    )
    val director: Director
)