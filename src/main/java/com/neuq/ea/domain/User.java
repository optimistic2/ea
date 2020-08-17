package com.neuq.ea.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neuq.ea.domain.base.BaseDomain;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;
import java.util.List;

@Data
public class User  extends BaseDomain {

	@NotBlank
	@Length(min = 4, max = 64)
	private String loginName;

	private String name;

	@JsonIgnore
	private String password;
	@JsonIgnore
	private String salt; // 密码加密盐

	private Integer sex;

	private Integer age;

	private Integer userType;

	private Integer status;

	private Integer organizationId;

	private Date createTime;

	private String phone;

	private List<Role> rolesList;

	private String organizationName;

	private String roleIds;

	private Date createdateStart;
	private Date createdateEnd;

	/**
	 * 比较vo和数据库中的用户是否同一个user，采用id比较
	 * @param user 用户
	 * @return 是否同一个人
	 */
	public boolean equalsUser(User user) {
		if (user == null) {
			return false;
		}
		Long userId = user.getId();
		if (this.getId() == null || userId == null) {
			return false;
		}
		return this.getId().equals(userId);
	}
}