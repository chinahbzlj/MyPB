package com.zhou.mypowerbee.model.dto;

import com.zhou.mypowerbee.model.entity.Group;
import com.zhou.mypowerbee.util.JSONHelper;

import java.util.List;
import java.util.Objects;

/**
 * Created by zhou on 17-3-5.
 */

public class GroupInfoDTO extends BaseDTO {
    public List<GroupDTO> Data;

    public class GroupDTO {
        private String Uuid;
        private String Aid;
        private List<String> Devids;
        private String Uid;
        private String Title;
        private Object Expand;

        public GroupDTO() {
        }

        public Group toGroup() {
            Group group = new Group();
            group.setUuid(getUuid());
            group.setAid(getAid());
            group.setDevids(JSONHelper.toJson(getDevids()));
            group.setUid(getUid());
            group.setTitle(getTitle());
            group.setExpand(JSONHelper.toJson(getExpand()));
            return group;
        }

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

        //
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

        public void setExpand(Object expand) {
            Expand = expand;
        }


    }
}
