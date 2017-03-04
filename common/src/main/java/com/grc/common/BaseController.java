package com.grc.common;

import com.github.pagehelper.Page;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 郭若辰
 * @create 2017-03-01 17:21
 */
public class BaseController {

    static final String RESPONSE_KEY_TOTAL = "total";
    static final String RESPONSE_KEY_ROWS = "rows";
    static final String RESPONSE_KEY_ID = "id";
    static final String RESPONSE_KEY_TEXT = "text";
    static final String RESPONSE_KEY_STATE = "state";

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
    public Map<String, Object> easyUITree(Long id,String text,String state) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put(RESPONSE_KEY_ID, id);
        jsonMap.put(RESPONSE_KEY_TEXT, text);
        jsonMap.put(RESPONSE_KEY_STATE, state);
        return jsonMap;
    }

}
