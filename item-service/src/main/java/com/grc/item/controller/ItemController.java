package com.grc.item.controller;

import com.grc.common.BaseController;
import com.grc.item.domain.Item;
import com.grc.item.domain.ItemCategory;
import com.grc.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        try {
            return easyUIDatagrid(itemService.getItemsPageable(page, rows));
        } catch (Exception e) {
            return badResponse(e.getMessage());
        }
    }

    /*
    选择商品类目
     */
    @RequestMapping(value = "/cat/list", method = RequestMethod.POST)
    public List<Map<String, Object>> getItemCategroy(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
        List<Map<String, Object>> ret = new ArrayList<>();
        List<ItemCategory> list = itemService.getItemCategroy(parentId);
        try {
            for (ItemCategory itemCategory : list) {
                Map<String, Object> map = easyUITree(itemCategory.getId(), itemCategory.getName(), (itemCategory.getIsParent() == 1) ? "closed" : "open");
                ret.add(map);
            }
            return ret;
        } catch (Exception e) {
            ret.add(badResponse(e.getMessage()));
            return ret;
        }
    }

}
