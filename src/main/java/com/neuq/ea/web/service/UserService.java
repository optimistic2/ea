package com.neuq.ea.web.service;

import com.google.common.collect.Lists;
import com.neuq.ea.domain.User;
import com.neuq.ea.vo.UserVO;
import com.neuq.ea.web.dao.UserDao;
import com.neuq.ea.web.dao.UserRoleDao;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User 表数据服务层接口实现类
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRoleDao userRoleDao;

    public List<UserVO> selectByLoginName(String loginName) {
        List<User> queryList = userDao.selectByLoginName(loginName);
        if (CollectionUtils.isEmpty(queryList)) {
            return null;
        }
        List<UserVO> result = Lists.newArrayListWithCapacity(queryList.size());
        BeanUtils.copyProperties(queryList, result);
        return result;
    }

    public User selectUserById(Long id) {
        return userDao.selectUserById(id);
    }

    public boolean deleteUserById(Long id) {
        return userDao.deleteById(id) && userRoleDao.deleteByUserId(id);
    }

}