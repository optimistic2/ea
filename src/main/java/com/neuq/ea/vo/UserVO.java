package com.neuq.ea.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neuq.ea.vo.base.BaseVO;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

@Data
public class UserVO extends BaseVO {
    private Long id;

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

    private Integer createTime;

    private String phone;

    private List<RoleVO> rolesList;

    private String organizationName;

    private String roleIds;
}