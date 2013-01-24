package com.jiangjianan.stock.server.common.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class SessionAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;

	protected Map<String, Object> session;
	public static final String SESSION_USER_KEY = "user";

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
