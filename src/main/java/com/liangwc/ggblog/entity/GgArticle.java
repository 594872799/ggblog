package com.liangwc.ggblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author liangwc
 * @since 2019-12-02
 */
@Data
@Accessors(chain = true)
public class GgArticle implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 正文
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createTime;


}
