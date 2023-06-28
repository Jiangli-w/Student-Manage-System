package com.controller;

import com.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class StudentController {
    @Resource(name="studentService")
    StudentService ss;

    @ResponseBody
    @RequestMapping(value = "/student",
            produces = {"application/json;charset=UTF-8"})
    public Object dispatch(HttpServletRequest req) {
        switch (req.getParameter("what")){
            case "personInfo":
                return ss.handlePersonInfo(req);
            case "classInfo":
                return ss.handleClassInfo(req);
            case "courseInfo":
                return ss.handleCourseInfo(req);
            case "ctInfo":
                return ss.handleTableInfo(req);
            case "scoreInfo":
                return ss.handleScoreInfo(req);
            case "classInfo_count":
                HashMap oj0 = new HashMap();
                oj0.put("count", ss.handleClassInfoCount(req));
                return oj0;
            case "personInfo_count":
                HashMap oj1 = new HashMap();
                oj1.put("count", ss.handlePersonInfoCount(req));
                return oj1;
            case "courseInfo_count":
                HashMap oj2 = new HashMap();
                oj2.put("count", ss.handleCourseInfoCount(req));
                return oj2;
            case "ctInfo_count":
                HashMap oj3 = new HashMap();
                oj3.put("count", ss.handleTableInfoCount(req));
                return oj3;
            case "scoreInfo_count":
                HashMap oj4 = new HashMap();
                oj4.put("count", ss.handleScoreInfoCount(req));
                return oj4;
            default:
                return null;
        }
    }
}
