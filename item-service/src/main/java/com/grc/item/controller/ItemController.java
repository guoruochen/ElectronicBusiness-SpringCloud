package com.grc.item.controller;

import com.grc.common.BaseController;
import com.grc.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author 郭若辰
 * @create 2017-03-01 16:17
 */
@RestController
public class ItemController extends BaseController{

    @Autowired
    ItemService itemService;

    /*
    根据id查询商品
     */
    @RequestMapping(value = "/{itemId}", method = RequestMethod.GET)
    public Map<String, Object> getItemById(@PathVariable Long itemId) {
        try {
            return okResponse(itemService.getItemById(itemId));
        }catch (Exception e){
            return badResponse(e.getMessage());
        }
    }
}
