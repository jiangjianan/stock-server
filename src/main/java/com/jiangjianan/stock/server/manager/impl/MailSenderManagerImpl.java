package com.jiangjianan.stock.server.manager.impl;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.jiangjianan.stock.server.common.manager.BaseManager;
import com.jiangjianan.stock.server.common.manager.ManagerException;
import com.jiangjianan.stock.server.manager.MailSenderManager;
import com.jiangjianan.stock.server.object.MailConfigurationDO;

public class MailSenderManagerImpl extends BaseManager implements
		MailSenderManager {

	private JavaMailSender javaMailSender;
	private VelocityEngine velocityEngine;

	@Override
	public void sendMail(MailConfigurationDO mailConfigurationDO)
			throws ManagerException {
		try {
			MimeMessage msg = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg, true, "UTF-8");
			helper.setFrom(mailConfigurationDO.getFrom());
			helper.setTo(mailConfigurationDO.getTo());
			helper.setSubject(mailConfigurationDO.getSubject());
			String text = VelocityEngineUtils.mergeTemplateIntoString(
					velocityEngine, mailConfigurationDO.getTemplateName(),
					"UTF-8", mailConfigurationDO.getModel());
			helper.setText(text);
			javaMailSender.send(msg);
		} catch (Exception e) {
			throw new ManagerException(e);
		}
	}

	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

}
