package com.zhou.mypowerbee.model.entity;

import java.security.acl.Group;
import java.util.List;

/**
 * Created by zhou on 17-3-5.
 */

public class GroupInfoDTO extends BaseDTO {
    public List<Group> Data;

    public class GroupDTO {
        private String Uuid;
        private String Aid;
        private List<String> Devids;
        private String Uid;
        private String Title;
        private Object Expand;

        public String getUuid() {
            return Uuid;
        }

        public void setUuid(String uuid) {
            Uuid = uuid;
        }

        public String getAid() {
            return Aid;
        }

        public void setAid(String aid) {
            Aid = aid;
        }

        public List<String> getDevids() {
            return Devids;
        }

        public void setDevids(List<String> devids) {
            Devids = devids;
        }

        public String getUid() {
            return Uid;
        }

        public void setUid(String uid) {
            Uid = uid;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public Object getExpand() {
            return Expand;
        }

        public void setExpand(Object Expand) {
            this.Expand = Expand;
        }
    }
}
