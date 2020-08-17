package com.neuq.ea.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.neuq.ea.domain.base.BaseDomain;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class Resource extends BaseDomain {

    /**
     * 资源名称
     */
    @NotBlank
    private String name;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 打开方式 ajax,iframe
     */
    private String openMode;

    /**
     * 资源介绍
     */
    private String description;

    /**
     * 资源图标
     */
    @JsonProperty("iconCls")
    private String icon;

    /**
     * 父级资源id
     */
    private Long pid;

    /**
     * 排序
     */
    private Integer seq;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 打开的
     */
    private Integer opened;

    /**
     * 资源类别
     */
    private Integer resourceType;
}