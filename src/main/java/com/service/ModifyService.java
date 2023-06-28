package com.service;

import com.dao.ModifyDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class ModifyService {
    @Resource(name = "modifyDao")
    ModifyDao md;
    public boolean handle(HttpServletRequest req){
        int c = md.modifyUser(req.getParameter("userName"), req.getParameter("oldpwd"), req.getParameter("newpwd"));

        if(c == 1){
            req.setAttribute("state", "修改密码成功");
            return true;
        }else{
            req.setAttribute("state", "修改密码失败");
            return false;
        }
    }
}
