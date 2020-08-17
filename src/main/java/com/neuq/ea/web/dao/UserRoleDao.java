package com.neuq.ea.web.dao;

import com.neuq.ea.domain.UserRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleDao {

    List<UserRole> selectByUserId(@Param("userId") Long userId);

    @Select("select role_id AS roleId from user_role where user_id = #{userId}")
    @ResultType(Long.class)
    List<Long> selectRoleIdListByUserId(@Param("userId") Long userId);

    @Delete("DELETE FROM user_role WHERE user_id = #{userId}")
    boolean deleteByUserId(@Param("userId") Long userId);

}