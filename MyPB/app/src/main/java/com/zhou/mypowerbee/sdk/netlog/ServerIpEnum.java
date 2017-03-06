package com.zhou.mypowerbee.sdk.netlog;

public enum ServerIpEnum {
	ZHANG_JIANG("122.114.57.65",9000,"张江"),//张江
	DEBI_YUAN_QU("122.114.57.65",7000,"德比园区"),//德比园区
	NAN_XIANG_ZHI_DI("122.114.57.65",6000,"南翔智地"),//南翔智地
	MIAO_XING("alproject.powerbee.cn",8000,"庙行"),//庙行
	LV_MENG("122.114.57.65",9500,"绿盟"),//绿盟
	PU_TUO("122.114.57.65",1500,"普陀"),//普陀
	QI_BAO_ZHONG_XUE("122.114.57.65",1500,"七宝中学"),//七宝中学
	SENSOR_TEST("122.114.57.65",8000,"122服务器8000"),//传感器测试
	CQ_TEST("115.29.29.20",8000,"115服务器8000"),//重庆测试
	SHANGHAI_TEST("project.powerbee.cn",4000,"122服务器4000"),//上海测试
	UPDATE("managerserver.powerbee.cn",5000,"超级管理服务器"),//更新地址
	COMMON_SERVER("project.powerbee.cn",6500,"通用服务区"),//默认
	YI_DING("weiyun.powerbee.cn",3000,"一丁"),//一丁服务器
	LOCAL("10.1.1.118", 6000, "本地"),//
	POWERBEE("zg118.com",8000,"蜂电科技");//
	private String ip;
	private String serverName;

	private int port;
	ServerIpEnum(String ip, int port, String serverName) {
		this.ip = ip;
		this.port = port;
		this.serverName = serverName;
	}

	public String getIp() {
		return ip;
	}

	public int getPort() {
		return port;
	}
	public String getServerName() {
		return serverName;
	}


}
