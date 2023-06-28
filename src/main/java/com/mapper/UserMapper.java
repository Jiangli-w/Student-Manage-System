package com.mapper;

import com.entitle.User;

import java.util.HashMap;
import java.util.List;

public interface UserMapper {
    public User selectUser(HashMap mp);
    public int modifyUser(HashMap mp);

    public int selectUserCount();

    public List<User> selectUsers(HashMap hm);

    public int updateUser(User u);

    public int deleteUser(HashMap hm);
    public int insertUser(User u);
}
