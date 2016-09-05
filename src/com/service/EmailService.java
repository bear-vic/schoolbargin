/**
 * @description 
 * @date 2016-9-5
 * @author hxg	
 */
package com.service;

import com.entity.ex.MailModel;

public interface EmailService {

	/**
	 * @description
	 * @steps
	 * @return void
	 * @param
	 * @throws Exception
	 */
	void sendEmail(MailModel mail) throws Exception;

	/**
	 * @description
	 * @steps
	 * @return void
	 * @param
	 * @throws Exception
	 */
	void emailManage(String toEmail) throws Exception;

}
