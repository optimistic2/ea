package com.neuq.ea.web.interceptor;

import com.neuq.ea.constant.BizCode;
import com.neuq.ea.exception.NeuqException;
import com.neuq.ea.response.SimpleResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public SimpleResponse handleException(HttpServletRequest request, Exception e) {
        return SimpleResponse.fail(BizCode.SERVER_INTERNAL_ERROR, e.getMessage());
    }

    @ExceptionHandler(NeuqException.class)
    @ResponseBody
    public SimpleResponse handlePaotuiException(HttpServletRequest request, NeuqException e) {
        return SimpleResponse.fail(e);
    }
}