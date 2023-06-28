package com.dao;

import com.entitle.*;
import com.mapper.CourseMapper;
import com.mapper.ScoreMapper;
import com.mapper.TableMapper;
import com.mapper.TeacherMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class TeacherDao {
    public Teacher selectTeacher(String tcId){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        HashMap hm = new HashMap();
        hm.put("tcId", tcId);

        Teacher rt = mapper.selectTeacher(hm);
        sqlSession.close();
        return rt;
    }

    public int selectTeacherCount(String tcId){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        HashMap hm = new HashMap();
        hm.put("tc_id", tcId);

        int rt = mapper.selectTeacherCount(hm);
        sqlSession.close();
        return rt;
    }

    public List<Table> selectTable(String tcId, int start, int number){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        HashMap hm = new HashMap();

        TableMapper tableMapper = sqlSession.getMapper(TableMapper.class);

        hm.put("start", start);
        hm.put("number", number);
        hm.put("tcId", tcId);
        List<Table> rt = tableMapper.selectTable(hm);

        sqlSession.close();
        return rt;
    }

    public int selectTableCount(String tcId){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        TableMapper tableMapper = sqlSession.getMapper(TableMapper.class);
        HashMap hm = new HashMap();
        hm.put("tcId", tcId);
        int rt = tableMapper.selectTableCount(hm);

        sqlSession.close();
        return rt;
    }


    public int selectScoreCount(String tcId){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        HashMap hm = new HashMap();
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);

        hm.put("tcId", tcId);
        hm.put("start", 0);
        hm.put("number", Integer.MAX_VALUE);   //所有行
        List<Course> courses = courseMapper.selectCourses(hm);
        if(courses == null){
            sqlSession.close();
            return 0;
        }

        ScoreMapper scoreMapper = sqlSession.getMapper(ScoreMapper.class);
        List<Score> rt = new ArrayList();
        int cur = 0, cout = 0;
        for(Course course : courses){
            hm.put("courId", course.getCourse_id());

            List<Score> scores = scoreMapper.selectScore(hm);
            if(scores == null) continue;
            rt.addAll(scores);
        }

        sqlSession.close();
        return rt.size();
    }


    public List<Score> selectScore(String tcId, int start, int number){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        HashMap hm = new HashMap();
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);

        hm.put("tcId", tcId);
        hm.put("start", 0);
        hm.put("number", Integer.MAX_VALUE);   //所有行
        List<Course> courses = courseMapper.selectCourses(hm);
        if(courses == null){
            sqlSession.close();
            return null;
        }
        ScoreMapper scoreMapper = sqlSession.getMapper(ScoreMapper.class);
        List<Score> rt = new ArrayList();

        for(Course course : courses){
            hm.put("courId", course.getCourse_id());

            List<Score> scores = scoreMapper.selectScore(hm);
            if(scores == null) continue;
            rt.addAll(scores);
        }

        sqlSession.close();
        return start + number <= rt.size() ? rt.subList(start, start + number) : rt.subList(start, rt.size());
    }

    public int insertScore(String stuId, String courId, String score){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);

        HashMap hm = new HashMap();
        hm.put("stu_id", stuId);
        hm.put("course_id", courId);
        ScoreInfo si = new ScoreInfo(stuId,
                courId,
                Integer.parseInt(score));
        int rt = 0;
        if(mapper.selectScoreByConditionCount(hm) <= 0){
            //插入
            rt = mapper.insertScore(si);
        }else{
            //更新
            rt = mapper.updateScore(si);
        }
        sqlSession.commit();
        sqlSession.close();
        return rt;
    }

}
