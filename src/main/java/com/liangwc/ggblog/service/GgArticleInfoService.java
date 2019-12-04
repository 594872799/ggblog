package com.liangwc.ggblog.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liangwc.ggblog.entity.GgArticleInfo;
import com.liangwc.ggblog.util.MyPage;
import com.liangwc.ggblog.vo.ArticleVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liangwc
 * @since 2019-11-29
 */
public interface GgArticleInfoService extends IService<GgArticleInfo> {
    MyPage<ArticleVo> selectArticlePage(Page page);

    ArticleVo selectArticleById(int id);
}
