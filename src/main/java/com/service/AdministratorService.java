package com.service;

import com.dao.AdministratorDao;
import com.entitle.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Service
public class AdministratorService {
    @Resource(name = "administratorDao")
    AdministratorDao ad;

    public int handleUserInfoCount(HttpServletRequest req){
        String adminId = (String)getCookieVaue(req.getCookies(), "userName");

        if(adminId == null) return 0;
        int rt = ad.selectUserCount();
        System.out.println(rt);
        return rt;
    }
    public List<User> handleUserInfo(HttpServletRequest req){
        String adminId = (String)getCookieVaue(req.getCookies(), "userName");

        if(adminId == null) return null;
        List<User> rt = ad.selectUser(Integer.parseInt(req.getParameter("start")), Integer.parseInt(req.getParameter("number")));
        System.out.println(rt.toString());
        return rt;
    }

    public int handleUpdateUser(HttpServletRequest req){
        User u = new User(req.getParameter("user_name"),
                req.getParameter("password"),
                req.getParameter("user_type"));
        System.out.println(u);
        System.out.println(req.getParameter("user_type"));
        int rt = ad.updateUser(u);
        System.out.println(rt);
        return rt;
    }

    public int handleDeleteUser(HttpServletRequest req){
        int rt = ad.deleteUser(req.getParameter("user_name"));

        System.out.println(rt == 1 ? "删除成功" : "删除失败");

        return rt;
    }

    public int handleStudentInfoCount(HttpServletRequest req){
        String adminId = (String)getCookieVaue(req.getCookies(), "userName");

        if(adminId == null) return 0;
        int rt = ad.selectStudentCount();
        System.out.println(rt);
        return rt;
    }
    public List<Student> handleStudentInfo(HttpServletRequest req){
        String adminId = (String)getCookieVaue(req.getCookies(), "userName");

        if(adminId == null) return null;
        List<Student> rt = ad.selectStudents(Integer.parseInt(req.getParameter("start")), Integer.parseInt(req.getParameter("number")));
        System.out.println(rt.toString());
        return rt;
    }

    public int handleUpdateStudent(HttpServletRequest req){
        Student stu = new Student(req.getParameter("stu_id"),
                req.getParameter("stu_name"),
                req.getParameter("stu_sex"),
                req.getParameter("stu_birth"),
                req.getParameter("stu_special"),
                req.getParameter("stu_class_id"),
                req.getParameter("stu_address"),
                req.getParameter("stu_phone"),
                req.getParameter("stu_note"));
        System.out.println(stu);

        int rt = ad.updateStudent(stu);
        System.out.println(rt == 1 ? "更新成功" : "更新失败");
        return rt;
    }

    public int handleDeleteStudent(HttpServletRequest req){
        int rt = ad.deleteStudent(req.getParameter("stu_id"));

        System.out.println(rt == 1 ? "删除成功" : "删除失败");

        return rt;
    }


    public int handleClassInfoCount(HttpServletRequest req){
        String adminId = (String)getCookieVaue(req.getCookies(), "userName");

        if(adminId == null) return 0;
        int rt = ad.selectClassCount();
        System.out.println(rt);
        return rt;
    }
    public List<ClassInfo> handleClassInfo(HttpServletRequest req){
        String adminId = (String)getCookieVaue(req.getCookies(), "userName");

        if(adminId == null) return null;
        List<ClassInfo> rt = ad.selectClasses(Integer.parseInt(req.getParameter("start")), Integer.parseInt(req.getParameter("number")));
        System.out.println(rt.toString());
        return rt;
    }

    public int handleUpdateClass(HttpServletRequest req){
        ClassInfo ci = new ClassInfo(req.getParameter("class_id"),
                req.getParameter("class_name"),
                req.getParameter("class_special"),
                Integer.parseInt(req.getParameter("class_number")),
                req.getParameter("class_year"),
                req.getParameter("class_instructor"));
        System.out.println(ci);

        int rt = ad.updateClass(ci);
        System.out.println(rt == 1 ? "更新成功" : "更新失败");
        return rt;
    }

    public int handleDeleteClass(HttpServletRequest req){
        int rt = ad.deleteClass(req.getParameter("class_id"));
        System.out.println(req.getParameter("class_id"));
        System.out.println(rt == 1 ? "删除成功" : "删除失败");

        return rt;
    }


    public int handleCourseInfoCount(HttpServletRequest req){
        String adminId = (String)getCookieVaue(req.getCookies(), "userName");

        if(adminId == null) return 0;
        int rt = ad.selectCourseCount();
        System.out.println(rt);
        return rt;
    }
    public List<Course> handleCourseInfo(HttpServletRequest req){
        String adminId = (String)getCookieVaue(req.getCookies(), "userName");

        if(adminId == null) return null;
        List<Course> rt = ad.selectCourse(Integer.parseInt(req.getParameter("start")), Integer.parseInt(req.getParameter("number")));
        System.out.println(rt.toString());
        return rt;
    }

