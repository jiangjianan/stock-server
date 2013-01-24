package com.jiangjianan.stock.server.web;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.jiangjianan.stock.server.common.action.SessionAction;

@ParentPackage("struts-default")
public class IndexAction extends SessionAction {
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception {
		return SUCCESS;
	}

}
