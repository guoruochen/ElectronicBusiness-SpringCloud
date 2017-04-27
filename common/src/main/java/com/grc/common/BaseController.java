package com.grc.common;

import com.github.pagehelper.Page;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 郭若辰
 * @create 2017-03-01 17:21
 */
public class BaseController {

    static final String RESPONSE_KEY_STATUS = "status";
    static final String RESPONSE_KEY_MESSAGE = "message";
    static final String RESPONSE_KEY_TOTAL = "total";
    static final String RESPONSE_KEY_ROWS = "rows";
    static final String RESPONSE_KEY_ID = "id";
    static final String RESPONSE_KEY_TEXT = "text";
    static final String RESPONSE_KEY_STATE = "state";
    static final String RESPONSE_KEY_URL = "url";
    static final String RESPONSE_KEY_ERROR = "error";
    static final String RESPONSE_KEY_DATA = "data";
    static final String RESPONSE_KEY_JWT = "jwt";

    /*
    登录成功的响应格式
     */
    public Map<String, Object> loginOkResp(Object o) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put(RESPONSE_KEY_STATUS, 200);
        jsonMap.put(RESPONSE_KEY_JWT, o);
        return jsonMap;
    }

    /*
    登录失败的响应格式
     */
    public Map<String, Object> loginBadResp(Object o) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put(RESPONSE_KEY_STATUS, 201);
        jsonMap.put(RESPONSE_KEY_MESSAGE, o);
        return jsonMap;
    }

    /*
    请求成功的响应格式
     */
    public Map<String, Object> okResponse(Object o) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put(RESPONSE_KEY_STATUS, 200);
        jsonMap.put(RESPONSE_KEY_DATA, o);
        return jsonMap;
    }

    /*
    请求错误的响应格式
     */
    public Map<String, Object> badResponse(Object o) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put(RESPONSE_KEY_STATUS, 500);
        jsonMap.put(RESPONSE_KEY_MESSAGE, o);
        return jsonMap;
    }

    /*
    用来生成符合easyUI的datagrid控件格式的响应
     */
    public Map<String, Object> easyUIDatagrid(Object o) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put(RESPONSE_KEY_TOTAL, ((Page) o).getTotal());
        jsonMap.put(RESPONSE_KEY_ROWS, o);
        return jsonMap;
    }

    /*
    用来生成符合easyUI的异步Tree控件格式的响应
     */
    public Map<String, Object> easyUITree(Long id, String text, String state) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put(RESPONSE_KEY_ID, id);
        jsonMap.put(RESPONSE_KEY_TEXT, text);
        jsonMap.put(RESPONSE_KEY_STATE, state);
        return jsonMap;
    }

    /*
    用来生成符合KindEditor文件上传插件-上传成功-的响应
     */
    public Map<String, Object> KESuccess(String url) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put(RESPONSE_KEY_ERROR, 0);
        jsonMap.put(RESPONSE_KEY_URL, url);
        return jsonMap;
    }

    /*
    用来生成符合KindEditor文件上传插件-上传失败-的响应
     */
    public Map<String, Object> KEFail(Object o) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put(RESPONSE_KEY_ERROR, 1);
        jsonMap.put(RESPONSE_KEY_MESSAGE, o);
        return jsonMap;
    }
}
