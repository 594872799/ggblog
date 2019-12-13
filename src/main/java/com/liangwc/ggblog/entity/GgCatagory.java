package com.liangwc.ggblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

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
 * @since 2019-11-29
 */
@Data
@Accessors(chain = true)
public class GgCatagory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 类型名称
     */
    private String name;
    /**
     * 是否启用
     */
    private Integer status;



}
