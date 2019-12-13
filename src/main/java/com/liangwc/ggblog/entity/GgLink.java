package com.liangwc.ggblog.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author liangwc
 * @since 2019-12-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GgLink implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    private String name;

    /**
     * url
     */
    private String url;

    /**
     * 图标
     */
    private String logo;

    /**
     * 描述
     */
    private String description;

    /**
     * 分类
     */
    private String team;

    /**
     * 权重
     */
    private Integer priority;


}
