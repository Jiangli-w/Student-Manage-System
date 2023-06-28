package com.service;

import com.dao.LoginDao;
import com.entitle.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service(value = "loginService")
public class LoginService {
    @Resource(name = "loginDao")
    LoginDao ld;
    public boolean handle(HttpServletRequest req, HttpServletResponse rsp, HttpSession session){
        User u = ld.selectUser(req.getParameter("userName"));

        if(u != null){
            if (u.getPassword().equals(req.getParameter("password"))) {
                System.out.println(u);
                session.setAttribute("userType", u.getUser_type());
                rsp.addCookie(new Cookie("userName", u.getUser_name()));
                return true;
            } else {
                req.setAttribute("error", "密码错误！");
                return false;
            }
        }else{
            req.setAttribute("error", "用户名不存在！");
            return false;
        }
    }
}
