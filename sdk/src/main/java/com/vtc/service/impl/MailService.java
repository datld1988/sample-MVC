package com.vtc.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.vtc.config.FreemarkerConfig;
import com.vtc.config.ISysConfig;
import com.vtc.config.SysConfig;
import com.vtc.model.MailBean;
import com.vtc.util.MathUtil;

//@Configuration
//@PropertySource("classpath:config/server.properties")
//@Service
public class MailService {
	private static final Logger log = Logger.getLogger(MailService.class);
	private static final String ADMIN_ADDRESS_DEFAULT = "bachnx@vtc.vn";
	
	@Autowired
	private ISysConfig sysConfig;

	private JavaMailSenderImpl mailSender;
	private FreemarkerConfig appConfig;

//	private static MailService instance;
	private AppMailPreparator preparator;

	private String content;
	
	public MailService() {
		
	}

	public MailService(ISysConfig sysConfig) {
		this.sysConfig = sysConfig;
		appConfig = new FreemarkerConfig("freemarker");
		setMailSender(new JavaMailSenderImpl());
		mailSender.setDefaultEncoding("UTF-8");
		mailSender.setHost(sysConfig.getMailHost());
		mailSender.setPassword(sysConfig.getMailPassword());
		mailSender.setUsername(sysConfig.getMailAccount());
		Integer port = MathUtil.parseInt(sysConfig.getMailPort());
		mailSender.setPort(port);
		
		Properties mailProps = new Properties();
		mailProps.put("mail.smtp.auth", "true");
		mailProps.put("mail.smtp.localhost", "vtc.vn");
		mailProps.put("mail.smtp.starttls.enable", "true");
		mailSender.setJavaMailProperties(mailProps);
	}
	
//	public static MailService getInstance() {
//		if (instance == null) {
//			instance = new MailService();
//		}
//		return instance;
//	}

	public void sendMailTemplate(final MailBean obj, final String toAddresses, final String subject, final String[] fileNames, String template) throws Exception {
		String mailAccount = sysConfig.getMailAccount();
		log.info("[START]SEND MAIL TO " + toAddresses + " FROM " + mailAccount);

		// data
		Map<Object, Object> data = new HashMap<Object, Object>();

		data.put("name", obj.getUserName());
		data.put("message", obj.getMessage());

		// from
		String adminSender = mailAccount;
		if (adminSender == null || adminSender.length() == 0) {
			adminSender = ADMIN_ADDRESS_DEFAULT;
		}

		sendMail(data, adminSender, mailAccount, toAddresses.split(";"), subject, "classpath:template/" + template, fileNames);
		log.info("[END]SEND MAIL TO " + toAddresses + " FROM " + mailAccount);
	}

//	public void sendAppMail(final MailBean obj, final String toAddresses, final String subject, final String[] fileNames) throws Exception {
//		String mailAccount = sysConfig.getMailAccount();
//		log.info("[START]SEND MAIL TO " + toAddresses + " FROM " + mailAccount);
//
//		// data
//		Map<Object, Object> data = new HashMap<Object, Object>();
//
//		data.put("name", obj.getUserName());
//		data.put("message", obj.getMessage());
//		
//		// from
//		String adminSender = mailAccount;
//		if (adminSender == null || adminSender.length() == 0) {
//			adminSender = ADMIN_ADDRESS_DEFAULT;
//		}
//		
//		sendMail(data, adminSender, mailAccount, toAddresses.split(";"), subject, "classpath:template/heart.ftl", fileNames);
//		log.info("[END]SEND MAIL TO " + toAddresses + " FROM " + mailAccount);
//	}

	/**
	 * Generic send mail method
	 * 
	 * @param data
	 *            : data to merge with template
	 * @param from
	 *            : from email address, typically admin email
	 * @param replyTo
	 *            : email address to be replied to, typically current online
	 *            user's email
	 * @param to
	 *            : email address which mail will be sent to
	 * @param subject
	 *            : email subject
	 * @param templateName
	 *            : template name to be merged with provided data
	 * @throws Exception
	 */
	private void sendMail(final Map<Object, Object> data, final String from, final String replyTo, final String[] to, final String subject, final String templateName, String[] pathFiles) throws Exception {
		long t1 = System.currentTimeMillis();
		if (preparator == null) {
			preparator = new AppMailPreparator(data, from, replyTo, to, subject, templateName, pathFiles, appConfig.getCfg());
		} else {
			preparator.setData(data);
			preparator.setTo(to);
			preparator.setPathAttachment(pathFiles);
		}
		long t2 = System.currentTimeMillis();
		System.out.println("TIME PREPARE = " + (t2 - t1));
		mailSender.send(preparator);
		long t3 = System.currentTimeMillis();
		System.out.println("TIME SEND = " + (t3 - t2));
	}

	public JavaMailSender getMailSender() {
		return mailSender;
	}


	public FreemarkerConfig getAppConfig() {
		return appConfig;
	}

	public void setAppConfig(FreemarkerConfig appConfig) {
		this.appConfig = appConfig;
	}

	public void setMailSender(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}

//	public String getContent() {
//		return content;
//	}

	public void setContent(String content) {
		this.content = content;
	}


	public ISysConfig getSysConfig() {
		return sysConfig;
	}

	public void setSysConfig(ISysConfig sysConfig) {
		this.sysConfig = sysConfig;
	}
}
