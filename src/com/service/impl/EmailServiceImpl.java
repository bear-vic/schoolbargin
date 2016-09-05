/**
 * @description 
 * @date 2016-9-5
 * @author hxg	
 */
package com.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.entity.ex.MailModel;
import com.exception.ExceptionCommon;
import com.service.EmailService;

@SuppressWarnings("all")
@Service
public class EmailServiceImpl implements EmailService {
	private static Logger logger = LoggerFactory
			.getLogger(EmailServiceImpl.class);

	private String excelPath = "d://";

	@Resource
	private JavaMailSender javaMailSender;

	@Resource
	private SimpleMailMessage simpleMailMessage;

	@Override
	public void emailManage(String toEmail) throws Exception {
		final MailModel mail = new MailModel();
		// 主题
		mail.setToEmails(toEmail);
		// 附件
		// Map<String, String> attachments = new HashMap<String, String>();
		// attachments.put("清单.xlsx", excelPath + "清单.xlsx");
		// mail.setAttachments(attachments);
		// 内容
		StringBuilder builder = new StringBuilder();
		builder.append("<html><body>你好！<br />");
		builder.append("&nbsp&nbsp&nbsp&nbsp欢迎你注册成功。<br />");
		builder.append("&nbsp&nbsp&nbsp&nbsp<a href='http://169.254.222.122:8080/schoolbargin/pages/main.jsp'>前往主页</a><br />");
		builder.append("</body></html>");
		String content = builder.toString();
		mail.setContent(content);
		new Thread() {
			public void run() {
				try {
					sendEmail(mail);
				} catch (Exception e) {
					e.printStackTrace();
				}
			};
		}.start();

	}

	/**
	 * 发送邮件
	 * 
	 * @throws Exception
	 * 
	 * @throws Exception
	 */
	@Override
	public void sendEmail(MailModel mail) throws Exception {
		MimeMessage message = javaMailSender.createMimeMessage();

		MimeMessageHelper messageHelper;
		try {
			messageHelper = new MimeMessageHelper(message, "UTF-8");
			// 设置发件人邮箱
			if (mail.getEmailFrom() != null) {
				messageHelper.setFrom(mail.getEmailFrom());
			} else {
				messageHelper.setFrom(simpleMailMessage.getFrom());
			}

			// 设置收件人邮箱
			if (mail.getToEmails() != null) {
				String[] toEmailArray = mail.getToEmails().split(";");
				List<String> toEmailList = new ArrayList<String>();
				if (null == toEmailArray || toEmailArray.length <= 0) {
					throw new ExceptionCommon("收件人邮箱不得为空！");
				} else {
					for (String s : toEmailArray) {
						if (s != null && !s.equals("")) {
							toEmailList.add(s);
						}
					}
					if (null == toEmailList || toEmailList.size() <= 0) {
						throw new ExceptionCommon("收件人邮箱不得为空！");
					} else {
						toEmailArray = new String[toEmailList.size()];
						for (int i = 0; i < toEmailList.size(); i++) {
							toEmailArray[i] = toEmailList.get(i);
						}
					}
				}
				messageHelper.setTo(toEmailArray);
			} else {
				messageHelper.setTo(simpleMailMessage.getTo());
			}

			// 邮件主题
			if (mail.getSubject() != null) {
				messageHelper.setSubject(mail.getSubject());
			} else {
				messageHelper.setSubject(simpleMailMessage.getSubject());
			}

			// true 表示启动HTML格式的邮件
			messageHelper.setText(mail.getContent(), true);

			// // 添加图片
			// if (null != mail.getPictures()) {
			// for (Iterator<Map.Entry<String, String>> it = mail
			// .getPictures().entrySet().iterator(); it.hasNext();) {
			// Map.Entry<String, String> entry = it.next();
			// String cid = entry.getKey();
			// String filePath = entry.getValue();
			// if (null == cid || null == filePath) {
			// throw new RuntimeException("请确认每张图片的ID和图片地址是否齐全！");
			// }
			//
			// File file = new File(filePath);
			// if (!file.exists()) {
			// throw new RuntimeException("图片" + filePath + "不存在！");
			// }
			//
			// FileSystemResource img = new FileSystemResource(file);
			// messageHelper.addInline(cid, img);
			// }
			// }

			// // 添加附件
			// if (null != mail.getAttachments()) {
			// for (Iterator<Map.Entry<String, String>> it = mail
			// .getAttachments().entrySet().iterator(); it.hasNext();) {
			// Map.Entry<String, String> entry = it.next();
			// String cid = entry.getKey();
			// String filePath = entry.getValue();
			// if (null == cid || null == filePath) {
			// throw new RuntimeException("请确认每个附件的ID和地址是否齐全！");
			// }
			//
			// File file = new File(filePath);
			// if (!file.exists()) {
			// throw new RuntimeException("附件" + filePath + "不存在！");
			// }
			//
			// FileSystemResource fileResource = new FileSystemResource(
			// file);
			// messageHelper.addAttachment(cid, fileResource);
			// }
			// }
			// messageHelper.setSentDate(new Date());
			// 发送邮件
			javaMailSender.send(messageHelper.getMimeMessage());
			logger.info("------------发送邮件完成----------");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
