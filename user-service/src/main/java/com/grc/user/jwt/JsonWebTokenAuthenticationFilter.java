package com.grc.user.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * @author 郭若辰
 * @create 2017-04-25 16:23
 * 获取Header中的token
 */
@Component
public class JsonWebTokenAuthenticationFilter extends RequestHeaderAuthenticationFilter {
    public JsonWebTokenAuthenticationFilter() {
        // 没有header也不抛异常
        this.setExceptionIfHeaderMissing(false);

        // 设置要获取token的Header
        this.setPrincipalRequestHeader("Authorization");
    }

    @Override
    @Autowired
    public void setAuthenticationManager(
            AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }
}
