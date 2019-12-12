package com.liangwc.ggblog.vo;

import com.liangwc.ggblog.entity.GgArticle;
import com.liangwc.ggblog.entity.GgArticleInfo;
import com.liangwc.ggblog.entity.GgCatagory;
import com.liangwc.ggblog.entity.GgTags;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author liangweicheng
 * @date 2019/12/2 14:45
 */
@Data
public class ArticleVo extends GgArticleInfo {
    private List<String> tagList;

    private GgCatagory catagory;

    private GgArticle article;
}
