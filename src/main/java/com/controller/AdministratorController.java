package com.controller;

import com.service.AdministratorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class AdministratorController {
    @Resource(name="administratorService")
    AdministratorService as;

    @ResponseBody
    @RequestMapping(value = "/administrator",
            produces = {"application/json;charset=UTF-8"})
    public Object dispath(HttpServletRequest req){
        HashMap hm = new HashMap();
        switch (req.getParameter("what")){
            case "userInfo_modify":
                hm.put("state", as.handleUpdateUser(req) >= 1 ? "success" : "fail");
                return hm;
            case "userInfo_delete":
                hm.put("state", as.handleDeleteUser(req) >= 1 ? "success" : "fail");
                return hm;
            case "userInfo":
                return as.handleUserInfo(req);
            case "userInfo_count":
                hm.put("count", as.handleUserInfoCount(req));
                return hm;

            case "studentInfo_modify":
                hm.put("state", as.handleUpdateStudent(req) >= 1 ? "success" : "fail");
                return hm;
            case "studentInfo_delete":
                hm.put("state", as.handleDeleteStudent(req) >= 1 ? "success" : "fail");
                return hm;
            case "studentInfo":
                return as.handleStudentInfo(req);
            case "studentInfo_count":
                hm.put("count", as.handleStudentInfoCount(req));
                return hm;

            case "classInfo_modify":
                hm.put("state", as.handleUpdateClass(req) >= 1 ? "success" : "fail");
                return hm;
            case "classInfo_delete":
                hm.put("state", as.handleDeleteClass(req) >= 1 ? "success" : "fail");
                return hm;
            case "classInfo":
                return as.handleClassInfo(req);
            case "classInfo_count":
                hm.put("count", as.handleClassInfoCount(req));
                return hm;

            case "courseInfo_modify":
                hm.put("state", as.handleUpdateCourse(req) >= 1 ? "success" : "fail");
                return hm;
            case "courseInfo_delete":
                hm.put("state", as.handleDeleteCourse(req) >= 1 ? "success" : "fail");
                return hm;
            case "courseInfo":
                return as.handleCourseInfo(req);
            case "courseInfo_count":
                hm.put("count", as.handleCourseInfoCount(req));
                return hm;

            case "courseTableInfo_modify":
                hm.put("state", as.handleUpdateCourseTable(req) >= 1 ? "success" : "fail");
                return hm;
            case "courseTableInfo_delete":
                hm.put("state", as.handleDeleteCourseTable(req) >= 1 ? "success" : "fail");
                return hm;
            case "courseTableInfo":
                return as.handleCourseTableInfo(req);
            case "courseTableInfo_count":
                hm.put("count", as.handleCourseTableInfoCount(req));
                return hm;

            case "scoreInfo_modify":
                hm.put("state", as.handleUpdateScore(req) >= 1 ? "success" : "fail");
                return hm;
            case "scoreInfo_delete":
                hm.put("state", as.handleDeleteScore(req) >= 1 ? "success" : "fail");
                return hm;
            case "scoreInfo":
                return as.handleScoreInfo(req);
            case "scoreInfo_count":
                hm.put("count", as.handleScoreCount(req));
                return hm;

            case "teacherInfo_modify":
                hm.put("state", as.handleUpdateTeacher(req) >= 1 ? "success" : "fail");
                return hm;
            case "teacherInfo_delete":
                hm.put("state", as.handleDeleteTeacher(req) >= 1 ? "success" : "fail");
                return hm;
            case "teacherInfo":
                return as.handleTeacher(req);
            case "teacherInfo_count":
                hm.put("count", as.handleTeacherCount(req));
                return hm;

            case "studentInfo_search":
                return as.handleSelectStudentsByCondition(req);
            case "studentInfo_search_count":
                hm.put("count", as.handleSelectStudentsByConditionCount(req));
                return hm;

            case "classInfo_search":
                return as.handleSelectClassesByCondition(req);
            case "classInfo_search_count":
                hm.put("count", as.handleSelectClassesByConditionCount(req));
                return hm;

            case "courseInfo_search":
                return as.handleSelectCourseByCondition(req);
            case "courseInfo_search_count":
                hm.put("count", as.handleSelectCourseByConditionCount(req));
                return hm;

            case "courseTableInfo_search":
                return as.handleSelectCourseTableByCondition(req);
            case "courseTableInfo_search_count":
                hm.put("count", as.handleSelectCourseTableByConditionCount(req));
                return hm;

            case "scoreInfo_search":
                return as.handleSelectScoreByCondition(req);
            case "scoreInfo_search_count":
                hm.put("count", as.handleSelectScoreByConditionCount(req));
                return hm;

                //信息添加
            case "userInfo_insert":
                hm.put("state", as.handleInsertUser(req) > 0 ? "success" : "fail");
                return hm;
            case "studentInfo_insert":
                hm.put("state", as.handleInsertStudent(req) > 0 ? "success" : "fail");
                return hm;
            case "classInfo_insert":
                hm.put("state", as.handleInsertClass(req) > 0 ? "success" : "fail");
                return hm;
            case "courseInfo_insert":
                hm.put("state", as.handleInsertCourse(req) > 0 ? "success" : "fail");
                return hm;
            case "courseTableInfo_insert":
                hm.put("state", as.handleInsertCourseTable(req) > 0 ? "success" : "fail");
                return hm;
            case "scoreInfo_insert":
                hm.put("state", as.handleInsertScoreInfo(req) > 0 ? "success" : "fail");
                return hm;
            case "teacherInfo_insert":
                hm.put("state", as.handleInsertTeacher(req) > 0 ? "success" : "fail");
                return hm;
            default:
                return null;
        }
    }

}
