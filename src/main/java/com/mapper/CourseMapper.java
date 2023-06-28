package com.mapper;

import com.entitle.Course;

import java.util.HashMap;
import java.util.List;

public interface CourseMapper {
    List<Course> selectCourses(HashMap hm);
    int selectCoursesCount(HashMap hm);

    List<Course> selectAllCourses(HashMap hm);
    int selectAllCourseCount();
    public int updateCourse(Course ci);
    public int deleteCourse(HashMap hm);

    List<Course> selectCourseByCondition(HashMap hm);
    int selectCourseByConditionCount(HashMap hm);

    int insertCourse(Course c);
}
