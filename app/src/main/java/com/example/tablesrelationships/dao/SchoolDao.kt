package com.example.tablesrelationships.dao

import androidx.room.*
import com.example.tablesrelationships.entities.Director
import com.example.tablesrelationships.entities.School
import com.example.tablesrelationships.entities.Student
import com.example.tablesrelationships.entities.Subject
import com.example.tablesrelationships.relations.`1to1`.SchoolAndDirector
import com.example.tablesrelationships.relations.`1toN`.SchoolWithStudents
import com.example.tablesrelationships.relations.NtoM.StudentSubjectCrossRef
import com.example.tablesrelationships.relations.NtoM.StudentWithSubjects

@Dao
interface SchoolDao {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //  1to1 relations
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Transaction    //  for multi thread support
    @Query("""select * from School_table where schoolName=:schoolName""")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector>
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //  1toN releations
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Transaction    //  for multi thread support
    @Query("""select * from School_table where schoolName=:schoolName""")
    suspend fun getSchoolWithStudents(schoolName: String): List<SchoolWithStudents>
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //  NtoM releations
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(studentSubjectCrossRef: StudentSubjectCrossRef)

    @Transaction    //  for multi thread support
    @Query("""select * from Subject where subjectName=:subjectName""")
    suspend fun getStudentsOfSubject(subjectName: String): List<StudentWithSubjects>

    @Transaction    //  for multi thread support
    @Query("""select * from student where studentName=:studentName""")
    suspend fun getSubjectsOfStudent(studentName: String): List<StudentWithSubjects>
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}