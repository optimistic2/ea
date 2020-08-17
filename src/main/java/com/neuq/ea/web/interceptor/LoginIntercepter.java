package com.neuq.ea.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by biyanchen on 2018/12/11.
 */
public class LoginIntercepter extends BaseInterceptor {
    private static final Logger log = LoggerFactory.getLogger(LoginIntercepter.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("登陆校验");
        if (logined(request)) {
            return true;
        } else {
            this.reDispatchRequest(request, response, LoginIntercepter.UNLOGIN_URL);
            return false;
        }
    }

    private boolean logined(HttpServletRequest request) {
        return true;
    }


}
