package com.grc.user.controller;

import com.grc.user.domain.User;
import com.grc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
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

    private JsonWebTokenUtility tokenService = new JsonWebTokenUtility();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public AuthTokenDTO login(@RequestBody User u) {
        AuthTokenDTO authToken = null;

        User user = userService.login(u);

        if (user != null) {


            AuthTokenDetails authTokenDetails = new AuthTokenDetails();
            authTokenDetails.setId(user.getId());
            authTokenDetails.setUsername(user.getUsername());
            authTokenDetails.setExpirationDate(buildExpirationDate());

            // 创建token
            String jwt = tokenService.createJsonWebToken(authTokenDetails);
            if (jwt != null) {
                authToken = new AuthTokenDTO();
                authToken.setToken(jwt);
                authToken.setUserId(user.getId());
            }
        } else {
            throw new RuntimeException("用户名或密码错误");
        }

        return authToken;
    }


    private Date buildExpirationDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, 1);
        return calendar.getTime();
    }
}
