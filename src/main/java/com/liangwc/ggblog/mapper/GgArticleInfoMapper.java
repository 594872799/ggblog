package com.liangwc.ggblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liangwc.ggblog.entity.GgArticleInfo;
import com.liangwc.ggblog.vo.ArticleVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author liangwc
 * @since 2019-11-29
 */
@Mapper
public interface GgArticleInfoMapper extends BaseMapper<GgArticleInfo> {
    Page<ArticleVo> selectArticlePage(Page page);
}
