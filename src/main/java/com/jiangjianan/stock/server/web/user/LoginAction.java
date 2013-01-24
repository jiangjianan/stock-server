package com.jiangjianan.stock.server.web.user;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiangjianan.stock.server.common.action.SessionAction;
import com.jiangjianan.stock.server.object.UserDO;
import com.jiangjianan.stock.server.service.UserService;

@ParentPackage("struts-default")
@Results({ @Result(location = "../index", type = "redirectAction") })
public class LoginAction extends SessionAction {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserService userService;

	private String name;
	private String password;

	public String execute() throws Exception {
		com.jiangjianan.stock.server.common.service.Result<UserDO> result = userService
				.getUserByName(name);
		if (result.isSuccess()) {
			UserDO userDO = result.getDefaultModel();
			if (password.equals(userDO.getPassword())) {
				session.put(SESSION_USER_KEY, userDO);
				return SUCCESS;
			}
		}
		return INPUT;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
