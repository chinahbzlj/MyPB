package com.zhou.mypowerbee.model.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;

import java.util.List;
import java.util.Map;

import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zhou on 17-3-7.
 */
@Entity
public class Device {

    private String Uuid;
    @Id
    private String Pid;
    private boolean Isnode;
    private int Jid;
    private int Type;
    private int DevType;
    private String Title;
    private String Picture;
    private long Value;
    private int Expandvalue;
    private long Status;
    private boolean Disable;
    private String Adduid;
    private String Lastuid;
    private String Addtime;
    private String Lasttime;
    private String Expand;
    private String Param;
    private String Authorizes;
    @Generated(hash = 565668741)
    public Device(String Uuid, String Pid, boolean Isnode, int Jid, int Type,
            int DevType, String Title, String Picture, long Value, int Expandvalue,
            long Status, boolean Disable, String Adduid, String Lastuid,
            String Addtime, String Lasttime, String Expand, String Param,
            String Authorizes) {
        this.Uuid = Uuid;
        this.Pid = Pid;
        this.Isnode = Isnode;
        this.Jid = Jid;
        this.Type = Type;
        this.DevType = DevType;
        this.Title = Title;
        this.Picture = Picture;
        this.Value = Value;
        this.Expandvalue = Expandvalue;
        this.Status = Status;
        this.Disable = Disable;
        this.Adduid = Adduid;
        this.Lastuid = Lastuid;
        this.Addtime = Addtime;
        this.Lasttime = Lasttime;
        this.Expand = Expand;
        this.Param = Param;
        this.Authorizes = Authorizes;
    }
    @Generated(hash = 1469582394)
    public Device() {
    }
    public String getUuid() {
        return this.Uuid;
    }
    public void setUuid(String Uuid) {
        this.Uuid = Uuid;
    }
    public String getPid() {
        return this.Pid;
    }
    public void setPid(String Pid) {
        this.Pid = Pid;
    }
    public boolean getIsnode() {
        return this.Isnode;
    }
    public void setIsnode(boolean Isnode) {
        this.Isnode = Isnode;
    }
    public int getJid() {
        return this.Jid;
    }
    public void setJid(int Jid) {
        this.Jid = Jid;
    }
    public int getType() {
        return this.Type;
    }
    public void setType(int Type) {
        this.Type = Type;
    }
    public int getDevType() {
        return this.DevType;
    }
    public void setDevType(int DevType) {
        this.DevType = DevType;
    }
    public String getTitle() {
        return this.Title;
    }
    public void setTitle(String Title) {
        this.Title = Title;
    }
    public String getPicture() {
        return this.Picture;
    }
    public void setPicture(String Picture) {
        this.Picture = Picture;
    }
    public long getValue() {
        return this.Value;
    }
    public void setValue(long Value) {
        this.Value = Value;
    }
    public int getExpandvalue() {
        return this.Expandvalue;
    }
    public void setExpandvalue(int Expandvalue) {
        this.Expandvalue = Expandvalue;
    }
    public long getStatus() {
        return this.Status;
    }
    public void setStatus(long Status) {
        this.Status = Status;
    }
    public boolean getDisable() {
        return this.Disable;
    }
    public void setDisable(boolean Disable) {
        this.Disable = Disable;
    }
    public String getAdduid() {
        return this.Adduid;
    }
    public void setAdduid(String Adduid) {
        this.Adduid = Adduid;
    }
    public String getLastuid() {
        return this.Lastuid;
    }
    public void setLastuid(String Lastuid) {
        this.Lastuid = Lastuid;
    }
    public String getAddtime() {
        return this.Addtime;
    }
    public void setAddtime(String Addtime) {
        this.Addtime = Addtime;
    }
    public String getLasttime() {
        return this.Lasttime;
    }
    public void setLasttime(String Lasttime) {
        this.Lasttime = Lasttime;
    }
    public String getExpand() {
        return this.Expand;
    }
    public void setExpand(String Expand) {
        this.Expand = Expand;
    }
    public String getParam() {
        return this.Param;
    }
    public void setParam(String Param) {
        this.Param = Param;
    }
    public String getAuthorizes() {
        return this.Authorizes;
    }
    public void setAuthorizes(String Authorizes) {
        this.Authorizes = Authorizes;
    }
}
