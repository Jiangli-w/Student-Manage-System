package com.service;

import com.dao.TeacherDao;
import com.entitle.Score;
import com.entitle.Table;
import com.entitle.Teacher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class TeacherService {
    @Resource(name = "teacherDao")
    TeacherDao td;

    public Teacher handlePersonInfo(HttpServletRequest req){
        String tcId = (String)getCookieVaue(req.getCookies(), "userName");
        if(tcId == null) return null;
        Teacher tc =td.selectTeacher(tcId);
        System.out.println(tc);
        return tc;
    }

    public int handlePersonInfoCount(HttpServletRequest req){
        String tcId = (String)getCookieVaue(req.getCookies(), "userName");
        if(tcId == null) return 0;
        int rt =td.selectTeacherCount(tcId);
        System.out.println(rt);
        return rt;
    }
    public List<Table> handleTableInfo(HttpServletRequest req){
        String tcId = (String)getCookieVaue(req.getCookies(), "userName");

        if(tcId == null) return null;
        List<Table> rt = td.selectTable(tcId, Integer.parseInt(req.getParameter("start")), Integer.parseInt(req.getParameter("number")));
        System.out.println(rt.toString());
        return rt;
    }

    public int handleTableInfoCount(HttpServletRequest req){
        String tcId = (String)getCookieVaue(req.getCookies(), "userName");

        if(tcId == null) return 0;
        int rt = td.selectTableCount(tcId);
        System.out.println(rt);
        return rt;
    }

    public List<Score> handleScoreInfo(HttpServletRequest req){
        String tcId = (String)getCookieVaue(req.getCookies(), "userName");

        if(tcId == null) return null;
        List<Score> rt = td.selectScore(tcId, Integer.parseInt(req.getParameter("start")), Integer.parseInt(req.getParameter("number")));
        System.out.println(rt.toString());
        return rt;
    }

    public int handleScoreInfoCount(HttpServletRequest req){
        String tcId = (String)getCookieVaue(req.getCookies(), "userName");

        if(tcId == null) return 0;
        int rt = td.selectScoreCount(tcId);
        System.out.println(rt);
        return rt;
    }

    public int handleChangeScoreInfo(HttpServletRequest req){
        System.out.println(req.getParameter("stuId"));
        return td.insertScore(req.getParameter("stuId"),
                req.getParameter("courId"),
                req.getParameter("score"));
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
}
