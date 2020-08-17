package com.neuq.ea.domain;

import com.neuq.ea.domain.base.BaseDomain;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class Role extends BaseDomain {
	/** 角色名 */
	@NotBlank
	private String name;

	/** 排序号 */
	private Integer seq;

	/** 简介 */
	private String description;

	/** 状态 */
	private Integer status;
}