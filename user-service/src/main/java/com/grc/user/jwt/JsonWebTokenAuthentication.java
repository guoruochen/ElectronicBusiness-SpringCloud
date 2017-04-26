package com.grc.user.jwt;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author 郭若辰
 * @create 2017-04-25 16:35
 */
public class JsonWebTokenAuthentication extends AbstractAuthenticationToken {
    private static final long serialVersionUID = -6855809445272533821L;

    private UserDetails principal;
    private String jsonWebToken;

    public JsonWebTokenAuthentication(UserDetails principal, String jsonWebToken) {
        super(principal.getAuthorities());
        this.principal = principal;
        this.jsonWebToken = jsonWebToken;
    }

    public Object getCredentials() {
        return null;
    }

    public String getJsonWebToken() {
        return jsonWebToken;
    }

    public Object getPrincipal() {
        return principal;
    }
}
