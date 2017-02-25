package com.grc.user.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 郭若辰
 * @create 2017-02-25 21:19
 */
@RestController
public class UserController {

    @RequestMapping(value = "/test" ,method = RequestMethod.GET)
    public String test(){
        return "测试成功！";
    }
}
