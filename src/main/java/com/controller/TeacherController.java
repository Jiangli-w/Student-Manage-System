package com.controller;

import com.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class TeacherController {
    @Resource(name="teacherService")
    TeacherService tc;

    @ResponseBody
    @RequestMapping(value = "/teacher",
            produces = {"application/json;charset=UTF-8"})
    public Object dispatch(HttpServletRequest req) {
        HashMap hm = new HashMap();
        switch (req.getParameter("what")) {
            case "personInfo":
                return tc.handlePersonInfo(req);
            case "personInfo_count":
                HashMap oj = new HashMap();
                oj.put("count", tc.handlePersonInfoCount(req));
                return oj;
            case "ctInfo":
                return tc.handleTableInfo(req);
            case "ctInfo_count":
                hm.put("count", tc.handleTableInfoCount(req));
                return hm;
            case "scoreInfo":
                return tc.handleScoreInfo(req);
            case "scoreInfo_count":
                hm.put("count", tc.handleScoreInfoCount(req));
                return hm;
            case "changeScoreInfo":
                String state = tc.handleChangeScoreInfo(req) == 1 ? "success" : "fail";
                hm.put("state", state);

                return hm;
            default:
                return null;
        }
    }
}
