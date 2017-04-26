package com.grc.user.jwt;

import java.util.Date;

/**
 * @author 郭若辰
 * @create 2017-04-25 15:47
 * 维护token中的数据的一个pojo
 */
public class AuthTokenDetails {
    private Long id;// 用户ID
    private String username;// 用户名
    private Date expirationDate;//过期时间

    public Long getId() {
        return id;
    }

    public AuthTokenDetails setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public AuthTokenDetails setUsername(String username) {
        this.username = username;
        return this;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public AuthTokenDetails setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }
}
