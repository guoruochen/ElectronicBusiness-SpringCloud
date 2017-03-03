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

    /*
    用来生成符合easyUI分页处理格式的响应
     */
    public Map<String, Object> easyUIPageable(Object o) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put(RESPONSE_KEY_TOTAL, ((Page) o).getTotal());
        jsonMap.put(RESPONSE_KEY_ROWS, o);
        return jsonMap;
    }

}
