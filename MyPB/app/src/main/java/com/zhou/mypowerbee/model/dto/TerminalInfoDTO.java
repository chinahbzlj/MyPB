package com.zhou.mypowerbee.model.dto;

import com.zhou.mypowerbee.model.entity.Terminal;

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

        public TerminalDTO(){}
        public Terminal toTerminal() {
            Terminal terminal = new Terminal();
            terminal.setCid(getCid());
            terminal.setMacid(getMacid());
            terminal.setName(getName());
            terminal.setUserid(getUserid());
            terminal.setProtocol(getProtocol());
            terminal.setVid(getVid());
            terminal.setPid(getPid());
            terminal.setVersion(getVersion());
            terminal.setCustcode(getCustcode());
            terminal.setSvraddr(getSvraddr());
            terminal.setSvrport(getSvrport());
            terminal.setEraseaddr(getEraseaddr());
            terminal.setStatus(getStatus());
            terminal.setSensortype(getSensortype());
            terminal.setPirdelay(getPirdelay());
            return terminal;
        }

        public void toTerminalDTO(Terminal terminal) {
            setCid(terminal.getCid());
            setMacid(terminal.getMacid());
            setName(terminal.getName());
            setUserid(terminal.getUserid());
            setProtocol(terminal.getProtocol());
            setVid(terminal.getVid());
            setPid(terminal.getPid());
            setVersion(terminal.getVersion());
            setCustcode(terminal.getCustcode());
            setSvraddr(terminal.getSvraddr());
            setSvrport(terminal.getSvrport());
            setEraseaddr(terminal.getEraseaddr());
            setStatus(terminal.getStatus());
            setSensortype(terminal.getSensortype());
            setPirdelay(terminal.getPirdelay());
        }

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

        public long getVersion() {
            return Version;
        }

        public void setVersion(long version) {
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

        public int getEraseaddr() {
            return Eraseaddr;
        }

        public void setEraseaddr(int eraseaddr) {
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
