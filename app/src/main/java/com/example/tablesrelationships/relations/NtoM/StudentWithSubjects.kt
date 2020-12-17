package com.example.tablesrelationships.relations.NtoM

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.tablesrelationships.entities.Student
import com.example.tablesrelationships.entities.Subject

data class StudentWithSubjects(
    @Embedded
    val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",    //  foreign column
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<Subject>
)