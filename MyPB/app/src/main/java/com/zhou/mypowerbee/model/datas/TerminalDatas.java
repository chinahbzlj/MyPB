package com.zhou.mypowerbee.model.datas;

import com.zhou.mypowerbee.model.entity.Device;
import com.zhou.mypowerbee.model.entity.Node;
import com.zhou.mypowerbee.model.entity.Terminal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhou on 17-3-8.
 */

public class TerminalDatas {

    private Map<String, Terminal> terminalMap = new HashMap<>();

    private Map<String, Node> nodeMap = new HashMap<>();

    private Map<String, List<Device>> sensorDeviceMap = new HashMap<>();

    private Map<String, List<Device>> conrtolDeviceMap = new HashMap<>();

    public void setAllTerminals(List<Terminal> terminals) {
        if (terminals == null) return;
        this.terminalMap.clear();
        for (Terminal terminal : terminals) {
            this.terminalMap.put(terminal.getCid(), terminal);
        }
    }

    public void setAllNodes(List<Node> nodes) {
        if (nodes != null) {
            this.nodeMap.clear();
            for (Node node : nodes) {
                this.nodeMap.put(node.getNid(), node);
            }
        }

    }

    public void setAllSensorDevices(List<Device> devices) {
        if (devices != null) {
            this.sensorDeviceMap.clear();
            for (Device device : devices) {
                List<Device> tmpDevices = sensorDeviceMap.get(device.getPid());
                if (tmpDevices == null) {
                    sensorDeviceMap.put(device.getPid(), new ArrayList<Device>());
                    tmpDevices = sensorDeviceMap.get(device.getPid());
                }
                tmpDevices.add(device);
                this.sensorDeviceMap.put(device.getPid(), tmpDevices);
            }
        }
    }

    public void setAllControlDevices(List<Device> devices) {
        if (devices != null) {
            this.conrtolDeviceMap.clear();
            for (Device device : devices) {
                List<Device> tmpDevices = conrtolDeviceMap.get(device.getPid());
                if (tmpDevices == null) {
                    this.conrtolDeviceMap.put(device.getPid(), new ArrayList<Device>());
                    tmpDevices = conrtolDeviceMap.get(device.getPid());
                }
                tmpDevices.add(device);
                this.conrtolDeviceMap.put(device.getPid(), tmpDevices);
            }
        }
    }

    public List<Terminal> queryAllTerminal() {
        return new ArrayList<>(this.terminalMap.values());
    }

    public List<Node> queryAllNode() {
        return new ArrayList<>(this.nodeMap.values());
    }
}
