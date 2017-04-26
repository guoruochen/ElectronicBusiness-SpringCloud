
package com.grc.user.dto;


import java.util.List;

/**
 * Created by YangFan on 2016/11/28 上午10:53.
 * <p/>
 */
public class AuthTokenDTO {
    private String token;
    private Long userId;
    private List<String> resourceList;

    public String getToken() {
        return token;
    }

    public AuthTokenDTO setToken(String token) {
        this.token = token;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public AuthTokenDTO setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public List<String> getResourceList() {
        return resourceList;
    }

    public AuthTokenDTO setResourceList(List<String> resourceList) {
        this.resourceList = resourceList;
        return this;
    }
}
