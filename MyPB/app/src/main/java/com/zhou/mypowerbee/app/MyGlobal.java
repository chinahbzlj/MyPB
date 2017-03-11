package com.zhou.mypowerbee.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.zhou.mypowerbee.gen.DaoMaster;
import com.zhou.mypowerbee.gen.DaoSession;
import com.zhou.mypowerbee.model.datas.GroupDatas;
import com.zhou.mypowerbee.model.datas.TerminalDatas;
import com.zhou.mypowerbee.model.dto.DeviceInfoDTO;
import com.zhou.mypowerbee.model.dto.GroupInfoDTO;
import com.zhou.mypowerbee.model.dto.NodeInfoDTO;
import com.zhou.mypowerbee.model.dto.TerminalInfoDTO;
import com.zhou.mypowerbee.model.entity.Device;
import com.zhou.mypowerbee.model.entity.Node;
import com.zhou.mypowerbee.model.entity.Terminal;
import com.zhou.mypowerbee.model.entity.Group;
import com.zhou.mypowerbee.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhou on 17-3-3.
 */

public class MyGlobal {
    private static MyGlobal myGlobal;
    private Context mContext;
    private DaoMaster.DevOpenHelper devOpenHelper;
    private DaoMaster daoMaster;
    private SQLiteDatabase sqLiteDatabase;
    private DaoSession daoSession;
    private TerminalDatas terminalDatas;
    private GroupDatas groupDatas;

    private MyGlobal() {
    }

    private static synchronized void initSycnGlobal() {
        if (myGlobal == null)
            myGlobal = new MyGlobal();
    }

    public static MyGlobal getMyGlobal() {
        if (myGlobal == null)
            initSycnGlobal();
        return myGlobal;
    }


    public void init(Context context) {
        this.mContext = context;
        initData();
    }

    private void initData() {
        devOpenHelper = new DaoMaster.DevOpenHelper(this.mContext, "MyDB.db", null);
        sqLiteDatabase = devOpenHelper.getWritableDatabase();
        daoMaster = new DaoMaster(sqLiteDatabase);
        daoSession = daoMaster.newSession();
    }

    public TerminalDatas getTerminalDatas() {
        if (terminalDatas == null) {
            terminalDatas = new TerminalDatas();
        }
        return terminalDatas;
    }

    public GroupDatas getGroupDatas() {
        if (groupDatas == null) {
            groupDatas = new GroupDatas();
        }
        return groupDatas;
    }

    public void saveTerminal(final List<TerminalInfoDTO.TerminalDTO> terminalDTOs) {
        ToastUtil.getInstance().post(new Runnable() {
            @Override
            public void run() {
                if (terminalDTOs != null && terminalDTOs.size() != 0) {
                    daoSession.getTerminalDao().deleteAll();
                    List<Terminal> terminals = new ArrayList<>();
                    for (TerminalInfoDTO.TerminalDTO terminalDTO : terminalDTOs) {
                        terminals.add(terminalDTO.toTerminal());
                    }
                    daoSession.getTerminalDao().insertInTx(terminals);
                }
            }
        });

    }

    public void saveGroup(final List<GroupInfoDTO.GroupDTO> groupDTOs) {
        ToastUtil.getInstance().post(new Runnable() {
            @Override
            public void run() {
                if (groupDTOs != null && groupDTOs.size() != 0) {
                    daoSession.getGroupDao().deleteAll();
                    List<Group> groups = new ArrayList<Group>();
                    for (GroupInfoDTO.GroupDTO groupDTO : groupDTOs) {
                        groups.add(groupDTO.toGroup());
                    }
                    daoSession.getGroupDao().insertInTx(groups);
                }
            }
        });
    }

    public void saveNodes(final List<NodeInfoDTO.NodeDTO> nodeDTOs) {
        ToastUtil.getInstance().post(new Runnable() {
            @Override
            public void run() {
                if (nodeDTOs != null && nodeDTOs.size() != 0) {
                    if (daoSession.getNodeDao().getDatabase() != null)
                        daoSession.getNodeDao().deleteAll();
                    List<Node> nodes = new ArrayList<Node>();
                    for (NodeInfoDTO.NodeDTO nodeDTO : nodeDTOs) {
                        nodes.add(nodeDTO.toNode());
                    }
                    daoSession.getNodeDao().insertInTx(nodes);
                }
            }
        });
    }

    public void saveDevices(final List<DeviceInfoDTO.DeviceDTO> deviceDTOs) {
        ToastUtil.getInstance().post(new Runnable() {
            @Override
            public void run() {
                if (deviceDTOs != null && deviceDTOs.size() != 0) {
                    daoSession.getDeviceDao().deleteAll();
                    List<Device> devices = new ArrayList<Device>();
                    for (DeviceInfoDTO.DeviceDTO deviceDTO : deviceDTOs) {
                        devices.add(deviceDTO.toDevice());
                    }
                    daoSession.getDeviceDao().insertInTx(devices);
                }
            }
        });
    }

    public void saveAllData() {
        List<Terminal> terminals = getTerminalDatas().queryAllTerminal();
        List<Node> nodes = getTerminalDatas().queryAllNode();
//        List<Device> devices = getTerminalDatas().qu
    }
}
