package com.neuq.ea.web.controller;

import com.neuq.ea.ao.StudentAO;
import com.neuq.ea.ao.StudentPageAO;
import com.neuq.ea.constant.BizCode;
import com.neuq.ea.exception.NeuqException;
import com.neuq.ea.response.SimpleResponse;
import com.neuq.ea.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by biyanchen on 2018/12/3.
 */
@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "page", method = RequestMethod.GET)
    @ResponseBody
    public SimpleResponse pageList(StudentPageAO studentPageAO) throws NeuqException {
        return SimpleResponse.success(studentService.pageList(studentPageAO));
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public SimpleResponse add(@RequestBody StudentAO studentAO) throws NeuqException {
        if (studentService.addStudent(studentAO)) {
            return SimpleResponse.success();
        }
        return SimpleResponse.fail(BizCode.FAIL, "新增学生失败");

    }
}
