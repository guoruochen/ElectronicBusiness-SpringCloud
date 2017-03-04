package com.grc.item.domain;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * @author 郭若辰
 * @create 2017-03-04 15:29
 */
public class ItemCategory {

    private Long id;//商品类目id

    private Long parentId;//父类目id（父类目ID=0时，代表的是一级的类目）

    private String name;//类目名称

    private Long status;//类目状态（可选值:1(正常),2(删除)）

    private Long sortOrder;//排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数

    private Long isParent;//该类目是否为父类目，1为true，0为false

    private Date created;//创建时间

    private Data updated;//更新时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Long getIsParent() {
        return isParent;
    }

    public void setIsParent(Long isParent) {
        this.isParent = isParent;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Data getUpdated() {
        return updated;
    }

    public void setUpdated(Data updated) {
        this.updated = updated;
    }
}
