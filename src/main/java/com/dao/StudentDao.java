package com.dao;

import com.entitle.*;
import com.mapper.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentDao {

    public Student selectStudent(String stuId){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        HashMap hm = new HashMap();
        hm.put("stuId", stuId);

        Student rt = mapper.selectStudent(hm);
        sqlSession.close();
        return rt;
    }

    public int selectStudentCount(String stuId){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        HashMap hm = new HashMap();
        hm.put("stu_id", stuId);

        int rt = mapper.selectStudentsByConditionCount(hm);
        sqlSession.close();
        return rt;
    }

    public ClassInfo selectClass(String stuId){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        StudentMapper stuMapper = sqlSession.getMapper(StudentMapper.class);

        HashMap hm = new HashMap();
        hm.put("stuId", stuId);

        Student stu = stuMapper.selectStudent(hm);
        System.out.println(stu);

        if (stu == null) {
            sqlSession.close();
            return null;
        }

        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);

        hm.put("classId", stu.getStu_class_id());

        ClassInfo rt = classMapper.selectClass(hm);
        sqlSession.close();
        return rt;
    }

    public int selectClassCount(String stuId){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        StudentMapper stuMapper = sqlSession.getMapper(StudentMapper.class);

        HashMap hm = new HashMap();
        hm.put("stuId", stuId);

        Student stu = stuMapper.selectStudent(hm);

        if(stu == null){
            sqlSession.close();
            return 0;
        }
        System.out.println(stu);

        if (stu == null) {
            sqlSession.close();
            return 0;
        }

        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);

        hm.put("course_id", stu.getStu_class_id());

        int rt = classMapper.selectClassesByConditionCount(hm);
        sqlSession.close();
        return rt;
    }

    public List<Course> selectCourse(String stuId, int start, int number){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        StudentMapper stuMapper = sqlSession.getMapper(StudentMapper.class);

        HashMap hm = new HashMap();
        hm.put("stuId", stuId);

        Student stu = stuMapper.selectStudent(hm);

        if (stu == null) {
            sqlSession.close();
            return null;
        }

        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);

        hm.put("start", start);
        hm.put("number", number);
        hm.put("classId", stu.getStu_class_id());
        List<Course> rt = courseMapper.selectCourses(hm);

        sqlSession.close();
        return rt;
    }

    public int selectCourseCount(String stuId){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        StudentMapper stuMapper = sqlSession.getMapper(StudentMapper.class);

        HashMap hm = new HashMap();
        hm.put("stuId", stuId);

        Student stu = stuMapper.selectStudent(hm);

        if (stu == null) {
            sqlSession.close();
            return 0;
        }
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);

        hm.put("classId", stu.getStu_class_id());
        int rt = courseMapper.selectCoursesCount(hm);

        sqlSession.close();
        return rt;
    }

    public List<Table> selectTable(String stuId, int start, int number){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        StudentMapper stuMapper = sqlSession.getMapper(StudentMapper.class);

        HashMap hm = new HashMap();
        hm.put("stuId", stuId);

        Student stu = stuMapper.selectStudent(hm);
        if(stu == null) {
            sqlSession.close();
            return null;
        }
        TableMapper tableMapper = sqlSession.getMapper(TableMapper.class);

        hm.put("start", start);
        hm.put("number", number);
        hm.put("classId", stu.getStu_class_id());
        List<Table> rt = tableMapper.selectTable(hm);

        sqlSession.close();
        return rt;
    }

    public int selectTableCount(String stuId){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        StudentMapper stuMapper = sqlSession.getMapper(StudentMapper.class);

        HashMap hm = new HashMap();
        hm.put("stuId", stuId);

        Student stu = stuMapper.selectStudent(hm);
        if (stu == null) {
            sqlSession.close();
            return 0;
        }
        TableMapper tableMapper = sqlSession.getMapper(TableMapper.class);

        hm.put("classId", stu.getStu_class_id());
        int rt = tableMapper.selectTableCount(hm);

        sqlSession.close();
        return rt;
    }

    public int selectScoreCount(String stuId){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        HashMap hm = new HashMap();
        hm.put("stuId", stuId);
        ScoreMapper scoreMapper = sqlSession.getMapper(ScoreMapper.class);

        int rt = scoreMapper.selectScoreCount(hm);

        sqlSession.close();
        return rt;
    }

    public List<Score> selectScore(String stuId, int start, int number){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        HashMap hm = new HashMap();
        hm.put("stuId", stuId);
        hm.put("start", start);
        hm.put("number", number);
        ScoreMapper scoreMapper = sqlSession.getMapper(ScoreMapper.class);

        List<Score> rt = scoreMapper.selectScore(hm);

        sqlSession.close();
        return rt;
    }
}
