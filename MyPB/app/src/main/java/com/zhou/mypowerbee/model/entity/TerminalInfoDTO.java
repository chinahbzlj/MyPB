package com.zhou.mypowerbee.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhou on 17-3-5.
 */

public class TerminalInfoDTO extends BaseDTO {
    public List<TerminalDTO> Data;

    public class TerminalDTO {

        private String Cid;
        private String Macid;
        private String Name;
        private String Userid;
        private int Protocol;
        private int Vid;
        private int Pid;
        private int Version;
        private String Custcode;
        private String Svraddr;
        private int Svrport;
        private String Eraseaddr;
        private int Status;
        private int Sensortype;
        private int Pirdelay;
        private String Stime;
        private String Etime;
        private String Adduid;
        private String Lastuid;
        private String Addtime;
        private String Lasttime;

        public String getCid() {
            return Cid;
        }

        public void setCid(String cid) {
            Cid = cid;
        }

        public String getMacid() {
            return Macid;
        }

        public void setMacid(String macid) {
            Macid = macid;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getUserid() {
            return Userid;
        }

        public void setUserid(String userid) {
            Userid = userid;
        }

        public int getProtocol() {
            return Protocol;
        }

        public void setProtocol(int protocol) {
            Protocol = protocol;
        }

        public int getVid() {
            return Vid;
        }

        public void setVid(int vid) {
            Vid = vid;
        }

        public int getPid() {
            return Pid;
        }

        public void setPid(int pid) {
            Pid = pid;
        }

        public int getVersion() {
            return Version;
        }

        public void setVersion(int version) {
            Version = version;
        }

        public String getCustcode() {
            return Custcode;
        }

        public void setCustcode(String custcode) {
            Custcode = custcode;
        }

        public String getSvraddr() {
            return Svraddr;
        }

        public void setSvraddr(String svraddr) {
            Svraddr = svraddr;
        }

        public int getSvrport() {
            return Svrport;
        }

        public void setSvrport(int svrport) {
            Svrport = svrport;
        }

        public String getEraseaddr() {
            return Eraseaddr;
        }

        public void setEraseaddr(String eraseaddr) {
            Eraseaddr = eraseaddr;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int status) {
            Status = status;
        }

        public int getSensortype() {
            return Sensortype;
        }

        public void setSensortype(int sensortype) {
            Sensortype = sensortype;
        }

        public int getPirdelay() {
            return Pirdelay;
        }

        public void setPirdelay(int pirdelay) {
            Pirdelay = pirdelay;
        }
    }

}
