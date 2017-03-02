package com.grc.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 郭若辰
 * @create 2017-03-01 17:21
 */
public class BaseController {
    static final String RESPONSE_KEY_CODE = "code";
    static final String RESPONSE_KEY_MESSAGE = "message";
    static final String RESPONSE_KEY_RESULT = "result";

    static final int DEFAULT_PAGE_SIZE = 10;


    public Map<String, Object> okResponse(Object o) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put(RESPONSE_KEY_CODE, 200);
        jsonMap.put(RESPONSE_KEY_RESULT, o);
        return jsonMap;
    }

    public Map<String, Object> badResponse(String message) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put(RESPONSE_KEY_CODE, 500);
        jsonMap.put(RESPONSE_KEY_MESSAGE, message);
        return jsonMap;
    }

//    public String timeStamp() {
//        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
//    }

}
