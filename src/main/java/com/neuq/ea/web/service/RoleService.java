package com.neuq.ea.web.service;

import com.neuq.ea.domain.Role;
import com.neuq.ea.web.dao.RoleDao;
import com.neuq.ea.web.dao.RoleResourceDao;
import com.neuq.ea.web.dao.UserRoleDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * RoleVO 表数据服务层接口实现类
 */
@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private RoleResourceDao roleResourceDao;

    public List<Long> selectResourceIdListByRoleId(Long id) {
        return roleDao.selectResourceIdListByRoleId(id);
    }

    public Map<String, Set<String>> selectResourceMapByUserId(Long userId) {
        Map<String, Set<String>> resourceMap = new HashMap<String, Set<String>>();
        List<Long> roleIdList = userRoleDao.selectRoleIdListByUserId(userId);
        Set<String> urlSet = new HashSet<String>();
        Set<String> roles = new HashSet<String>();
        for (Long roleId : roleIdList) {
            List<Map<String, String>> resourceList = roleDao.selectResourceListByRoleId(roleId);
            if (resourceList != null && !resourceList.isEmpty()) {
                for (Map<String, String> map : resourceList) {
                    if (map != null && StringUtils.isNotBlank(map.get("url"))) {
                        urlSet.add(map.get("url"));
                    }
                }
            }
            Role role = roleDao.selectById(roleId);
            if (role != null) {
                roles.add(role.getName());
            }
        }
        resourceMap.put("urls", urlSet);
        resourceMap.put("roles", roles);
        return resourceMap;
    }

}