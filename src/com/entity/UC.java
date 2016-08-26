/**
 * @description 
 * @date 2016-8-26
 * @author hxg	
 */
package com.entity;

public class UC {
	private int u_id;
	private String u_name;
	private String u_email;

	public String getUemail() {
		return u_email;
	}

	public void setUemail(String uemail) {
		this.u_email = uemail;
	}

	public int getU_id() {
		return u_id;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	@Override
	public String toString() {
		return "UC [u_id=" + u_id + ", u_name=" + u_name + ", uemail=" + u_email
				+ "]";
	}

	
}
