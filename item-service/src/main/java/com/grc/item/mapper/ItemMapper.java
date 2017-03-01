package com.grc.item.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author 郭若辰
 * @create 2017-03-01 16:21
 */
@Mapper
public interface ItemMapper {

    List<Map<String,Object>> test();
}
