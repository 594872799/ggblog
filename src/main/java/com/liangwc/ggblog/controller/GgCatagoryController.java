package com.liangwc.ggblog.controller;


import com.liangwc.ggblog.entity.GgBlogInfo;
import com.liangwc.ggblog.entity.GgUser;
import com.liangwc.ggblog.service.GgArticleInfoService;
import com.liangwc.ggblog.service.GgBlogInfoService;
import com.liangwc.ggblog.service.GgUserService;
import com.liangwc.ggblog.util.MyPage;
import com.liangwc.ggblog.vo.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author liangwc
 * @since 2019-11-29
 */
@Controller
@RequestMapping("/categories")
public class GgCatagoryController {
    @Autowired
    private GgArticleInfoService articleInfoService;
    @Autowired
    private GgUserService userService;
    @Autowired
    private GgBlogInfoService blogInfoService;

    @GetMapping("/{categoryId}")
    public String getCategoty(@PathVariable("categoryId") int categoryId, ModelMap model, HttpServletRequest request) {
        int current = 1;
        if (null != request.getParameter("current")) {
            current = Integer.parseInt(request.getParameter("current"));
        }

        MyPage<ArticleVo> myPage = new MyPage<>(current, 10);
        MyPage<ArticleVo> articleList = articleInfoService.getArticleByCategoty(myPage,categoryId);
        articleList.setTotalPage(articleList.getPages());

        for (ArticleVo vo : articleList.getRecords()) {
            List<String> tagList = new LinkedList<>();
            for (String tag : vo.getTags().split(",")) {
                tagList.add(tag);
            }
            vo.setTagList(tagList);
        }

        model.put("title",articleList.getRecords().get(0).getCatagory().getName());

        model.put("posts", articleList);
        GgUser user = userService.getById(1);
        model.put("user", user);
        GgBlogInfo blogInfo = blogInfoService.getById(1);
        model.put("blogInfo", blogInfo);

        return "/category";
    }
}

