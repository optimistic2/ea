package com.neuq.ea.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class BaseInterceptor extends HandlerInterceptorAdapter {

    private static final Logger log = LoggerFactory.getLogger(BaseInterceptor.class);
    public static final String UNLOGIN_URL = "/unlogin";

    /**
     * 响应JSON串
     *
     * @param response 响应对象
     * @param json     字符串
     */
    public void writeJson(HttpServletResponse response, String json) {
        if (json == null)
            return;
        String charset = "UTF-8";
        try {
            response.setContentType("application/json;charset=" + charset);
            response.setContentLength(json.getBytes(charset).length);
            PrintWriter out = response.getWriter();
            out.print(json);
            out.flush();
        } catch (Exception e) {
            log.error("#BaseInterceptor.writeJson#write_error,json:{},msg:{}", json, e.getMessage(), e);
        }
    }

    /**
     * @param response
     * @param json
     */
    public void writeJsonpError(HttpServletResponse response, String json) {
        if (json == null)
            return;
        String charset = "UTF-8";
        try {
            response.setContentType("application/javascript;charset=" + charset);
            response.setContentLength(json.getBytes(charset).length);
            PrintWriter out = response.getWriter();
            out.print(json);
            out.flush();
        } catch (Exception e) {
            log.error("#BaseInterceptor.writeJsonpError#write_error,json:{},msg:{}", json, e.getMessage(), e);
        }
    }

    public void reDispatchRequest(HttpServletRequest request, HttpServletResponse response, String newUrl)
            throws ServletException, IOException {
        request.getRequestDispatcher(newUrl).forward(request, response);
    }
}