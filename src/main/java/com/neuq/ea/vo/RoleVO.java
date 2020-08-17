package com.neuq.ea.vo;

import com.neuq.ea.vo.base.BaseVO;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class RoleVO extends BaseVO {

    /**
     * 角色名
     */
    @NotBlank
    private String name;

    /**
     * 排序号
     */
    private Integer seq;

    /**
     * 简介
     */
    private String description;

    /**
     * 状态
     */
    private Integer status;
}