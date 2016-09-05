/**
 * @description 
 * @date 2016-9-5
 * @author hxg	
 */
package com.control;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.EmailService;

@Controller
@RequestMapping("/api")
public class EmailTaskController {
	private static final Logger logger = LoggerFactory
			.getLogger(EmailTaskController.class);

	@Resource
	EmailService emailService;

	@RequestMapping("/sendemail")
	public void sendEmailTask(final String toEmail) throws Exception {
		logger.info("-------------执行发送邮件START---------------");
		// 写入excel
		// insuranceService.excelManage();
		// 发邮件
		emailService.emailManage(toEmail);
		logger.info("-------------执行发送邮件END---------------");
	}

}
