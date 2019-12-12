package com.liangwc.ggblog.controller;

import com.liangwc.ggblog.entity.GgBlogInfo;
import com.liangwc.ggblog.entity.GgSetting;
import com.liangwc.ggblog.entity.GgUser;
import com.liangwc.ggblog.service.GgArticleInfoService;
import com.liangwc.ggblog.service.GgBlogInfoService;
import com.liangwc.ggblog.service.GgSettingService;
import com.liangwc.ggblog.service.GgUserService;
import com.liangwc.ggblog.util.MyPage;
import com.liangwc.ggblog.util.Utils;
import com.liangwc.ggblog.vo.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

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
    @Autowired
    private GgSettingService settingService;
    @Autowired
    private GgArticleInfoService articleInfoService;

    @GetMapping("/index")
    public String index(ModelMap model, HttpServletRequest request) {
        GgBlogInfo blogInfo = blogInfoService.getById(1);
        model.put("blogInfo", blogInfo);

        GgUser user = userService.getById(1);
        model.put("user", user);

        GgSetting setting = settingService.getById(1);
        model.put("settings", setting);

        int current;
        if (request.getParameter("current") == null) {
            current = 0;
        } else {
            current = Integer.valueOf(request.getParameter("current"));
        }

        MyPage<ArticleVo> myPage = new MyPage<ArticleVo>(current, 10);
        MyPage<ArticleVo> articleList = articleInfoService.getArticlePage(myPage);
        articleList.setTotalPage(articleList.getPages());
        Utils.splitTag(articleList.getRecords());
        model.put("articlePage", articleList);
        return "/index";
    }


    @GetMapping("/search")
    public String search(ModelMap model, HttpServletRequest request) {
        GgBlogInfo blogInfo = blogInfoService.getById(1);
        model.put("blogInfo", blogInfo);

        GgUser user = userService.getById(1);
        model.put("user", user);

        GgSetting setting = settingService.getById(1);
        model.put("settings", setting);

        String keyWord = request.getParameter("keyword");
        model.put("keyword", keyWord);
        int current;
        if (request.getParameter("current") == null) {
            current = 0;
        } else {
            current = Integer.valueOf(request.getParameter("current"));
        }
        MyPage<ArticleVo> myPage = new MyPage<ArticleVo>(current, 10);
        MyPage<ArticleVo> articleList = articleInfoService.search(myPage, keyWord);
        articleList.setTotalPage(articleList.getPages());
        model.put("articlePage", articleList);
        return "/search";
    }
}
