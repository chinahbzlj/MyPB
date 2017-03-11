package com.zhou.mypowerbee.model.dto;

import com.zhou.mypowerbee.model.entity.Node;

import java.util.List;

/**
 * Created by zhou on 17-3-5.
 */

public class NodeInfoDTO extends BaseDTO {
    public List<NodeDTO> Data;

    public class NodeDTO {
        private String Uuid;
        private String Cid;
        private String Nid;
        private int Type;
        private String Name;
        private String Custcode;
        private long Status;
        private int Pid;
        private int Vid;
        private int Sensortype;
        private String Adduid;
        private String Lastuid;
        private String Addtime;
        private String Lasttime;
        public Node
        toNode() {
            Node node = new Node();
            node.setUuid(getUuid());
            node.setCid(getCid());
            node.setNid(getNid());
            node.setType(getType());
            node.setName(getName());
            node.setCustcode(getCustcode());
            node.setStatus(getStatus());
            node.setPid(getPid());
            node.setVid(getVid());
            node.setSensortype(getSensortype());
            node.setAdduid(getAdduid());
            node.setLastuid(getLastuid());
            node.setAddtime(getAddtime());
            node.setLasttime(getLasttime());
            return node;
        }

//        public NodeDTO(Node node) {
//            setUuid(node.getUuid());
//            setCid(node.getCid());
//            setNid(node.getNid());
//            setType(node.getType());
//            setName(node.getName());
//            setCustcode(node.getCustcode());
//            setStatus(node.getStatus());
//            setPid(node.getPid());
//            setVid(node.getVid());
//            setSensortype(node.getSensortype());
//            setAdduid(node.getAdduid());
//            setLastuid(node.getLastuid());
//            setAddtime(node.getAddtime());
//            setLasttime(node.getLasttime());
//        }

        public String getUuid() {
            return Uuid;
        }

        public void setUuid(String uuid) {
            Uuid = uuid;
        }

        public String getCid() {
            return Cid;
        }

        public void setCid(String cid) {
            Cid = cid;
        }

        public String getNid() {
            return Nid;
        }

        public void setNid(String nid) {
            Nid = nid;
        }

        public int getType() {
            return Type;
        }

        public void setType(int type) {
            Type = type;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getCustcode() {
            return Custcode;
        }

        public void setCustcode(String custcode) {
            Custcode = custcode;
        }

        public long getStatus() {
            return Status;
        }

        public void setStatus(long status) {
            Status = status;
        }

        public int getPid() {
            return Pid;
        }

        public void setPid(int pid) {
            Pid = pid;
        }

        public int getVid() {
            return Vid;
        }

        public void setVid(int vid) {
            Vid = vid;
        }

        public int getSensortype() {
            return Sensortype;
        }

        public void setSensortype(int sensortype) {
            Sensortype = sensortype;
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


    }
}
