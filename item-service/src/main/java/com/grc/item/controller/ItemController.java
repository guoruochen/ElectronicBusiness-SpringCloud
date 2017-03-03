package com.grc.item.controller;

import com.github.pagehelper.Page;
import com.grc.common.BaseController;
import com.grc.item.domain.Item;
import com.grc.item.service.ItemService;
import org.apache.ibatis.ognl.IntHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 郭若辰
 * @create 2017-03-01 16:17
 */
@RestController
public class ItemController extends BaseController {

    @Autowired
    ItemService itemService;

    /*
    根据id查询商品
     */
    @RequestMapping(value = "/{itemId}", method = RequestMethod.GET)
    public Item getItemById(@PathVariable Long itemId) {
        return itemService.getItemById(itemId);
    }

    /*
    查询商品列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> getItemsPageable(int page, int rows) {
        return easyUIPageable(itemService.getItemsPageable(page, rows));
    }

}
