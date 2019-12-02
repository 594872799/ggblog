package com.liangwc.ggblog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liangwc.ggblog.entity.GgArticleInfo;
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
    IPage<ArticleVo> selectArticlePage(Page page);
}
