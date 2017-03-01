package com.grc.user.controller;

import com.grc.user.domain.User;
import com.grc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 郭若辰
 * @create 2017-02-25 21:19
 */
//@RestController=@ResponseBody+@Controller
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/test" ,method = RequestMethod.GET)
    public List<User> test(){
        return userService.test();
    }
}
