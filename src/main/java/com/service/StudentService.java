package com.service;

import com.dao.StudentDao;
import com.entitle.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class StudentService {
    @Resource(name = "studentDao")
    StudentDao sd;
    public Student handlePersonInfo(HttpServletRequest req){
        String stuId = (String)getCookieVaue(req.getCookies(), "userName");
        if(stuId == null) return null;
        Student stu =sd.selectStudent(stuId);
        System.out.println(stu);
        return stu;
    }

    public int handlePersonInfoCount(HttpServletRequest req){
        String stuId = (String)getCookieVaue(req.getCookies(), "userName");
        if(stuId == null) return 0;
        int rt =sd.selectStudentCount(stuId);
        System.out.println(rt);
        return rt;
    }
    public ClassInfo handleClassInfo(HttpServletRequest req){
        String stuId = (String)getCookieVaue(req.getCookies(), "userName");

        if(stuId == null) return null;
        ClassInfo rt = sd.selectClass(stuId);
        System.out.println(rt);
        return rt;
    }

    public int handleClassInfoCount(HttpServletRequest req){
        String stuId = (String)getCookieVaue(req.getCookies(), "userName");

        if(stuId == null) return 0;
        int rt = sd.selectClassCount(stuId);
        System.out.println(rt);
        return rt;
    }

    public List<Course> handleCourseInfo(HttpServletRequest req){
        String stuId = (String)getCookieVaue(req.getCookies(), "userName");

        if(stuId == null) return null;
        List<Course> rt = sd.selectCourse(stuId, Integer.parseInt(req.getParameter("start")), Integer.parseInt(req.getParameter("number")));
        System.out.println(rt);
        return rt;
    }

    private Object getCookieVaue(Cookie[] ck, String name){
        String res = null;
        for(int i = 0; i < ck.length; i++){
            if (ck[i].getName().equals("userName")) {
                res = ck[i].getValue();
                break;
            }
        }
        return res;
    }

    public int handleCourseInfoCount(HttpServletRequest req){
        String stuId = (String)getCookieVaue(req.getCookies(), "userName");

        if(stuId == null) return 0;
        int rt = sd.selectCourseCount(stuId);
        System.out.println(rt);
        return rt;
    }

    public List<Table> handleTableInfo(HttpServletRequest req){
        String stuId = (String)getCookieVaue(req.getCookies(), "userName");

        if(stuId == null) return null;
        List<Table> rt = sd.selectTable(stuId, Integer.parseInt(req.getParameter("start")), Integer.parseInt(req.getParameter("number")));
        System.out.println(rt);
        return rt;
    }

    public int handleTableInfoCount(HttpServletRequest req){
        String stuId = (String)getCookieVaue(req.getCookies(), "userName");

        if(stuId == null) return 0;
        int rt = sd.selectTableCount(stuId);
        System.out.println(rt);
        return rt;
    }

    public int handleScoreInfoCount(HttpServletRequest req){
        String stuId = (String)getCookieVaue(req.getCookies(), "userName");

        if(stuId == null) return 0;
        int rt = sd.selectScoreCount(stuId);
        System.out.println(rt);
        return rt;
    }

    public List<Score> handleScoreInfo(HttpServletRequest req){
        String stuId = (String)getCookieVaue(req.getCookies(), "userName");

        if(stuId == null) return null;
        List<Score> rt = sd.selectScore(stuId, Integer.parseInt(req.getParameter("start")), Integer.parseInt(req.getParameter("number")));
        System.out.println(rt);
        return rt;
    }
}
