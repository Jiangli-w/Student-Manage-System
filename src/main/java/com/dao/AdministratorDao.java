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
public class AdministratorDao {
    public int selectUserCount(){

        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        int rt = userMapper.selectUserCount();

        sqlSession.close();
        return rt;
    }

    public List<User> selectUser(int start, int number){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        HashMap hm = new HashMap();
        hm.put("start", start);

        hm.put("number", number);
        List<User> rt = userMapper.selectUsers(hm);

        sqlSession.close();
        return rt;
    }

    public int updateUser(User u){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        int rt = userMapper.updateUser(u);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }

    public int deleteUser(String userName){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        HashMap hm = new HashMap();
        hm.put("user_name", userName);
        int rt = userMapper.deleteUser(hm);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }

    public int selectStudentCount(){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        int rt = studentMapper.selectStudentCount();

        sqlSession.close();
        return rt;
    }
    public List<Student> selectStudents(int start, int number){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        HashMap hm = new HashMap();
        hm.put("start", start);

        hm.put("number", number);
        List<Student> rt = studentMapper.selectStudents(hm);

        sqlSession.close();
        return rt;
    }
    public int updateStudent(Student stu){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        int rt = studentMapper.updateStudent(stu);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }
    public int deleteStudent(String stuId){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
//        ScoreMapper scoreMapper = sqlSession.getMapper(ScoreMapper.class);
        HashMap hm = new HashMap();
        hm.put("stu_id", stuId);
        System.out.println(stuId);
        int rt = studentMapper.deleteStudent(hm);

//        //删除分数表冗余数据
//        rt = scoreMapper.deleteScore(hm);
        sqlSession.commit();
        sqlSession.close();
        return rt;
    }

    public int selectClassCount(){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);

        int rt = classMapper.selectClassCount();

