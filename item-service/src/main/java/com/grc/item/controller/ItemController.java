package com.grc.item.controller;

import com.grc.common.BaseController;
import com.grc.common.JsonUtils;
import com.grc.item.domain.Item;
import com.grc.item.domain.ItemCategory;
import com.grc.item.domain.ItemDesc;
import com.grc.item.domain.ItemParam;
import com.grc.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
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

    /*
    上传图片
     */
    @RequestMapping(value = "/pic/upload", method = RequestMethod.POST)
    public String upload(MultipartFile uploadFile) {
        Map<String, Object> map;
        try {
            //访问图片的url
            String url = itemService.upload(uploadFile);
            map = KESuccess(url);
            //为了保证功能的兼容性（火狐浏览器），需要把结果转换为json格式的字符串
            return JsonUtils.objectToJson(map);
        } catch (IOException e) {
            map = KEFail("文件" + uploadFile.getOriginalFilename() + "上传失败");
            return JsonUtils.objectToJson(map);
        }
    }

    /*
    新增商品
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Map<String, Object> insertItem(Item item, String desc, String itemParams) {
        try {
            Long id = itemService.insertItem(item, desc, itemParams);
            return okResponse("商品 " + id + " 新增成功");
        } catch (Exception e) {
            return badResponse(e.getMessage());
        }
    }

    /*
    查询商品规格参数模板列表
     */
    @RequestMapping(value = "/param/list", method = RequestMethod.GET)
    public Map<String, Object> getParamsPageable(int page, int rows) {
        try {
            return easyUIDatagrid(itemService.getParamsPageable(page, rows));
        } catch (Exception e) {
            return badResponse(e.getMessage());
        }
    }

    /*
    删除规格参数模板
     */
    @RequestMapping(value = "/param/delete", method = RequestMethod.POST)
    public Map<String, Object> deleteParams(String ids) {
        List<Long> idList = new ArrayList<>();
        String[] idArray = ids.split(",");
        for (String s : idArray) {
            idList.add(Long.parseLong(s));
        }
        try {
            itemService.deleteParams(idList);
            return okResponse("删除成功");
        } catch (Exception e) {
            return badResponse(e.getMessage());
        }
    }

    /*
    判断选择的类目是否已经添加过规格模板，如果已经添加过，就获取规格模板
     */
    @RequestMapping(value = "/param/query/itemcatid/{catId}", method = RequestMethod.GET)
    public Map<String, Object> queryItemCatId(@PathVariable Long catId) {
        Long count = itemService.queryItemCatId(catId);
        if (count != 0) {
            try {
                Map<String, Object> data = new HashMap<>();
                data.put("paramData", itemService.getExistParam(catId));
                return okResponse(data);
            } catch (Exception e) {
                return badResponse(e.getMessage());
            }
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("code", 400);
            return map;
        }
    }

    /*
    新增商品类目的规格模板
     */
    @RequestMapping(value = "/param/save", method = RequestMethod.POST)
    public Map<String, Object> insertParam(ItemParam itemParam) {
        try {
            itemService.insertParam(itemParam);
            return okResponse("规格模板添加成功！");
        } catch (Exception e) {
            return badResponse(e.getMessage());
        }
    }

    /*
    获取商品描述信息
     */
    @RequestMapping(value = "/load/desc/{itemId}", method = RequestMethod.GET)
    public Map<String, Object> loadItemDesc(@PathVariable Long itemId) {
        try {
            ItemDesc data = itemService.loadItemDesc(itemId);
            return okResponse(data);
        } catch (Exception e) {
            return badResponse(e.getMessage());
        }
    }

    /*
    获取商品的规格参数信息
     */
    @RequestMapping(value = "/load/param/{itemId}", method = RequestMethod.GET)
    public Map<String, Object> loadItemParam(@PathVariable Long itemId) {
        try {
            ItemParam data = itemService.loadItemParam(itemId);
            return okResponse(data);
        } catch (Exception e) {
            return badResponse(e.getMessage());
        }
    }

    /*
    删除商品
    */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Map<String, Object> deleteItems(String ids) {
        List<Long> idList = new ArrayList<>();
        String[] idArray = ids.split(",");
        for (String s : idArray) {
            idList.add(Long.parseLong(s));
        }
        try {
            itemService.deleteItems(idList);
            return okResponse("删除成功");
        } catch (Exception e) {
            return badResponse(e.getMessage());
        }
    }

    /*
    下架商品
     */
    @RequestMapping(value = "/instock", method = RequestMethod.POST)
    public Map<String, Object> instockItem(String ids) {
        List<Long> idList = new ArrayList<>();
        String[] idArray = ids.split(",");
        for (String s : idArray) {
            idList.add(Long.parseLong(s));
        }
        try {
            itemService.instockItem(idList);
            return okResponse("下架成功！");
        } catch (Exception e) {
            return badResponse(e.getMessage());
        }
    }

    /*
    上架商品
     */
    @RequestMapping(value = "/reshelf", method = RequestMethod.POST)
    public Map<String, Object> reshelfItem(String ids) {
        List<Long> idList = new ArrayList<>();
        String[] idArray = ids.split(",");
        for (String s : idArray) {
            idList.add(Long.parseLong(s));
        }
        try {
            itemService.reshelfItem(idList);
            return okResponse("上架成功！");
        } catch (Exception e) {
            return badResponse(e.getMessage());
        }
    }

    /*
    编辑商品
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map<String, Object> updateItem(Item item, String desc, Long itemParamId, String itemParams) {
        try {
            itemService.updateItem(item, desc, itemParamId, itemParams);
            return okResponse("商品" + item.getId() + "编辑成功！");
        } catch (Exception e) {
            return badResponse(e.getMessage());
        }
    }
}
