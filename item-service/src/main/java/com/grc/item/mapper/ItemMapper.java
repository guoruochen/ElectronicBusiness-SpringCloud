package com.grc.item.mapper;

import com.grc.item.domain.Item;
import com.grc.item.domain.ItemCategory;
import com.grc.item.domain.ItemDesc;
import com.grc.item.domain.ItemParam;
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

    List<Map<String, Object>> getParamsPageable();

    void deleteParams(Long id);

    Long queryItemCatId(Long catId);

    String getExistParam(Long catId);

    void insertParam(ItemParam itemParam);
}
