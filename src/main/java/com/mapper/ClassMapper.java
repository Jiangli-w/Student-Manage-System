package com.mapper;

import com.entitle.ClassInfo;

import java.util.HashMap;
import java.util.List;

public interface ClassMapper {
    ClassInfo selectClass(HashMap mp);
    List<ClassInfo> selectClasses(HashMap hm);
    int selectClassCount();
    public int updateClass(ClassInfo ci);
    public int deleteClass(HashMap hm);
    List<ClassInfo> selectClassesByCondition(HashMap hm);
    int selectClassesByConditionCount(HashMap hm);

    int insertClass(ClassInfo c);
}
