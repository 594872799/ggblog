package com.liangwc.ggblog.controller;


import com.liangwc.ggblog.entity.GgArticleInfo;
import com.liangwc.ggblog.service.GgArticleInfoService;
import com.liangwc.ggblog.util.MyPage;
import com.liangwc.ggblog.vo.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author liangwc
 * @since 2019-12-03
 */
@RestController
@RequestMapping("/tags")
public class GgTagsController {
    @Autowired
    private GgArticleInfoService articleInfoService;


    @GetMapping("/{tagName}")
    public String selectByTags(@PathVariable("tagName") String tag, ModelMap model) {
        int current = (int) model.getAttribute("current");
        MyPage<ArticleVo> myPage = new MyPage<ArticleVo>(current, 10);
        MyPage<ArticleVo> articleList = articleInfoService.selectArticlePage(myPage);

        return "/tag";
    }
}
