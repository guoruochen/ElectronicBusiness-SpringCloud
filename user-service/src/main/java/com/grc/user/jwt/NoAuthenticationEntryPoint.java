package com.grc.user.jwt;

import com.grc.common.JsonUtils;
import com.grc.user.domain.RestResp;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 郭若辰
 * @create 2017-04-26 8:49
 */
public class NoAuthenticationEntryPoint implements AuthenticationEntryPoint {
    //当访问的资源没有权限，会调用这里
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {


        //返回json形式的错误信息
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        RestResp restResp = new RestResp(RestResp.NO_SESSION, "没有登录或登录已过期!");

        response.getWriter().println(JsonUtils.toJsonString(restResp));
        response.getWriter().flush();
    }
}