    public int handleUpdateCourse(HttpServletRequest req){
        Course c = new Course(req.getParameter("course_id"),
                req.getParameter("course_name"),
                req.getParameter("course_hours"),
                req.getParameter("course_credit"));
        System.out.println(c);

        int rt = ad.updateCourse(c);
        System.out.println(rt == 1 ? "更新成功" : "更新失败");
        return rt;
    }

    public int handleDeleteCourse(HttpServletRequest req){
        int rt = ad.deleteCourse(req.getParameter("course_id"));
        System.out.println(req.getParameter("course_id"));
        System.out.println(rt == 1 ? "删除成功" : "删除失败");

        return rt;
    }



    public int handleCourseTableInfoCount(HttpServletRequest req){
        String adminId = (String)getCookieVaue(req.getCookies(), "userName");

        if(adminId == null) return 0;
        int rt = ad.selectCourseTableCount();
        System.out.println(rt);
        return rt;
    }
    public List<CourseTable> handleCourseTableInfo(HttpServletRequest req){
        String adminId = (String)getCookieVaue(req.getCookies(), "userName");

        if(adminId == null) return null;
        List<CourseTable> rt = ad.selectCourseTable(Integer.parseInt(req.getParameter("start")), Integer.parseInt(req.getParameter("number")));
        System.out.println(rt.toString());
        return rt;
    }

    public int handleUpdateCourseTable(HttpServletRequest req){
        CourseTable ct = new CourseTable(req.getParameter("ct_id"),
                req.getParameter("course_id"),
                req.getParameter("class_id"),
                req.getParameter("teacher_id"),
                req.getParameter("time"),
                req.getParameter("place"));
        System.out.println(ct);

        int rt = ad.updateCourseTable(ct);
        System.out.println(rt == 1 ? "更新成功" : "更新失败");
        return rt;
    }

    public int handleDeleteCourseTable(HttpServletRequest req){
        int rt = ad.deleteCourseTable(req.getParameter("ct_id"));
        System.out.println(req.getParameter("ct_id"));
        System.out.println(rt == 1 ? "删除成功" : "删除失败");

        return rt;
    }



    public int handleScoreCount(HttpServletRequest req){
        String adminId = (String)getCookieVaue(req.getCookies(), "userName");

        if(adminId == null) return 0;
        int rt = ad.selectScoreCount();
        System.out.println(rt);
        return rt;
    }
    public List<ScoreInfo> handleScoreInfo(HttpServletRequest req){
        String adminId = (String)getCookieVaue(req.getCookies(), "userName");

        if(adminId == null) return null;
        List<ScoreInfo> rt = ad.selectScore(Integer.parseInt(req.getParameter("start")), Integer.parseInt(req.getParameter("number")));
        System.out.println(rt.toString());
        return rt;
    }

    public int handleUpdateScore(HttpServletRequest req){
        ScoreInfo si = new ScoreInfo(req.getParameter("stu_id"),
                req.getParameter("course_id"),
                Integer.parseInt(req.getParameter("score")));
        System.out.println(si);

        int rt = ad.updateScore(si);
        System.out.println(rt == 1 ? "更新成功" : "更新失败");
        return rt;
    }

    public int handleDeleteScore(HttpServletRequest req){
        System.out.println(req.getParameter("stu_id"));
        System.out.println(req.getParameter("course_id"));
        int rt = ad.deleteScore(req.getParameter("stu_id"), req.getParameter("course_id"));

        System.out.println(rt == 1 ? "删除成功" : "删除失败");

        return rt;
    }



    public int handleTeacherCount(HttpServletRequest req){
        String adminId = (String)getCookieVaue(req.getCookies(), "userName");

        if(adminId == null) return 0;
        int rt = ad.selectTeacherCount();
        System.out.println(rt);
        return rt;
    }
    public List<Teacher> handleTeacher(HttpServletRequest req){
        String adminId = (String)getCookieVaue(req.getCookies(), "userName");

        if(adminId == null) return null;
        List<Teacher> rt = ad.selectTeacher(Integer.parseInt(req.getParameter("start")), Integer.parseInt(req.getParameter("number")));
        System.out.println(rt.toString());
        return rt;
    }

