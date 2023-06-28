package com.mapper;

import com.entitle.Student;

import java.util.HashMap;
import java.util.List;

public interface StudentMapper {
    List<Student> selectStudents(HashMap hm);
    Student selectStudent(HashMap hm);
    int selectStudentCount();
    public int updateStudent(Student stu);
    public int deleteStudent(HashMap hm);

    List<Student> selectStudentsByCondition(HashMap hm);
    int selectStudentsByConditionCount(HashMap hm);

    int insertStudent(Student s);
}
