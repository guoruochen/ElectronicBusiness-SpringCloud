package com.grc.item.service;

import com.grc.item.domain.Item;

import java.util.List;
import java.util.Map;

/**
 * @author 郭若辰
 * @create 2017-03-01 16:11
 */
public interface ItemService {

    /*
    根据id查询商品
     */
    Item getItemById(Long itemId);


}
