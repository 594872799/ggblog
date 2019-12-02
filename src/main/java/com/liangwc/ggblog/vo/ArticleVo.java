package com.liangwc.ggblog.vo;

import com.liangwc.ggblog.entity.GgArticle;
import lombok.Data;

import java.util.Date;

/**
 * @author liangweicheng
 * @date 2019/12/2 14:45
 */
@Data
public class ArticleVo {
    private Integer id;

    private String tile;

    private String tag;

    private Date createTime;

    private Integer vister;

    private GgArticle article;
}
