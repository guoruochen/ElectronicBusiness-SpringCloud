package com.grc.user.mapper;

import com.grc.user.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author 郭若辰
 * @create 2017-02-28 15:13
 */
@Mapper
public interface UserMapper {

    User login(User user);
}
