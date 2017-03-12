package com.grc.item.domain;

import java.util.Date;

/**
 * @author 郭若辰
 * @create 2017-03-12 12:29
 */
public class ItemDesc {

    private Long itemId;//商品id

    private String itemDesc;//商品描述

    private Date created;//创建时间

    private Date updated;//更新时间

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