        sqlSession.close();
        return rt;
    }
    public List<ClassInfo> selectClasses(int start, int number){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        HashMap hm = new HashMap();
        hm.put("start", start);

        hm.put("number", number);
        List<ClassInfo> rt = classMapper.selectClasses(hm);

        sqlSession.close();
        return rt;
    }
    public int updateClass(ClassInfo ci){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);

        int rt = classMapper.updateClass(ci);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }
    public int deleteClass(String classId){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        HashMap hm = new HashMap();
        hm.put("class_id", classId);
        int rt = classMapper.deleteClass(hm);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }


    public int selectCourseCount(){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);

        int rt = courseMapper.selectAllCourseCount();

        sqlSession.close();
        return rt;
    }
    public List<Course> selectCourse(int start, int number){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
        HashMap hm = new HashMap();
        hm.put("start", start);

        hm.put("number", number);
        List<Course> rt = courseMapper.selectAllCourses(hm);

        sqlSession.close();
        return rt;
    }
    public int updateCourse(Course c){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);

        int rt = courseMapper.updateCourse(c);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }
    public int deleteCourse(String courseId){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
        HashMap hm = new HashMap();
        hm.put("course_id", courseId);
        int rt = courseMapper.deleteCourse(hm);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }


    public int selectCourseTableCount(){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        TableMapper tableMapper = sqlSession.getMapper(TableMapper.class);

        int rt = tableMapper.selectCourseTableCount();

        sqlSession.close();
        return rt;
    }
    public List<CourseTable> selectCourseTable(int start, int number){
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
        hm.put("start", start);

        hm.put("number", number);
        List<CourseTable> rt = tableMapper.selectCourseTable(hm);

        sqlSession.close();
        return rt;
    }
    public int updateCourseTable(CourseTable ct){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        TableMapper tableMapper = sqlSession.getMapper(TableMapper.class);

        int rt = tableMapper.updateCourseTable(ct);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }
    public int deleteCourseTable(String ctId){
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
        hm.put("ct_id", ctId);
        int rt = tableMapper.deleteCourseTable(hm);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }


    public int selectScoreCount(){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        ScoreMapper scoreMapper = sqlSession.getMapper(ScoreMapper.class);

        int rt = scoreMapper.selectAllScoreCount();

        sqlSession.close();
        return rt;
    }
    public List<ScoreInfo> selectScore(int start, int number){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        ScoreMapper scoreMapper = sqlSession.getMapper(ScoreMapper.class);
        HashMap hm = new HashMap();
        hm.put("start", start);

        hm.put("number", number);
        List<ScoreInfo> rt = scoreMapper.selectAllScore(hm);

        sqlSession.close();
        return rt;
    }
    public int updateScore(ScoreInfo si){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        ScoreMapper scoreMapper = sqlSession.getMapper(ScoreMapper.class);

        int rt = scoreMapper.updateScore(si);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }
    public int deleteScore(String stuId, String courseId){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        ScoreMapper scoreMapper = sqlSession.getMapper(ScoreMapper.class);
        HashMap hm = new HashMap();
        hm.put("stu_id", stuId);
        hm.put("course_id", courseId);
        int rt = scoreMapper.deleteScore(hm);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }


    public int selectTeacherCount(){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);

        int rt = teacherMapper.selectTeacherCount(null);

        sqlSession.close();
        return rt;
    }
    public List<Teacher> selectTeacher(int start, int number){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        HashMap hm = new HashMap();
        hm.put("start", start);

        hm.put("number", number);
        List<Teacher> rt = teacherMapper.selectTeachers(hm);

        sqlSession.close();
        return rt;
    }
    public int updateTeacher(Teacher t){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);

        int rt = teacherMapper.updateTeacher(t);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }
    public int deleteTeacher(String tcId){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        HashMap hm = new HashMap();
        hm.put("tc_id", tcId);
        int rt = teacherMapper.deleteTeacher(hm);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }

    public List<Student> selectStudentsByCondition(HashMap hm){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> rt = studentMapper.selectStudentsByCondition(hm);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }

    public int selectStudentsByConditionCount(HashMap hm){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        System.out.println(hm);
        int rt = studentMapper.selectStudentsByConditionCount(hm);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }

    public List<ClassInfo> selectClassesByCondition(HashMap hm){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();
        System.out.println(hm);
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        List<ClassInfo> rt = classMapper.selectClassesByCondition(hm);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }
    public int selectClassesByConditionCount(HashMap hm){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        System.out.println(hm);
        int rt = classMapper.selectClassesByConditionCount(hm);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }

    public List<Course> selectCourseByCondition(HashMap hm){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();
        System.out.println(hm);
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
        List<Course> rt = courseMapper.selectCourseByCondition(hm);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }
    public int selectCourseByConditionCount(HashMap hm){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
        System.out.println(hm);
        int rt = courseMapper.selectCourseByConditionCount(hm);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }

    public List<CourseTable> selectCourseTableByCondition(HashMap hm){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();
        System.out.println(hm);
        TableMapper tableMapper = sqlSession.getMapper(TableMapper.class);
        List<CourseTable> rt = tableMapper.selectCourseTableByCondition(hm);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }
    public int selectCourseTableByConditionCount(HashMap hm){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        TableMapper tableMapper = sqlSession.getMapper(TableMapper.class);
        System.out.println(hm);
        int rt = tableMapper.selectCourseTableByConditionCount(hm);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }

    public List<ScoreInfo> selectScoreByCondition(HashMap hm){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();
        System.out.println(hm);
        ScoreMapper scoreMapper = sqlSession.getMapper(ScoreMapper.class);

        List<ScoreInfo> rt = scoreMapper.selectScoreByCondition(hm);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }
    public int selectScoreByConditionCount(HashMap hm){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        ScoreMapper scoreMapper = sqlSession.getMapper(ScoreMapper.class);
        System.out.println(hm);
        int rt = scoreMapper.selectScoreByConditionCount(hm);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }

    public List<ScoreInfo> selectScoreByInterval(HashMap hm){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();
        System.out.println(hm);
        ScoreMapper scoreMapper = sqlSession.getMapper(ScoreMapper.class);

        List<ScoreInfo> rt = scoreMapper.selectScoreByInterval(hm);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }

    public int selectScoreByIntervalCount(HashMap hm){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        ScoreMapper scoreMapper = sqlSession.getMapper(ScoreMapper.class);
        System.out.println(hm);
        int rt = scoreMapper.selectScoreByIntervalCount(hm);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }

    public int insertUser(User u){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        int rt = userMapper.insertUser(u);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }

    public int insertStudent(Student s){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        int rt = studentMapper.insertStudent(s);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }

    public int insertClass(ClassInfo c){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);

        int rt = classMapper.insertClass(c);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }

    public int insertCourse(Course c){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);

        int rt = courseMapper.insertCourse(c);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }

    public int insertCourseTable(CourseTable ct){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        TableMapper tableMapper = sqlSession.getMapper(TableMapper.class);

        int rt = tableMapper.insertCourseTable(ct);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }

    public int insertScore(ScoreInfo si){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        ScoreMapper scoreMapper = sqlSession.getMapper(ScoreMapper.class);

        int rt = scoreMapper.insertScore(si);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }

    public int insertTeacher(Teacher t){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);

        int rt = teacherMapper.insertTeacher(t);

        sqlSession.commit();
        sqlSession.close();
        return rt;
    }
}
