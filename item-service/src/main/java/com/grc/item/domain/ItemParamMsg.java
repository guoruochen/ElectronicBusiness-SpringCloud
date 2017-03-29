package com.grc.item.domain;

import java.util.Date;

/**
 * @author 郭若辰
 * @create 2017-03-29 16:07
 */
public class ItemParamMsg {
    private Long id;//规格参数信息id

    private Long itemId;//商品id

    private String paramData;//规格参数信息

    private Date created;//创建时间

    private Date updated;//修改时间

    public Long getId() {
        return id;
    }

    public ItemParamMsg setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getItemId() {
        return itemId;
    }

    public ItemParamMsg setItemId(Long itemId) {
        this.itemId = itemId;
        return this;
    }

    public String getParamData() {
        return paramData;
    }

    public ItemParamMsg setParamData(String paramData) {
        this.paramData = paramData;
        return this;
    }

    public Date getCreated() {
        return created;
    }

    public ItemParamMsg setCreated(Date created) {
        this.created = created;
        return this;
    }

    public Date getUpdated() {
        return updated;
    }

    public ItemParamMsg setUpdated(Date updated) {
        this.updated = updated;
        return this;
    }
}
