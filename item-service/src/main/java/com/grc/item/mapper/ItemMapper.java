package com.grc.item.mapper;

import com.grc.item.domain.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author 郭若辰
 * @create 2017-03-01 16:21
 */
@Mapper
public interface ItemMapper {

    Item getItemById(Long itemId);

    List<Item> getItemsPageable();

    List<ItemCategory> getItemCategroy(Long parentId);

    void insertItem(Item item);

    void insertItemDesc(ItemDesc itemDesc);

    void insertItemParamMsg(ItemParamMsg itemParamMsg);

    List<Map<String, Object>> getParamsPageable();

    void deleteParams(Long id);

    Long queryItemCatId(Long catId);

    String getExistParam(Long catId);

    void insertParam(ItemParam itemParam);

    ItemDesc loadItemDesc(Long itemId);

    ItemParam loadItemParam(Long itemId);

    void deleteItem(Long itemId);

    void deleteItemDesc(Long itemId);

    void deleteItemParamMsg(Long itemId);
}
