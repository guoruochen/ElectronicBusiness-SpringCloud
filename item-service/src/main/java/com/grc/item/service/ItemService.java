package com.grc.item.service;

import com.grc.item.domain.Item;

import java.util.List;
import java.util.Map;

/**
 * @author 郭若辰
 * @create 2017-03-01 16:11
 */
public interface ItemService {

    Item getItemById(Long itemId);

    List<Item> getItemsPageable(int page, int rows);
}
