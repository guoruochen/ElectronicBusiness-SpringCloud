package com.grc.item.domain;

import java.util.Date;

/**
 * @author 郭若辰
 * @create 2017-03-29 12:09
 */
public class ItemParam {
    private Long id;//规格模板id

    private Long cid;//商品类目id

    private String paramData;//规格模板

    private Date created;//创建时间

    private Date updated;//修改时间

    public Long getId() {
        return id;
    }

    public ItemParam setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getCid() {
        return cid;
    }

    public ItemParam setCid(Long cid) {
        this.cid = cid;
        return this;
    }

    public String getParamData() {
        return paramData;
    }

    public ItemParam setParamData(String paramData) {
        this.paramData = paramData;
        return this;
    }

    public Date getCreated() {
        return created;
    }

    public ItemParam setCreated(Date created) {
        this.created = created;
        return this;
    }

    public Date getUpdated() {
        return updated;
    }

    public ItemParam setUpdated(Date updated) {
        this.updated = updated;
        return this;
    }
}
