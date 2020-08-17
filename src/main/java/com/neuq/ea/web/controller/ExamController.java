package com.neuq.ea.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by biyanchen on 2018/12/3.
 */
@Controller
@RequestMapping("exam")
public class ExamController {

    @RequestMapping("exam")
    @ResponseBody
    public String exam() {
        System.out.println("hello world!");
        return "hhh";
    }
}
