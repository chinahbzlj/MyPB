package com.example.zhou.mypowerbee.sdk.define;


import com.example.zhou.mypowerbee.sdk.netlog.NetConfigFile;

public class ApiMacro {
	public static short FRAME_HEAD = 0X0002;
//	private final static String NetConfigFile.SERVER_HTTP_IP = NetConfigFile.SERVER_HTTP_IP;
//	private final static int NetConfigFile.SERVER_HTTP_PORT = NetConfigFile.NetConfigFile.SERVER_HTTP_PORT;
	public final String URL_SERVICE = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT;
	public final String URL_SERVICE_UPDATE = "http://" + NetConfigFile.SERVER_HTTP_IP_UPDATE + ":" + NetConfigFile.SERVER_HTTP_PORT_UPDATE;
	/**用户接口设计*/
	public final String URL_USER = URL_SERVICE+"/user";
	/**配置服务器接口设计*/
	public final String URL_CONFIG = URL_SERVICE_UPDATE+"/config";
	/**集中器接口设计*/
	public final String URL_CONCENTRATOR = URL_SERVICE+"/terminal";
	/**节点接口设计*/
	public final String URL_NODE = URL_SERVICE+"/node";
	/**设备接口设计*/
	public final String URL_DEVICE  = URL_SERVICE+"/device";
	/**场景接口设计*/
	public final String URL_SCENE = URL_SERVICE+"/scene";
	/**定时器接口设计*/
	public final String URL_TIMER = URL_SERVICE+"/timer";
	/**传感器组接口设计*/
	public final String URL_SENSORGROUP= URL_SERVICE+"/sensorgroup";
	/**设备分组接口设计*/
	public final String URL_GROUP= URL_SERVICE+"/device/group";
	/**
	 * 消息接口设计
	 */
	public final String URL_MSG = URL_SERVICE + "/msg";
//	// 用户注册
//	public final  String URL_USER_REGISTER = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/register";
//	// 用户登录
//	public final  String URL_USER_LOGIN = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/userlogin";
//	// 用户头像下载
//	public final  String URL_USER_UPLOADAVATAR = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/uploadavatar";
//	// 用户头像上传
//	public final  String URL_USER_DOWNAVATAR = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/downavatar";
//	// 用户信息修改
//	public final  String URL_USER_MODIFY = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/perfectuser";
//	// 修改密码
//	public final  String URL_USER_MODIFY_PWD = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/modifpass";
//	// 忘记密码
//	public final  String URL_USER_FORGET_PWD = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/forgetpass";
//
//	// 查询集中器列表
//	public final  String URL_CONCENTRATOR_QUERY = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/listconcentrator";
//	// 修改集中器信息
//	public final  String URL_CONCENTRATOR_MODIFY = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/perfectconcentrator";
//	// 绑定集中器
//	public final  String URL_CONCENTRATOR_BIND = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/activating";
//	// 解绑集中器
//	public final  String URL_CONCENTRATOR_UNBIND = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/deactivate";
//
//	// 查询集中器里面的节点
//	public final  String URL_NODE_QUERY_FROM_CONCENTRATOR = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/listnode";
//	// 完善节点
//	public final  String URL_NODE_MODIFY = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/perfectnode";
//
//	// 添加插排入库
//	public final  String URL_ADD_PANEL_TO_LIBRARY = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/tools/initdevices";
//	public final  String URL_DEL_PANEL_FROM_LIBRARY = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/tools/deldevices";
//	public final  String URL_UPGRADE_HARDWARE = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/tools/oatupdate";
//	// 服务器发现陌生的集中器id. 自动给它入库。
////	public final  String URL_AUTO_ADD_LIBRARY = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/tools/autoregister";
//
//	// 查询设备列表
//	public final  String URL_DEVICES_QUERY = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/listdevice";
//	// 修改设备信息
//	public final  String URL_DEVICE_MODIFY = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/perfectdevice";
//	//上传设备图标
//	public final  String URL_DEVICE_DOWNLOAD_IC = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/downdevice";
//	//下载设备图标
//	public final  String URL_DEVICE_UPLOAD_IC = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/uploaddevice";
//	// 查询场景
//	public final  String URL_SCENE_QUERY = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/listscene";
//	// 添加场景
//	public final  String URL_ADD_SCENE = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/addscene";
//	// 修改场景
//	public final  String URL_SCENE_MODIFY = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/perfectscene";
//	// 添加设备到场景
//	public final  String URL_ADD_DEVICE_TO_SCENE = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/adddevicetoscene";
//	// 将设备从场景中移除
//	public final  String URL_REMOVE_DEVICE_FROM_SCENE = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/deldeviceforscene";
//	// 删除场景
//	public final  String URL_DELETE_SCENE = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/delscene";
//	// 添加定时器
//	public final  String URL_ADD_TIMER = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/addtimer";
//	// 删除定时器
//	public final  String URL_DELETE_TIMER = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/deltimer";
//	// 修改定时器
//	public final  String URL_MODIFY_TIMER = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/perfecttimer";
//	// 启用定时器
//	public final  String URL_ENABLE_TIMER = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/enabledtimer";
//	// 禁用定时器
//	public final  String URL_DISABLED_TIMER = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/disabledtimer";
//	// 查询我的定时器
//	public final  String URL_CHECK_TIMER = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/listtimer";
//	// 启用flash call
//	public final  String URL_ENABLE_FLASH = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/enabledflashcall";
//	// 禁用flash call
//	public final  String URL_DISABLE_FLASH = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/disabledflashcall";
//	// 启用flash call item
//	public final  String URL_ENABLE_FLASH_ITEM = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/enabledcallitem";
//	// 禁用flash call item
//	public final  String URL_DISABLE_FLASH_ITEM = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/disabledcallitem";
//	// 添加flash call item
//	public final String URL_ADD_FLASH_CALL_ITEM = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/addcallitem";
//	// 删除flash call item
//	public final  String URL_DEL_FLASH_CALL_ITEM = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/delcallitem";
//	// 查询我的flash call item
//	public final  String URL_CHECK_FLASH_CALL_ITEM = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/listflashcall";
//	// 根据设备名称查询设备id
//	public final String URL_GET_PID_FORM_TITLE = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/getpid";
//	//修改传感器组信息
//	public final String URL_MODIFY_SENSOR_GROUP= "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/sensorgroup";
//	//获取可选服务器
//	public final String URL_APP_SERVER= "http://" + NetConfigFile.SERVER_HTTP_IP_UPDATE + ":" + NetConfigFile.SERVER_HTTP_PORT_UPDATE + "/appserver";
//	//获取版本信息
//	public final String URL_CHECK_UPDATE= "http://" + NetConfigFile.SERVER_HTTP_IP_UPDATE + ":" + NetConfigFile.SERVER_HTTP_PORT_UPDATE + "/checkupdate";


}
