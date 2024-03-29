package com.liangwc.ggblog.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liangwc.ggblog.entity.GgArticleInfo;
import com.liangwc.ggblog.util.MyPage;
import com.liangwc.ggblog.vo.ArticleVo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liangwc
 * @since 2019-11-29
 */
public interface GgArticleInfoService extends IService<GgArticleInfo> {
    MyPage<ArticleVo> getArticlePage(Page page);

    ArticleVo getArticleById(int id);

    MyPage<ArticleVo> getArticleByTag(Page page, String tag);

    List<ArticleVo> getCategory();

    MyPage<ArticleVo> getArticleByCategoty(Page page, int categoryId);

    MyPage<ArticleVo> search(Page page, String keyword);
}
