package com.neuq.ea.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OperationInterceptor extends HandlerInterceptorAdapter {
    private static final Logger log = LoggerFactory.getLogger(OperationInterceptor.class);
    private ThreadLocal<Long> start = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        LOG.info("#ACCESS.IN#request:{}?{}", request.getRequestURL(), RequestUtil.getParams(request));
        start.set(System.currentTimeMillis());
        log.info("开始时间");
        return true;
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        log.info("耗时：" + (System.currentTimeMillis() - start.get()) + "ms");
    }
}