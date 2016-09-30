package com.vtc.config;



import org.apache.log4j.Logger;

import com.vtc.service.impl.MailService;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;

/**
 * @description
 * @version TDSBO1.0
 * @CrBy Nguyen Xuan Bach
 * @CrDate Feb 24, 2012
 * @Copyright Posismo Hanoi Limited. All rights reserved.
 */
public class FreemarkerConfig {
	private static final Logger log = Logger.getLogger(MailService.class);
	public static final int KEYWORD_LIMIT = 10;
	private String freeMarkerTemplatePath;
	private static Configuration cfg;
	public FreemarkerConfig(String path) {
		freeMarkerTemplatePath = path;
	}
	
	public final Configuration getCfg() {
		if (cfg == null) {
			initFreeMarkerConfig();
		}
		return cfg;
	}

	public String getFreeMarkerTemplatePath() {
		return freeMarkerTemplatePath;
	}

	public void setFreeMarkerTemplatePath(String freeMarkerTemplatePath) {
		this.freeMarkerTemplatePath = freeMarkerTemplatePath;
	}

	public static Integer getShowMorePageSize() {
		return 10;
	}

	public static Integer getInitPageSize() {
		return 15;
	}

	public void initFreeMarkerConfig() {
		System.out.println("FreemarkerConfig.initFreeMarkerConfig()");
		cfg = new Configuration();
		try {
//			ClassPathResource classPathResource = new ClassPathResource(getFreeMarkerTemplatePath());
//			cfg.setDirectoryForTemplateLoading(new File("meta_conf/freemarker"));a
			cfg.setClassForTemplateLoading(this.getClass(), "/template/");
		} catch (Exception e) {
			log.error("Unable to find freemarker template path: "
					+ freeMarkerTemplatePath, e);
		}
		cfg.setObjectWrapper(new DefaultObjectWrapper());
	}
}
