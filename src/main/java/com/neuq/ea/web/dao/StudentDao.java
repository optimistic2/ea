package com.neuq.ea.web.dao;

import com.neuq.ea.ao.StudentAO;
import com.neuq.ea.ao.StudentPageAO;
import com.neuq.ea.domain.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by biyanchen on 2018/12/3.
 */
@Repository
public interface StudentDao {

    List<Student> pageList(@Param("ao") StudentPageAO studentPageAO, @Param("offset") int offset, @Param("size") int size);

    int countPageList(@Param("ao") StudentPageAO studentPageAO);

    boolean insert(@Param("ao") StudentAO studentAO);
}
