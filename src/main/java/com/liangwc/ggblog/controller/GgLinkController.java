package com.liangwc.ggblog.controller;


import com.liangwc.ggblog.entity.GgBlogInfo;
import com.liangwc.ggblog.service.GgBlogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author liangwc
 * @since 2019-12-13
 */
@Controller
public class GgLinkController {
    @Autowired
    private GgBlogInfoService blogInfoService;

    @GetMapping("/links")
    public String links(ModelMap model) {
        GgBlogInfo blogInfo = blogInfoService.getById(1);
        model.put("blogInfo", blogInfo);
        return "/links";
    }
}
