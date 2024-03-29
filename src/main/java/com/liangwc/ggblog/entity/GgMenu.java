package com.liangwc.ggblog.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
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
public class GgMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单跳转的url
     */
    private String url;
    /**
     * 菜单权重
     */
    private Integer priority;
    /**
     * 图标
     */
    private String icon;
    private String target;
}
