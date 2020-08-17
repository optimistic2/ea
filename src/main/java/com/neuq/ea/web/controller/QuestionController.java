package com.neuq.ea.web.controller;

import com.neuq.ea.ao.QuestionAO;
import com.neuq.ea.ao.QuestionPageAO;
import com.neuq.ea.constant.BizCode;
import com.neuq.ea.exception.NeuqException;
import com.neuq.ea.response.SimpleResponse;
import com.neuq.ea.web.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by biyanchen on 2018/12/3.
 */
@Controller
@RequestMapping("question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;


    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public SimpleResponse edit(@RequestBody QuestionAO questionAO) throws NeuqException {
        if (questionService.edit(questionAO)) {
            return SimpleResponse.success();
        }
        return SimpleResponse.fail(BizCode.FAIL, "编辑试题失败");
    }

    @RequestMapping(value = "page", method = RequestMethod.GET)
    @ResponseBody
    public SimpleResponse page(QuestionPageAO questionPageAO) throws NeuqException {
        return SimpleResponse.success(questionService.page(questionPageAO));
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String page() throws NeuqException {
        return "question";
    }

}
