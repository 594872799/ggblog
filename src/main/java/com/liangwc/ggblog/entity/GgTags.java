package com.liangwc.ggblog.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author liangwc
 * @since 2019-12-03
 */
@Data
@Accessors(chain = true)
public class GgTags {

    private static final long serialVersionUID = 1L;

    private Integer tagId;

    /**
     * 标签
     */
    private String tag;

    /**
     * 文章标签
     */
    private Integer articleInfoId;


}
