package com.zhou.mypowerbee.model.datas;

import com.zhou.mypowerbee.model.entity.Group;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhou on 17-3-8.
 */

public class GroupDatas {
    private Map<String, Group> groupMap = new HashMap<>();

    public void setAllGroup(List<Group> groups) {
        if (groups != null) {
            for (Group group : groups) {
                groupMap.put(group.getUuid(), group);
            }
        }
    }
}
