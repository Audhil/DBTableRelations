package com.example.tablesrelationships.relations.NtoM

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.tablesrelationships.entities.Student
import com.example.tablesrelationships.entities.Subject

data class SubjectWithStudents(
    @Embedded
    val student: Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",    //  foreign column
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val students: List<Student>
)