package com.grc.user.domain;

/**
 * @author 郭若辰
 * @create 2017-04-25 17:46
 */
public class Role {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public Role setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Role setName(String name) {
        this.name = name;
        return this;
    }
}
