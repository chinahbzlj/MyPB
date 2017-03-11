package com.zhou.mypowerbee.model.entity;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zhou on 17-3-6.
 */

@Entity
public class User {
    private String Uuid;
    private String Aid;
    @Property(nameInDb = "USERID")
    private String Userid;
    private String Nick;
    @NotNull
    private String Pass;
    private String Tel;
    private String Phone;
    private String Addr;
    private String Email;
    private String Birthday;
    private String Sign;
    private String Company;
    private String Office;
    private String Imtoken;
    private String Openid;
    private String Avatarpath;
    private boolean Isman;
    private int Admin;
    private int Status;
    private String Adduid;
    private String Lastuid;
    @Transient
    private String Addtime;
    private String Lasttime;
    @Generated(hash = 1687211411)
    public User(String Uuid, String Aid, String Userid, String Nick,
            @NotNull String Pass, String Tel, String Phone, String Addr,
            String Email, String Birthday, String Sign, String Company,
            String Office, String Imtoken, String Openid, String Avatarpath,
            boolean Isman, int Admin, int Status, String Adduid, String Lastuid,
            String Lasttime) {
        this.Uuid = Uuid;
        this.Aid = Aid;
        this.Userid = Userid;
        this.Nick = Nick;
        this.Pass = Pass;
        this.Tel = Tel;
        this.Phone = Phone;
        this.Addr = Addr;
        this.Email = Email;
        this.Birthday = Birthday;
        this.Sign = Sign;
        this.Company = Company;
        this.Office = Office;
        this.Imtoken = Imtoken;
        this.Openid = Openid;
        this.Avatarpath = Avatarpath;
        this.Isman = Isman;
        this.Admin = Admin;
        this.Status = Status;
        this.Adduid = Adduid;
        this.Lastuid = Lastuid;
        this.Lasttime = Lasttime;
    }
    @Generated(hash = 586692638)
    public User() {
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
    public String getUserid() {
        return this.Userid;
    }
    public void setUserid(String Userid) {
        this.Userid = Userid;
    }
    public String getNick() {
        return this.Nick;
    }
    public void setNick(String Nick) {
        this.Nick = Nick;
    }
    public String getPass() {
        return this.Pass;
    }
    public void setPass(String Pass) {
        this.Pass = Pass;
    }
    public String getTel() {
        return this.Tel;
    }
    public void setTel(String Tel) {
        this.Tel = Tel;
    }
    public String getPhone() {
        return this.Phone;
    }
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
    public String getAddr() {
        return this.Addr;
    }
    public void setAddr(String Addr) {
        this.Addr = Addr;
    }
    public String getEmail() {
        return this.Email;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }
    public String getBirthday() {
        return this.Birthday;
    }
    public void setBirthday(String Birthday) {
        this.Birthday = Birthday;
    }
    public String getSign() {
        return this.Sign;
    }
    public void setSign(String Sign) {
        this.Sign = Sign;
    }
    public String getCompany() {
        return this.Company;
    }
    public void setCompany(String Company) {
        this.Company = Company;
    }
    public String getOffice() {
        return this.Office;
    }
    public void setOffice(String Office) {
        this.Office = Office;
    }
    public String getImtoken() {
        return this.Imtoken;
    }
    public void setImtoken(String Imtoken) {
        this.Imtoken = Imtoken;
    }
    public String getOpenid() {
        return this.Openid;
    }
    public void setOpenid(String Openid) {
        this.Openid = Openid;
    }
    public String getAvatarpath() {
        return this.Avatarpath;
    }
    public void setAvatarpath(String Avatarpath) {
        this.Avatarpath = Avatarpath;
    }
    public boolean getIsman() {
        return this.Isman;
    }
    public void setIsman(boolean Isman) {
        this.Isman = Isman;
    }
    public int getAdmin() {
        return this.Admin;
    }
    public void setAdmin(int Admin) {
        this.Admin = Admin;
    }
    public int getStatus() {
        return this.Status;
    }
    public void setStatus(int Status) {
        this.Status = Status;
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
    public String getLasttime() {
        return this.Lasttime;
    }
    public void setLasttime(String Lasttime) {
        this.Lasttime = Lasttime;
    }
}
