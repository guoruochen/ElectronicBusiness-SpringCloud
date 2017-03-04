package com.grc.item.service.impl;

import com.github.pagehelper.PageHelper;
import com.grc.item.domain.Item;
import com.grc.item.domain.ItemCategory;
import com.grc.item.mapper.ItemMapper;
import com.grc.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 郭若辰
 * @create 2017-03-01 16:12
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemMapper itemMapper;

    /*
    根据id查询商品
     */
    @Override
    public Item getItemById(Long itemId) {
        return itemMapper.getItemById(itemId);
    }

    /*
    查询商品列表
     */
    @Override
    public List<Item> getItemsPageable(int page, int rows) {
        PageHelper.startPage(page, rows);//分页处理
        return itemMapper.getItemsPageable();
    }

    /*
    选择商品类目
     */
    @Override
    public List<ItemCategory> getItemCategroy(Long parentId) {
        return itemMapper.getItemCategroy(parentId);
    }
}
