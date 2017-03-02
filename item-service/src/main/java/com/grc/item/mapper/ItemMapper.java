package com.grc.item.mapper;

import com.grc.item.domain.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author 郭若辰
 * @create 2017-03-01 16:21
 */
@Mapper
public interface ItemMapper {

    /*
    根据id查询商品
     */
    Item getItemById(Long itemId);
}
