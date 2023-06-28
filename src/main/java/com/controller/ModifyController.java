package com.controller;

import com.service.ModifyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class ModifyController {
    @Resource(name = "modifyService")
    ModifyService ms;
    @ResponseBody
    @RequestMapping(value = "/modifypwd",
            produces = {"application/json;charset=UTF-8"})
    public Object dispatch(HttpServletRequest req) {
        ms.handle(req);
        String rt = (String) req.getAttribute("state");
        System.out.println(rt);
        HashMap hm = new HashMap();
        hm.put("修改结果", rt);
        return hm;
    }
}
