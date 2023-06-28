package com.mapper;

import com.entitle.CourseTable;
import com.entitle.Table;

import java.util.HashMap;
import java.util.List;

public interface TableMapper {
    List<Table> selectTable(HashMap hm);
    int selectTableCount(HashMap hm);

    List<CourseTable> selectCourseTable(HashMap hm);
    int selectCourseTableCount();
    public int updateCourseTable(CourseTable ci);
    public int deleteCourseTable(HashMap hm);

    List<CourseTable> selectCourseTableByCondition(HashMap hm);
    int selectCourseTableByConditionCount(HashMap hm);

    int insertCourseTable(CourseTable ct);
}
