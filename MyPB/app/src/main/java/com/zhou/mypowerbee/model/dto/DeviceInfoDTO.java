package com.zhou.mypowerbee.model.dto;

import com.zhou.mypowerbee.model.entity.Device;
import com.zhou.mypowerbee.util.JSONHelper;

import java.util.List;
import java.util.Map;

/**
 * Created by zhou on 17-3-5.
 */

public class DeviceInfoDTO extends BaseDTO {
    public List<DeviceDTO> Data;

    public class DeviceDTO {
        public final static int MIN_AIR_CONDITIONING_TEMP = 16;
        public final static int MAX_AIR_CONDITIONING_TEMP = 30;
        public final static int DEFAULT_AIR_CONDITIONING_TEMP = 27;
        public final static int ABSOLUTE_TEMP = -174;

        private String Uuid;
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
        private Object Expand;
        private Object Param;
        private List<String> Authorizes;


        public Device toDevice() {
            Device device = new Device();
            device.setUuid(getUuid());
            device.setPid(getPid());
            device.setIsnode(isnode());
            device.setJid(getJid());
            device.setType(getType());
            device.setDevType(getDevType());
            device.setTitle(getTitle());
            device.setPicture(getPicture());
            device.setValue(getValue());
            device.setExpandvalue(getExpandvalue());
            device.setStatus(getStatus());
            device.setDisable(isDisable());
            device.setAdduid(getAdduid());
            device.setLastuid(getLastuid());
            device.setAddtime(getAddtime());
            device.setLasttime(getLasttime());
            device.setExpand(JSONHelper.toJson(getExpand()));
            device.setParam(JSONHelper.toJson(getParam()));
            device.setAuthorizes(JSONHelper.toJson(getAuthorizes()));
            return device;
        }

//        public DeviceDTO (Device device){
//            setUuid(device.getUuid());
//            setPid(device.getPid());
//            setIsnode(isnode());
//            setJid(device.getJid());
//            setType(device.getType());
//            setDevType(device.getDevType());
//            setTitle(device.getTitle());
//            setPicture(device.getPicture());
//            setValue(device.getValue());
//            setExpandvalue(device.getExpandvalue());
//            setStatus(device.getStatus());
//            setDisable(isDisable());
//            setAdduid(device.getAdduid());
//            setLastuid(device.getLastuid());
//            setAddtime(device.getAddtime());
//            setLasttime(device.getLasttime());
//            setExpand(device.getExpand());
//            setParam(device.getParam());
//            setAuthorizes(device.getAuthorizes());
//        }

        public DeviceDTO() {
        }

        public String getUuid() {
            return Uuid;
        }

        public void setUuid(String uuid) {
            Uuid = uuid;
        }

        public String getPid() {
            return Pid;
        }

        public void setPid(String pid) {
            Pid = pid;
        }

        public boolean isnode() {
            return Isnode;
        }

        public void setIsnode(boolean isnode) {
            Isnode = isnode;
        }

        public int getJid() {
            return Jid;
        }

        public void setJid(int jid) {
            Jid = jid;
        }

        public int getType() {
            return Type;
        }

        public void setType(int type) {
            Type = type;
        }

        public int getDevType() {
            return DevType;
        }

        public void setDevType(int devType) {
            DevType = devType;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public String getPicture() {
            return Picture;
        }

        public void setPicture(String picture) {
            Picture = picture;
        }

        public long getValue() {
            return Value;
        }

        public void setValue(long value) {
            Value = value;
        }

        public int getExpandvalue() {
            return Expandvalue;
        }

        public void setExpandvalue(int expandvalue) {
            Expandvalue = expandvalue;
        }

        public long getStatus() {
            return Status;
        }

        public void setStatus(long status) {
            Status = status;
        }

        public boolean isDisable() {
            return Disable;
        }

        public void setDisable(boolean disable) {
            Disable = disable;
        }

        public String getAdduid() {
            return Adduid;
        }

        public void setAdduid(String adduid) {
            Adduid = adduid;
        }

        public String getLastuid() {
            return Lastuid;
        }

        public void setLastuid(String lastuid) {
            Lastuid = lastuid;
        }

        public String getAddtime() {
            return Addtime;
        }

        public void setAddtime(String addtime) {
            Addtime = addtime;
        }

        public String getLasttime() {
            return Lasttime;
        }

        public void setLasttime(String lasttime) {
            Lasttime = lasttime;
        }

        public Object getExpand() {
            return Expand;
        }

        public void setExpand(Object expand) {
            Expand = expand;
        }

        public Object getParam() {
            return Param;
        }

        public void setParam(Object param) {
            Param = param;
        }

        public List<String> getAuthorizes() {
            return Authorizes;
        }

        public void setAuthorizes(List<String> Authorizes) {
            this.Authorizes = Authorizes;
        }

    }
}
