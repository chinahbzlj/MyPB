package com.example.zhou.mypowerbee.util;

import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author 沈韶敏
 * @description 格式校验工具
 * @date 2014-7-3
 */
public class ValidateUtil {
	//邮箱校验正则表达式
	private final static Pattern emailer = Pattern
			.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
	//ip校验正则
	private final static String iper = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."  
            +"(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."  
            +"(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."  
            +"(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";

	/**
	 * 判断是不是一个合法的电子邮件地址
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {
		if (email == null || email.trim().length() == 0)
			return false;
		return emailer.matcher(email).matches();
	}
	
	/**
	 * 判断给定字符串是否空白串。 空白串是指由空格、制表符、回车符、换行符组成的字符串 若输入字符串为null或空字符串，返回true
	 * 
	 * @param input
	 * @return boolean
	 */
	public static boolean isEmpty(String input) {
		if (input == null || "".equals(input))
			return true;

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
				return false;
			}
		}
		return true;
	}
	/**
	 * edittext设置error信息
	 * 
	 * @param resources
	 * @param errorColor
	 * @param errorMsg
	 * @return
	 */
	public static SpannableStringBuilder setErrorInfo(Resources resources,
			int errorColor, String errorMsg) {
		int ecolor = Color.WHITE;
		String estring = errorMsg;
		ForegroundColorSpan fgcspan = new ForegroundColorSpan(ecolor);
		SpannableStringBuilder ssbuilder = new SpannableStringBuilder(estring);
		ssbuilder.setSpan(fgcspan, 0, estring.length(), 0);

		return ssbuilder;
	}

	/**
	 * 校验金额
	 * 
	 * @param value
	 * @return
	 */
	public static boolean validateMoney(String value) {
		try {
			Double.parseDouble(value);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 校验身份证
	 * 
	 * @param value
	 * @return
	 */
	public static boolean validateSfz(String value) {
		// 暂不验证，由页面上进行验证。页面会和纯数字键盘共用一个。
		// if (value.length() > 18) {
		// return false;
		// }
		return !(value.contains("X") && value.indexOf("X") != value.length() - 1);
	}

	/**
	 * 校验密码(6位）
	 * 
	 * @param value
	 * @return
	 */
	public static boolean validatePassword(String value) {
		return value.length() <= 6;
	}

	/**
	 * 校验ip地址
	 * @return
	 */
	public static boolean validateIP(String ip){
		if (ip == null || ip.length() < 7) {
			return false;
		}
		
		Pattern pattern = Pattern.compile(iper);  
	    Matcher matcher = pattern.matcher(ip);
	    return matcher.matches();
	}
	/**
	 * 判断字符串是否为数字
	 * @param str
	 * @return
	 */
	public static boolean isNum(String str){
		if (str == null || "".equals(str)) {
			return false;
		}
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}
}
