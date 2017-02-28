package com.grc.user.service.impl;

import com.grc.user.mapper.UserMapper;
import com.grc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author 郭若辰
 * @create 2017-02-28 15:14
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public List<Map<String, Object>> test() {
        return userMapper.test();
    }
}
