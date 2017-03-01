package com.grc.item.service.impl;

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

    @Override
    public List<Map<String, Object>> test() {
        return itemMapper.test();
    }
}
