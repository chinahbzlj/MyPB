package com.zhou.mypowerbee.model.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;

/**
 * Created by zhou on 17-3-7.
 */
@Entity
public class Group {
    private String Uuid;
    private String Aid;
    private String Devids;
    private String Uid;
    private String Title;
    private String Expand;
    @Generated(hash = 770822868)
    public Group(String Uuid, String Aid, String Devids, String Uid, String Title,
            String Expand) {
        this.Uuid = Uuid;
        this.Aid = Aid;
        this.Devids = Devids;
        this.Uid = Uid;
        this.Title = Title;
        this.Expand = Expand;
    }
    @Generated(hash = 117982048)
    public Group() {
    }
    public String getUuid() {
        return this.Uuid;
    }
    public void setUuid(String Uuid) {
        this.Uuid = Uuid;
    }
    public String getAid() {
        return this.Aid;
    }
    public void setAid(String Aid) {
        this.Aid = Aid;
    }
    public String getDevids() {
        return this.Devids;
    }
    public void setDevids(String Devids) {
        this.Devids = Devids;
    }
    public String getUid() {
        return this.Uid;
    }
    public void setUid(String Uid) {
        this.Uid = Uid;
    }
    public String getTitle() {
        return this.Title;
    }
    public void setTitle(String Title) {
        this.Title = Title;
    }
    public String getExpand() {
        return this.Expand;
    }
    public void setExpand(String Expand) {
        this.Expand = Expand;
    }
}