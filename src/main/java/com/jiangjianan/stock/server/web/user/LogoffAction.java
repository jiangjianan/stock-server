package com.jiangjianan.stock.server.web.user;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.jiangjianan.stock.server.common.action.SessionAction;

@ParentPackage("struts-default")
@Results({ @Result(location = "../index", type = "redirectAction") })
public class LogoffAction extends SessionAction {
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception {
		session.remove(SESSION_USER_KEY);
		return SUCCESS;
	}

}
