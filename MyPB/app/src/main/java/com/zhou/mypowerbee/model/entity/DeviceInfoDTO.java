package com.zhou.mypowerbee.model.entity;

import java.util.List;
import java.util.Map;

/**
 * Created by zhou on 17-3-5.
 */

public class DeviceInfoDTO extends BaseDTO {

    class DeviceDTO {
        public final static int MIN_AIR_CONDITIONING_TEMP = 16;
        public final static int MAX_AIR_CONDITIONING_TEMP = 30;
        public final static int DEFAULT_AIR_CONDITIONING_TEMP = 27;
        public final static int ABSOLUTE_TEMP = -174;

        private String uuid;
        private String pid;
        private boolean isnode;
        private int jid;
        private int type;
        private int devType;
        private String title;
        private String picture;
        private long value;
        private int expandvalue;
        private long status;
        private boolean disable;
        private String adduid;
        private String lastuid;
        private String addtime;
        private String lasttime;
        private Object expand;
        private Map<String, Object> param;
        private List<String> authorizes;

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public boolean isnode() {
            return isnode;
        }

        public void setIsnode(boolean isnode) {
            this.isnode = isnode;
        }

        public int getJid() {
            return jid;
        }

        public void setJid(int jid) {
            this.jid = jid;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getDevType() {
            return devType;
        }

        public void setDevType(int devType) {
            this.devType = devType;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public long getValue() {
            return value;
        }

        public void setValue(long value) {
            this.value = value;
        }

        public int getExpandvalue() {
            return expandvalue;
        }

        public void setExpandvalue(int expandvalue) {
            this.expandvalue = expandvalue;
        }

        public long getStatus() {
            return status;
        }

        public void setStatus(long status) {
            this.status = status;
        }

        public boolean isDisable() {
            return disable;
        }

        public void setDisable(boolean disable) {
            this.disable = disable;
        }

        public String getAdduid() {
            return adduid;
        }

        public void setAdduid(String adduid) {
            this.adduid = adduid;
        }

        public String getLastuid() {
            return lastuid;
        }

        public void setLastuid(String lastuid) {
            this.lastuid = lastuid;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getLasttime() {
            return lasttime;
        }

        public void setLasttime(String lasttime) {
            this.lasttime = lasttime;
        }

        public Object getExpand() {
            return expand;
        }

        public void setExpand(Object expand) {
            this.expand = expand;
        }

        public Map<String, Object> getParam() {
            return param;
        }

        public void setParam(Map<String, Object> param) {
            this.param = param;
        }

        public List<String> getAuthorizes() {
            return authorizes;
        }

        public void setAuthorizes(List<String> authorizes) {
            this.authorizes = authorizes;
        }
    }
}
