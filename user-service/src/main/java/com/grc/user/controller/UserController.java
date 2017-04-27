package com.grc.user.controller;

import com.grc.common.BaseController;
import com.grc.user.domain.User;
import com.grc.user.jwt.AuthTokenDetails;
import com.grc.user.jwt.JsonWebTokenUtility;
import com.grc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * @author 郭若辰
 * @create 2017-02-25 21:19
 */
//@RestController=@ResponseBody+@Controller
@RestController
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    private JsonWebTokenUtility tokenService = new JsonWebTokenUtility();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> login(@RequestBody User u) {
        User user = userService.login(u);
        //如果用户名密码正确，则生成token
        if (user != null) {
            //设置token中的内容
            AuthTokenDetails authTokenDetails = new AuthTokenDetails();
            authTokenDetails.setId(user.getId())
                    .setUsername(user.getUsername())
                    .setExpirationDate(buildExpirationDate());
            // 生成token
            String jwt = tokenService.createJsonWebToken(authTokenDetails);
            return loginOkResp(jwt);
        } else {
            return loginBadResp("用户名或密码错误！");
        }
    }

    //设置token过期时间为11个小时
    private Date buildExpirationDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, 1);
        return calendar.getTime();
    }
}
