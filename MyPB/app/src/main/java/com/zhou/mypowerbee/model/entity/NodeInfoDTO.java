package com.zhou.mypowerbee.model.entity;

import java.util.List;

/**
 * Created by zhou on 17-3-5.
 */

public class NodeInfoDTO extends BaseDTO {
    public List<NodeDTO> Data;

    class NodeDTO {
        private String uuid;
        private String cid;
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

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getNid() {
            return nid;
        }

        public void setNid(String nid) {
            this.nid = nid;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCustcode() {
            return custcode;
        }

        public void setCustcode(String custcode) {
            this.custcode = custcode;
        }

        public long getStatus() {
            return status;
        }

        public void setStatus(long status) {
            this.status = status;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public int getVid() {
            return vid;
        }

        public void setVid(int vid) {
            this.vid = vid;
        }

        public int getSensortype() {
            return sensortype;
        }

        public void setSensortype(int sensortype) {
            this.sensortype = sensortype;
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
    }
}
