package com.liangwc.ggblog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.LinkedList;
import java.util.List;

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
    public String index(ModelMap model) {
        GgBlogInfo blogInfo = blogInfoService.getById(1);
        model.put("blogInfo", blogInfo);

        GgUser user = userService.getById(1);
        model.put("user", user);

        GgSetting setting = settingService.getById(1);
        model.put("settings", setting);

        MyPage<ArticleVo> myPage = new MyPage<ArticleVo>(1, 10);
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
