package com.jiangjianan.stock.server.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@SuppressWarnings("static-access")
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	public synchronized static Object getBean(String id) {
		return applicationContext.getBean(id);

	}

}
