package com.zhou.mypowerbee.model.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by zhou on 17-3-7.
 */
@Entity
public class Node {
    private String uuid;
    private String cid;
    @Id
    private String nid;
    private int type;
    private String name;
    private String custcode;
    private long status;
    private int pid;
    private int vid;
    private int sensortype;
    private String adduid;
    private String lastuid;
    private String addtime;
    private String lasttime;
    @Generated(hash = 601133186)
    public Node(String uuid, String cid, String nid, int type, String name,
            String custcode, long status, int pid, int vid, int sensortype,
            String adduid, String lastuid, String addtime, String lasttime) {
        this.uuid = uuid;
        this.cid = cid;
        this.nid = nid;
        this.type = type;
        this.name = name;
        this.custcode = custcode;
        this.status = status;
        this.pid = pid;
        this.vid = vid;
        this.sensortype = sensortype;
        this.adduid = adduid;
        this.lastuid = lastuid;
        this.addtime = addtime;
        this.lasttime = lasttime;
    }
    @Generated(hash = 957215351)
    public Node() {
    }
    public String getUuid() {
        return this.uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getCid() {
        return this.cid;
    }
    public void setCid(String cid) {
        this.cid = cid;
    }
    public String getNid() {
        return this.nid;
    }
    public void setNid(String nid) {
        this.nid = nid;
    }
    public int getType() {
        return this.type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCustcode() {
        return this.custcode;
    }
    public void setCustcode(String custcode) {
        this.custcode = custcode;
    }
    public long getStatus() {
        return this.status;
    }
    public void setStatus(long status) {
        this.status = status;
    }
    public int getPid() {
        return this.pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }
    public int getVid() {
        return this.vid;
    }
    public void setVid(int vid) {
        this.vid = vid;
    }
    public int getSensortype() {
        return this.sensortype;
    }
    public void setSensortype(int sensortype) {
        this.sensortype = sensortype;
    }
    public String getAdduid() {
        return this.adduid;
    }
    public void setAdduid(String adduid) {
        this.adduid = adduid;
    }
    public String getLastuid() {
        return this.lastuid;
    }
    public void setLastuid(String lastuid) {
        this.lastuid = lastuid;
    }
    public String getAddtime() {
        return this.addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }
    public String getLasttime() {
        return this.lasttime;
    }
    public void setLasttime(String lasttime) {
        this.lasttime = lasttime;
    }
}
