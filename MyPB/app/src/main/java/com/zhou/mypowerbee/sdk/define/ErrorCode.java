package com.zhou.mypowerbee.sdk.define;

public class ErrorCode {
	public static final int SUCCESS = 0;//成功
	public static final int CRC_ERR = 0X2A;//crc错误
	public static final int COTROL_FIALE = 0X29;//控制失败
	public static final int QUERY_FIALE_O = 0X80;		//pannel不在线
	public static final int QUERY_FIALE_N = 0X29;		//pannel不在线
	public static final int QUERY_FIALE_OO = 0XFF;		//pannel不在线
	public static final byte LOGIN_FAIL = 1;//登陆失败
	public static final byte ILLEGAL_NODE_ID = 1;//非法节点id
	public static final byte NODE_HAS_REGISTERED= 2;//节点已注册
	public static final int CONCENTRATOR_IS_ADDED= 1006;//集中器已经入库
	public static final int NODE_IS_ADDED= 1006;//节点已经入库
	public static final int USER_INSUFFICIENT_PERMISSIONS= 1000;//用户权限不足，请使用管理员账户
	public static final int USER_NOT_EXIST= 1002;//用户不存在
	public static final int WRONG_PASSWORD= 1001;//密码错误
	public static final int NODE_NOT_EXIT= 1008;//修改节点信息失败(节点不在该集中器下)
	public static final int PASS_ERR= 1013;//密码错误
	public static final int SCENE_NOT_EXIST= -1;//场景不存在
	public static final int TIMER_NOT_EXIST= -1;//该定时器不存在
	public static final int SCENE_NOT_DELETE= 1007;//系统场景不能删除
	public static final int ACCOUNT_HAS_EXISTS= 2003;//帐号已存在
	public static final int VERIFICATION_FAILURE= 1018;//token验证失败

}
