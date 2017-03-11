package com.zhou.mypowerbee.model.entity;

import com.zhou.mypowerbee.model.dto.TerminalInfoDTO;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zhou on 17-3-6.
 */

@Entity
public class Terminal {
    @Id
    private String Cid;
    private String Macid;
    private String Name;
    private String Userid;
    private int Protocol;
    private int Vid;
    private int Pid;
    private long Version;
    private String Custcode;
    private String Svraddr;
    private int Svrport;
    private int Eraseaddr;
    private int Status;
    private int Sensortype;
    private int Pirdelay;
    private String Stime;
    private String Etime;
    private String Adduid;
    private String Lastuid;
    private String Addtime;
    private String Lasttime;
    @Generated(hash = 776246684)
    public Terminal(String Cid, String Macid, String Name, String Userid,
            int Protocol, int Vid, int Pid, long Version, String Custcode,
            String Svraddr, int Svrport, int Eraseaddr, int Status, int Sensortype,
            int Pirdelay, String Stime, String Etime, String Adduid, String Lastuid,
            String Addtime, String Lasttime) {
        this.Cid = Cid;
        this.Macid = Macid;
        this.Name = Name;
        this.Userid = Userid;
        this.Protocol = Protocol;
        this.Vid = Vid;
        this.Pid = Pid;
        this.Version = Version;
        this.Custcode = Custcode;
        this.Svraddr = Svraddr;
        this.Svrport = Svrport;
        this.Eraseaddr = Eraseaddr;
        this.Status = Status;
        this.Sensortype = Sensortype;
        this.Pirdelay = Pirdelay;
        this.Stime = Stime;
        this.Etime = Etime;
        this.Adduid = Adduid;
        this.Lastuid = Lastuid;
        this.Addtime = Addtime;
        this.Lasttime = Lasttime;
    }
    @Generated(hash = 2104428940)
    public Terminal() {
    }
    public String getCid() {
        return this.Cid;
    }
    public void setCid(String Cid) {
        this.Cid = Cid;
    }
    public String getMacid() {
        return this.Macid;
    }
    public void setMacid(String Macid) {
        this.Macid = Macid;
    }
    public String getName() {
        return this.Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getUserid() {
        return this.Userid;
    }
    public void setUserid(String Userid) {
        this.Userid = Userid;
    }
    public int getProtocol() {
        return this.Protocol;
    }
    public void setProtocol(int Protocol) {
        this.Protocol = Protocol;
    }
    public int getVid() {
        return this.Vid;
    }
    public void setVid(int Vid) {
        this.Vid = Vid;
    }
    public int getPid() {
        return this.Pid;
    }
    public void setPid(int Pid) {
        this.Pid = Pid;
    }
    public long getVersion() {
        return this.Version;
    }
    public void setVersion(long Version) {
        this.Version = Version;
    }
    public String getCustcode() {
        return this.Custcode;
    }
    public void setCustcode(String Custcode) {
        this.Custcode = Custcode;
    }
    public String getSvraddr() {
        return this.Svraddr;
    }
    public void setSvraddr(String Svraddr) {
        this.Svraddr = Svraddr;
    }
    public int getSvrport() {
        return this.Svrport;
    }
    public void setSvrport(int Svrport) {
        this.Svrport = Svrport;
    }
    public int getEraseaddr() {
        return this.Eraseaddr;
    }
    public void setEraseaddr(int Eraseaddr) {
        this.Eraseaddr = Eraseaddr;
    }
    public int getStatus() {
        return this.Status;
    }
    public void setStatus(int Status) {
        this.Status = Status;
    }
    public int getSensortype() {
        return this.Sensortype;
    }
    public void setSensortype(int Sensortype) {
        this.Sensortype = Sensortype;
    }
    public int getPirdelay() {
        return this.Pirdelay;
    }
    public void setPirdelay(int Pirdelay) {
        this.Pirdelay = Pirdelay;
    }
    public String getStime() {
        return this.Stime;
    }
    public void setStime(String Stime) {
        this.Stime = Stime;
    }
    public String getEtime() {
        return this.Etime;
    }
    public void setEtime(String Etime) {
        this.Etime = Etime;
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
}