    public int handleUpdateTeacher(HttpServletRequest req){
        Teacher t = new Teacher(req.getParameter("tc_id"),
                req.getParameter("tc_name"),
                req.getParameter("tc_sex"),
                req.getParameter("tc_birth"),
                req.getParameter("tc_depart"),
                req.getParameter("tc_phone"));
        System.out.println(t);

        int rt = ad.updateTeacher(t);
        System.out.println(rt == 1 ? "更新成功" : "更新失败");
        return rt;
    }

    public int handleDeleteTeacher(HttpServletRequest req){
        System.out.println(req.getParameter("tc_id"));

        int rt = ad.deleteTeacher(req.getParameter("tc_id"));

        System.out.println(rt == 1 ? "删除成功" : "删除失败");

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

    public List<Student> handleSelectStudentsByCondition(HttpServletRequest req){
        String conditionKey = req.getParameter("conditionKey");
        String conditionValue = req.getParameter("conditionValue");
        int start = Integer.parseInt(req.getParameter("start"));
        int number = Integer.parseInt(req.getParameter("number"));
        HashMap hm = new HashMap();
        hm.put(conditionKey, conditionValue);
        hm.put("start", start);
        hm.put("number", number);
        List<Student> rt = ad.selectStudentsByCondition(hm);
        System.out.println(rt);
        return rt;
    }

    public int handleSelectStudentsByConditionCount(HttpServletRequest req) {
        String conditionKey = req.getParameter("conditionKey");
        String conditionValue = req.getParameter("conditionValue");
        HashMap hm = new HashMap();
        hm.put(conditionKey, conditionValue);
        int rt = ad.selectStudentsByConditionCount(hm);
        System.out.println(rt);
        return rt;
    }

    public List<ClassInfo> handleSelectClassesByCondition(HttpServletRequest req){
        String conditionKey = req.getParameter("conditionKey");
        String conditionValue = req.getParameter("conditionValue");
        int start = Integer.parseInt(req.getParameter("start"));
        int number = Integer.parseInt(req.getParameter("number"));
        HashMap hm = new HashMap();
        hm.put(conditionKey, conditionValue);
        hm.put("start", start);
        hm.put("number", number);
        List<ClassInfo> rt = ad.selectClassesByCondition(hm);
        System.out.println(rt);
        return rt;
    }

    public int handleSelectClassesByConditionCount(HttpServletRequest req) {
        String conditionKey = req.getParameter("conditionKey");
        String conditionValue = req.getParameter("conditionValue");
        HashMap hm = new HashMap();
        hm.put(conditionKey, conditionValue);
        int rt = ad.selectClassesByConditionCount(hm);
        System.out.println(rt);
        return rt;
    }

    public List<Course> handleSelectCourseByCondition(HttpServletRequest req){
        String conditionKey = req.getParameter("conditionKey");
        String conditionValue = req.getParameter("conditionValue");
        int start = Integer.parseInt(req.getParameter("start"));
        int number = Integer.parseInt(req.getParameter("number"));
        HashMap hm = new HashMap();
        hm.put(conditionKey, conditionValue);
        hm.put("start", start);
        hm.put("number", number);
        List<Course> rt = ad.selectCourseByCondition(hm);
        System.out.println(rt);
        return rt;
    }

    public int handleSelectCourseByConditionCount(HttpServletRequest req) {
        String conditionKey = req.getParameter("conditionKey");
        String conditionValue = req.getParameter("conditionValue");
        HashMap hm = new HashMap();
        hm.put(conditionKey, conditionValue);
        int rt = ad.selectCourseByConditionCount(hm);
        System.out.println(rt);
        return rt;
    }

    public List<CourseTable> handleSelectCourseTableByCondition(HttpServletRequest req){
        String conditionKey = req.getParameter("conditionKey");
        String conditionValue = req.getParameter("conditionValue");
        int start = Integer.parseInt(req.getParameter("start"));
        int number = Integer.parseInt(req.getParameter("number"));
        HashMap hm = new HashMap();
        hm.put(conditionKey, conditionValue);
        hm.put("start", start);
        hm.put("number", number);
        List<CourseTable> rt = ad.selectCourseTableByCondition(hm);
        System.out.println(rt);
        return rt;
    }

    public int handleSelectCourseTableByConditionCount(HttpServletRequest req) {
        String conditionKey = req.getParameter("conditionKey");
        String conditionValue = req.getParameter("conditionValue");
        HashMap hm = new HashMap();
        hm.put(conditionKey, conditionValue);
        int rt = ad.selectCourseTableByConditionCount(hm);
        System.out.println(rt);
        return rt;
    }

    public List<ScoreInfo> handleSelectScoreByCondition(HttpServletRequest req){
        String conditionKey = req.getParameter("conditionKey");
        String conditionValue = req.getParameter("conditionValue");
        int start = Integer.parseInt(req.getParameter("start"));
        int number = Integer.parseInt(req.getParameter("number"));
        if(conditionKey.equals("interval")){
            return handleSelectScoreByInterval(req);
        }else{
            HashMap hm = new HashMap();
            hm.put(conditionKey, conditionValue);
            hm.put("start", start);
            hm.put("number", number);
            List<ScoreInfo> rt = ad.selectScoreByCondition(hm);
            System.out.println(rt);
            return rt;
        }
    }

    public int handleSelectScoreByConditionCount(HttpServletRequest req) {
        String conditionKey = req.getParameter("conditionKey");
        String conditionValue = req.getParameter("conditionValue");
        if(conditionKey.equals("interval")){
            return handleSelectScoreByIntervalCount(req);
        }else{
        HashMap hm = new HashMap();
        hm.put(conditionKey, conditionValue);
        int rt = ad.selectScoreByConditionCount(hm);
        System.out.println(rt);
        return rt;
        }

    }

    public int handleInsertUser(HttpServletRequest req){
        User u = new User(req.getParameter("user_name"),
                req.getParameter("password"),
                req.getParameter("user_type"));
        System.out.println(u);
        return ad.insertUser(u);
    }
    public int handleInsertStudent(HttpServletRequest req){
        Student s = new Student(req.getParameter("stu_id"),
                req.getParameter("stu_name"),
                req.getParameter("stu_sex"),
                req.getParameter("stu_birth"),
                req.getParameter("stu_special"),
                req.getParameter("stu_class_id"),
                req.getParameter("stu_address"),
                req.getParameter("stu_phone"),
                req.getParameter("stu_note"));
        System.out.println(s);
        return ad.insertStudent(s);
    }


    public int handleInsertClass(HttpServletRequest req){
        ClassInfo ci = new ClassInfo(req.getParameter("class_id"),
                req.getParameter("class_name"),
                req.getParameter("class_special"),
                Integer.parseInt(req.getParameter("class_number")),
                req.getParameter("class_year"),
                req.getParameter("class_instructor"));
        System.out.println(ci);
        return ad.insertClass(ci);
    }
    public int handleInsertCourse(HttpServletRequest req){
        Course c = new Course(req.getParameter("course_id"),
                req.getParameter("course_name"),
                req.getParameter("course_hours"),
                req.getParameter("course_credit"));
        System.out.println(c);
        return ad.insertCourse(c);
    }
    public int handleInsertCourseTable(HttpServletRequest req){
        CourseTable ct = new CourseTable(req.getParameter("ct_id"),
                req.getParameter("course_id"),
                req.getParameter("class_id"),
                req.getParameter("teacher_id"),
                req.getParameter("time"),
                req.getParameter("place"));
        System.out.println(ct);
        return ad.insertCourseTable(ct);
    }
    public int handleInsertScoreInfo(HttpServletRequest req){
        ScoreInfo si = new ScoreInfo(req.getParameter("stu_id"),
                req.getParameter("course_id"),
                Integer.parseInt(req.getParameter("score")));
        System.out.println(si);
        return ad.insertScore(si);
    }
    public int handleInsertTeacher(HttpServletRequest req){
        Teacher t = new Teacher(req.getParameter("tc_id"),
                req.getParameter("tc_name"),
                req.getParameter("tc_sex"),
                req.getParameter("tc_birth"),
                req.getParameter("tc_depart"),
                req.getParameter("tc_phone"));
        System.out.println(t);
        return ad.insertTeacher(t);
    }
    List<ScoreInfo> handleSelectScoreByInterval(HttpServletRequest req){
        String conditionKey = req.getParameter("conditionKey");
        String conditionValue = req.getParameter("conditionValue");
        int start = Integer.parseInt(req.getParameter("start"));
        int number = Integer.parseInt(req.getParameter("number"));
        String[] arr = conditionValue.split(",");
        HashMap hm = new HashMap();
        hm.put("begin", arr[0]);
        hm.put("end", arr[1]);
        hm.put("start", start);
        hm.put("number", number);
        List<ScoreInfo> rt = ad.selectScoreByInterval(hm);
        System.out.println(rt);
        return rt;
    }
    int handleSelectScoreByIntervalCount(HttpServletRequest req){
        String conditionKey = req.getParameter("conditionKey");
        String conditionValue = req.getParameter("conditionValue");
        String[] arr = conditionValue.split(",");
        HashMap hm = new HashMap();
        hm.put("begin", arr[0]);
        hm.put("end", arr[1]);
        int rt = ad.selectScoreByIntervalCount(hm);
        System.out.println(rt);
        return rt;
    }


}
