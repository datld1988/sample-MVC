package com.vtc.service.impl;


import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;
import org.springframework.mail.javamail.MimeMessagePreparator;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * Generic mail preparator
 * 
 * @author Nguyen.Xuan.Bach
 * 
 */
public class AppMailPreparator implements MimeMessagePreparator {
	private static final Logger log = Logger.getLogger(MailService.class);;
	private Map<Object, Object> data;
	private String from;
	private String replyTo;
	private String[] to;
	private String subject;
	private String templateName;
	private Configuration cfg;
	private String[] pathAttachment;

	private Template temp;
	public AppMailPreparator(final Map<Object, Object> data, final String from, final String replyTo, final String[] to, final String subject, final String templateName, final String[] pathAttachment, Configuration cfg) {
		this.setData(data);
		this.from = from;
		this.replyTo = replyTo;
		this.to = to;
		this.subject = subject;
		this.templateName = templateName;
		this.pathAttachment = pathAttachment;
		this.cfg = cfg;
	}

	@Override
	public void prepare(MimeMessage mimeMessage) throws Exception {
		Writer out = null;
		try {
			long t1 = System.currentTimeMillis();
			mimeMessage.setFrom(new InternetAddress(from));

			InternetAddress[] recipients = new InternetAddress[getTo().length];
			for (int i = 0; i < getTo().length; i++) {
				String receipient = getTo()[i];
				recipients[i] = new InternetAddress(receipient);
			}
			mimeMessage.setRecipients(Message.RecipientType.TO, recipients);

			InternetAddress[] repTo = { new InternetAddress(replyTo) };
			mimeMessage.setReplyTo(repTo);
			mimeMessage.setSubject(subject, "UTF-8");
			Map<Object, Object> root = new HashMap<Object, Object>(getData());

//			Template temp = cfg.getTemplate(templateName);
			if (temp == null) {
				cfg.setClassForTemplateLoading(this.getClass(), "/template/");
				temp = cfg.getTemplate("heart.ftl", "UTF-8");
			}

			/* Merge data-model with template */
			out = new StringWriter();
			temp.process(root, out);

			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(out.toString(), "text/plain; charset=UTF-8");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			if (pathAttachment != null && pathAttachment.length != 0) {
				for (String filename : pathAttachment) {
					if (filename != null) {
						BodyPart attachmentBodyPart = new MimeBodyPart();
						DataSource source = new FileDataSource(filename);
						attachmentBodyPart.setDataHandler(new DataHandler(source));
						String name = source.getName();
						attachmentBodyPart.setFileName(name);
						
						multipart.addBodyPart(attachmentBodyPart);
						
					}
				}
			}

            mimeMessage.setContent(multipart);

			out.flush();
			long t2 = System.currentTimeMillis();
			System.out.println("AppMailPreparator.prepare() T2 - T1 = " + (t2 - t1));
		} catch (Exception s) {
			s.printStackTrace();
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		} 
	}

	public String[] getPathAttachment() {
		return pathAttachment;
	}

	public void setPathAttachment(String[] pathAttachment) {
		this.pathAttachment = pathAttachment;
	}

	public Map<Object, Object> getData() {
		return data;
	}

	public void setData(Map<Object, Object> data) {
		this.data = data;
	}

	public String[] getTo() {
		return to;
	}

	public void setTo(String[] to) {
		this.to = to;
	}

	public Template getTemp() {
		return temp;
	}

	public void setTemp(Template temp) {
		this.temp = temp;
	}
}