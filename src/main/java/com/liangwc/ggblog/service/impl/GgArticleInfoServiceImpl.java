package com.liangwc.ggblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liangwc.ggblog.entity.GgArticleInfo;
import com.liangwc.ggblog.mapper.GgArticleInfoMapper;
import com.liangwc.ggblog.service.GgArticleInfoService;
import com.liangwc.ggblog.util.MyPage;
import com.liangwc.ggblog.vo.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liangwc
 * @since 2019-11-29
 */
@Service
public class GgArticleInfoServiceImpl extends ServiceImpl<GgArticleInfoMapper, GgArticleInfo> implements GgArticleInfoService {
    @Autowired
    private GgArticleInfoMapper articleInfoMapper;

    @Override
    public MyPage<ArticleVo> selectArticlePage(Page page) {
        return articleInfoMapper.selectArticlePage(page);
    }

    @Override
    public ArticleVo selectArticleById(int id) {
        return articleInfoMapper.selectArticleById(id);
    }
}
