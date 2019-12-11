package com.liangwc.ggblog.controller;


import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liangwc.ggblog.entity.GgArticleInfo;
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
import org.springframework.transaction.annotation.Transactional;
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
@RequestMapping("/article")
public class GgArticleInfoController {
    @Autowired
    private GgBlogInfoService blogInfoService;
    @Autowired
    private GgUserService userService;
    @Autowired
    private GgSettingService settingService;
    @Autowired
    private GgArticleInfoService articleInfoService;

    /**
     * 首页文章列表部分
     *
     * @param current 当前页码
     * @param model
     * @return
     */
    @GetMapping("/page/{current}")
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

    @GetMapping("/{id}")
    @Transactional
    public String articleDetail(@PathVariable("id") int id, ModelMap model) {
        ArticleVo vo = articleInfoService.selectArticleById(id);
        model.put("post", vo);
        List<String> tagList = new LinkedList<>();
        for (String tag : vo.getTags().split(",")) {
            tagList.add(tag);
        }
        vo.setTagList(tagList);

        // 更新浏览人数
        GgArticleInfo articleInfo = new GgArticleInfo();
        articleInfo.setId(id);
        articleInfo.setVister(vo.getVister() + 1);
        articleInfoService.updateById(articleInfo);

        // 上一篇
        AbstractWrapper preWrapper = new QueryWrapper()
                .select("id", "title")
                .lt(true, "create_time", vo.getCreateTime())
                .orderBy(true, false, "create_time")
                .last(true, "limit 1");
        GgArticleInfo preArticle = articleInfoService.getOne(preWrapper);
        model.put("prePost",preArticle);
        // 下一篇
        AbstractWrapper nextWrapper = new QueryWrapper()
                .select("id", "title")
                .gt(true, "create_time", vo.getCreateTime())
                .orderBy(true, true, "create_time")
                .last(true, "limit 1");
        GgArticleInfo nextArticle = articleInfoService.getOne(nextWrapper);
        model.put("nextPost",nextArticle);


        GgUser user = userService.getById(vo.getUserId());
        model.put("user", user);
        GgBlogInfo blogInfo = blogInfoService.getById(vo.getUserId());
        model.put("blogInfo", blogInfo);
        return "/post";
    }
}

