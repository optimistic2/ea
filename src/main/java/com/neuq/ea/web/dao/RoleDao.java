package com.neuq.ea.web.dao;

import com.neuq.ea.domain.Resource;
import com.neuq.ea.domain.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * RoleVO 表数据库控制层接口
 */
@Repository
public interface RoleDao {

    List<Long> selectResourceIdListByRoleId(@Param("id") Long id);

    List<Resource> selectResourceListByRoleIdList(@Param("list") List<Long> list);

    List<Map<String, String>> selectResourceListByRoleId(@Param("id") Long id);

    Role selectById(Long roleId);
}