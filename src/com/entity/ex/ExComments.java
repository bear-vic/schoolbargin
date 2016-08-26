/**
 * @description 
 * @date 2016-8-26
 * @author hxg	
 */
package com.entity.ex;

import com.entity.Comments;

public class ExComments extends Comments {
	private String exDate;
	private String exUname;

	public String getExUname() {
		return exUname;
	}

	public void setExUname(String exUname) {
		this.exUname = exUname;
	}

	public String getExDate() {
		return exDate;
	}

	public void setExDate(String exDate) {
		this.exDate = exDate;
	}

}
