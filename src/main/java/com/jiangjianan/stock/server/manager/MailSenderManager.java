package com.jiangjianan.stock.server.manager;

import com.jiangjianan.stock.server.common.manager.ManagerException;
import com.jiangjianan.stock.server.object.MailConfigurationDO;

public interface MailSenderManager {
	public void sendMail(MailConfigurationDO mailConfigurationDO)
			throws ManagerException;
}
