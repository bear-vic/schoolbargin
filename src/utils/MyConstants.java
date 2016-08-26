/**
 * @description 定义了全局的常量，大部分前端的参数都在这里，重要！ 这些常量被放到setAttribute中 
 * @date 2016-8-18
 * @author hxg	
 */
package utils;

public class MyConstants {
	// 分页的常量( 当要存放的对象要分页时用到)
	public static final String REQUEST_PB = "pb";
	// tomcat的 本地路径（作用是配置图片的存放位置）
	public static final String TOMCAT_PATH = "E:/VIS/apache-tomcat-7.0.67/";
	// 图片的服务器地址
	public static final String PIC_PATH = "pic/";
	// request 放一个对象时的参数
	public static final String REQUEST_OBJ = "req_obj";
	// request 放一个普通消息时
	public static final String REQUEST_MSG = "req_msg";
	// session 存放了用户
	public static final String SESSION_MSG = "user";
	//session 存放留言
	public static final String SESSION_COMMENTS = "session_comments";
	// session中存放对象
	public static final String SESSION_OBJ = "session_obj";
	// 已放弃
	public static final String REQUEST_PBU = "pbu";
	
}
