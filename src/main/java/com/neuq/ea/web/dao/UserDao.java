package com.neuq.ea.web.dao;

import com.neuq.ea.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    User selectUserVoById(@Param("id") Long id);

    List<User> selectByLoginName(@Param("name") String loginName);

    User selectUserById(Long id);

    boolean deleteById(Long id);
}
