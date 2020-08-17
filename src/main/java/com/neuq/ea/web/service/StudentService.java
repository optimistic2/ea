package com.neuq.ea.web.service;

import com.neuq.ea.ao.StudentAO;
import com.neuq.ea.ao.StudentPageAO;
import com.neuq.ea.constant.BizCode;
import com.neuq.ea.domain.Student;
import com.neuq.ea.exception.NeuqException;
import com.neuq.ea.vo.StudentVO;
import com.neuq.ea.vo.base.PageVO;
import com.neuq.ea.web.dao.StudentDao;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by biyanchen on 2018/12/3.
 */
@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    private static final Logger log = LoggerFactory.getLogger(StudentService.class);

    public PageVO<StudentVO> pageList(StudentPageAO studentPageAO) throws NeuqException {
        if (studentPageAO == null) {
            throw NeuqException.build(BizCode.FAIL, "查询条件不能为空");
        }
        int size = studentPageAO.getSize();
        int number = studentPageAO.getNumber();
        if (size < 1 || number < 1) {
            throw NeuqException.build(BizCode.FAIL, "分页条件数据非法");
        }
        List<Student> list;
        try {
            list = studentDao.pageList(studentPageAO, (number - 1) * size, size);
        } catch (Exception e) {
            log.error("#StudentService.pageList -->studentDao.pageList studentPageAO{}", studentPageAO, e);
            throw NeuqException.build(BizCode.FAIL, "查询数据失败");
        }
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        List<StudentVO> data = new ArrayList<>();
        for (Student s : list) {
            StudentVO target = new StudentVO();
            BeanUtils.copyProperties(s, target);
            data.add(target);
        }

        int total;
        try {
            total = studentDao.countPageList(studentPageAO);
        } catch (Exception e) {
            log.error("#StudentService.pageList -->studentDao.countPageList studentPageAO{}", studentPageAO, e);
            throw NeuqException.build(BizCode.FAIL, "查询数据失败");
        }
        PageVO<StudentVO> result = new PageVO<>(number, size, total, data);
        return result;
    }


    public boolean addStudent(StudentAO studentAO) throws NeuqException {
        if (StringUtils.isBlank(studentAO.getName()) || StringUtils.isBlank(studentAO.getCode())) {
            throw NeuqException.build(BizCode.FAIL, "传入数据非法");
        }
        boolean flag;
        try {
            flag = studentDao.insert(studentAO);
        } catch (Exception e) {
            log.error("#StudentService.addStudent -->studentDao.insert studentAO{}", studentAO, e);
            throw NeuqException.build(BizCode.FAIL, "新增失败");
        }
        return flag;
    }
}
