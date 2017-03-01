package com.grc.item.controller;

import com.grc.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 郭若辰
 * @create 2017-03-01 16:17
 */
@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public List<Map<String, Object>> test() {
        return itemService.test();
    }
}
