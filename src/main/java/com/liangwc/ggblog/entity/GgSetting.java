package com.liangwc.ggblog.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
public class GgSetting implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * github链接
     */
    private String githubUrl;
    /**
     * qq帐号
     */
    private String qqNumber;
    /**
     * 微博链接
     */
    private String weiboUrl;
    /**
     * 邮箱地址
     */
    private String emailAddress;
    /**
     * 用户
     */
    private Integer userId;


}
