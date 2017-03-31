package com.grc.item.service;

import com.grc.item.domain.Item;
import com.grc.item.domain.ItemCategory;
import com.grc.item.domain.ItemDesc;
import com.grc.item.domain.ItemParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author 郭若辰
 * @create 2017-03-01 16:11
 */
public interface ItemService {

    Item getItemById(Long itemId);

    List<Item> getItemsPageable(int page, int rows);

    List<ItemCategory> getItemCategroy(Long parentId);

    String upload(MultipartFile uploadFile) throws IOException;

    Long insertItem(Item item, String desc, String itemParams);

    List<Map<String, Object>> getParamsPageable(int page, int rows);

    void deleteParams(List<Long> ids);

    Long queryItemCatId(Long catId);

    String getExistParam(Long catId);

    void insertParam(ItemParam itemParam);

    ItemDesc loadItemDesc(Long itemId);

    ItemParam loadItemParam(Long itemId);

    void deleteItems(List<Long> ids);

    void instockItem(List<Long> ids);

    void reshelfItem(List<Long> ids);

    void updateItem(Item item, String desc, Long itemParamId, String itemParams);
}
