package com.controller;

import com.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Resource(name = "loginService")
    LoginService ls;

    @RequestMapping(value = "/check")
    public String dispatch(HttpServletRequest req, HttpServletResponse rsp, HttpSession session) {
        if (ls.handle(req, rsp, session) == true){
            String type = (String) session.getAttribute("userType");
            if(type.equals("学生")){
                return "welcomStudent";
            }else if(type.equals("教师")){
                return "welcomTeacher";
            }else if(type.equals("管理员")){
                return "welcomAdministrator";
            }else{
                req.setAttribute("error", "未知身份登录！");
                return "fail";
            }

        }
        return "fail";
    }
}
