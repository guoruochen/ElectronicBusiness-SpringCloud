package com.grc.user.jwt;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;

/**
 * @author 郭若辰
 * @create 2017-04-25 16:31
 * 将header中的token认证，然后转换为我们自己的认证对象，再将解析之后的对象返回给Spring Security
 */
@Component
public class JsonWebTokenAuthenticationProvider implements AuthenticationProvider {
    //生成和校验token的工具类
    private JsonWebTokenUtility tokenService = new JsonWebTokenUtility();

    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        Authentication authenticatedUser = null;
        // Only process the PreAuthenticatedAuthenticationToken
        if (authentication.getClass().
                isAssignableFrom(PreAuthenticatedAuthenticationToken.class)
                && authentication.getPrincipal() != null) {
            String tokenHeader = (String) authentication.getPrincipal();
            UserDetails userDetails = parseToken(tokenHeader);
            if (userDetails != null) {
                authenticatedUser =
                        new JsonWebTokenAuthentication(userDetails, tokenHeader);
            }
        } else {
            // It is already a JsonWebTokenAuthentication
            authenticatedUser = authentication;
        }
        return authenticatedUser;
    }

    private UserDetails parseToken(String tokenHeader) {

        UserDetails principal = null;
        AuthTokenDetails authTokenDetails =
                tokenService.parseAndValidate(tokenHeader);

        if (authTokenDetails != null) {

            // userId介入Spring Security
            principal = new User(authTokenDetails.getId().toString(), "", null);
        }

        return principal;
    }

    public boolean supports(Class<?> authentication) {
        return
                authentication.isAssignableFrom(
                        PreAuthenticatedAuthenticationToken.class) ||
                        authentication.isAssignableFrom(
                                JsonWebTokenAuthentication.class);
    }

}
