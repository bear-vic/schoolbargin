/**
 * @description 全局消息类
 * @date 2016-8-20
 * @author hxg	
 */
package com.entity.ex;

import java.io.Serializable;

public class SMessage  implements Serializable {
	private static final long serialVersionUID = 1L;
	private String msg; //消息

	public SMessage() {
		// TODO Auto-generated constructor stub
	}

	public SMessage(String msg) {
		// TODO Auto-generated constructor stub
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
