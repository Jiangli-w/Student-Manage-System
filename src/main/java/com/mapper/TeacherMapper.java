package com.mapper;


import com.entitle.Teacher;

import java.util.HashMap;
import java.util.List;

public interface TeacherMapper {
    Teacher selectTeacher(HashMap hm);

    public int selectTeacherCount(HashMap hm);

    public List<Teacher> selectTeachers(HashMap hm);

    public int updateTeacher(Teacher t);

    public int deleteTeacher(HashMap hm);

    int insertTeacher(Teacher t);
}
