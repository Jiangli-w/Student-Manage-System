package com.dao;

import com.entitle.User;
import com.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

@Repository
public class LoginDao {
    public User selectUser(String userName){
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap hm = new HashMap();
        hm.put("userName", userName);

        User rt =mapper.selectUser(hm);
        sqlSession.close();
        return rt;
    }
}
