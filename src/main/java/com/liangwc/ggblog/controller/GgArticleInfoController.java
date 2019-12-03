package com.liangwc.ggblog.controller;


import com.liangwc.ggblog.entity.GgBlogInfo;
import com.liangwc.ggblog.entity.GgSetting;
import com.liangwc.ggblog.entity.GgUser;
import com.liangwc.ggblog.service.GgArticleInfoService;
import com.liangwc.ggblog.service.GgBlogInfoService;
import com.liangwc.ggblog.service.GgSettingService;
import com.liangwc.ggblog.service.GgUserService;
import com.liangwc.ggblog.util.MyPage;
import com.liangwc.ggblog.vo.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

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
@RequestMapping("/page")
public class GgArticleInfoController {
    @Autowired
    private GgBlogInfoService blogInfoService;
    @Autowired
    private GgUserService userService;
    @Autowired
    private GgSettingService settingService;
    @Autowired
    private GgArticleInfoService articleInfoService;

    @GetMapping("/{current}")
    public String articlePage(@PathVariable("current") int current, ModelMap model) {
        GgBlogInfo blogInfo = blogInfoService.getById(1);
        model.put("blogInfo", blogInfo);

        GgUser user = userService.getById(1);
        model.put("user", user);

        GgSetting setting = settingService.getById(1);
        model.put("settings", setting);

        MyPage<ArticleVo> myPage = new MyPage<ArticleVo>(current, 10);
        MyPage<ArticleVo> page = articleInfoService.selectArticlePage(myPage);
        page.setTotalPage(page.getPages());
        for (ArticleVo vo : page.getRecords()) {
            List<String> tagList = new LinkedList<>();
            for (String tag : vo.getTags().split(",")) {
                tagList.add(tag);
            }
            vo.setTagList(tagList);
        }
        model.put("articlePage", page);
        return "/index";
    }
}

