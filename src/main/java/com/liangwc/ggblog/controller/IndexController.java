package com.liangwc.ggblog.controller;

import com.liangwc.ggblog.entity.GgBlogInfo;
import com.liangwc.ggblog.entity.GgUser;
import com.liangwc.ggblog.service.GgBlogInfoService;
import com.liangwc.ggblog.service.GgUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liangweicheng
 * @date 2019/11/29 9:34
 */
@Controller
public class IndexController {
    @Autowired
    private GgBlogInfoService blogInfoService;
    @Autowired
    private GgUserService userService;

    @GetMapping("/index")
    public String index(ModelMap model) {
        GgBlogInfo blogInfo = blogInfoService.selectById(1);
        model.put("blogInfo", blogInfo);

        GgUser user = userService.selectById(1);
        model.put("user", user);
        return "/index";
    }

}
