package com.grc.user.domain;

import java.util.Date;

/**
 * @author 郭若辰
 * @create 2017-04-26 9:04
 */
public class RestResp {


    public static final Integer OK = 200;
    public static final Integer ERROR = 500;
    public static final Integer NO_PERMISSION = 10001;
    public static final Integer NO_SESSION = 10002;
    public static final Integer NOT_FOUND = 404;

    // 默认成功
    private Integer code = OK;

    private String msg;

    private Object data;
    private String path;
    private Date timestamp;

    public RestResp() {

    }

    public RestResp(Object data) {
        this.data = data;
    }

    public RestResp(Integer code, String msg, String path) {
        this.code = code;
        this.msg = msg;
        this.path = path;
        this.timestamp = new Date();
    }

    public RestResp(Integer code, String msg) {
        this(code, msg, null);
    }
}
