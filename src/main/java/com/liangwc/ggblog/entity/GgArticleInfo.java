package com.liangwc.ggblog.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author liangwc
 * @since 2019-11-29
 */
@Data
@Accessors(chain = true)
public class GgArticleInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 文章id
     */
    private Integer articleId;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 标签
     */
    private String tag;
    /**
     * 文章状态
     */
    private Integer status;
    /**
     * 喜欢的数量
     */
    private Integer favorNum;
    /**
     * 评论的数量
     */
    private Integer commentNum;
    /**
     * 权重
     */
    private Integer weigh;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 文章分类
     */
    private Integer catagoryId;


}
