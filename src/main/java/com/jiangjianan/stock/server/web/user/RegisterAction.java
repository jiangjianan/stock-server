package com.jiangjianan.stock.server.web.user;

import java.util.Date;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiangjianan.stock.server.common.action.SessionAction;
import com.jiangjianan.stock.server.object.UserDO;
import com.jiangjianan.stock.server.service.UserService;

@ParentPackage("struts-default")
@Results({ @Result(location = "../index", type = "redirectAction") })
public class RegisterAction extends SessionAction {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserService userService;

	private String name;
	private String password;
	private String repassword;
	private String email;
	private String message;

	public String execute() throws Exception {
		UserDO userDO = new UserDO();
		userDO.setName(name);
		userDO.setEmail(email);
		userDO.setPassword(password);
		userDO.setType(1);
		userDO.setStatus(1);
		userDO.setLogin(new Date());
		com.jiangjianan.stock.server.common.service.Result<Boolean> result = userService
				.insertUser(userDO);
		if (result.isSuccess()) {
			com.jiangjianan.stock.server.common.service.Result<UserDO> userResult = userService
					.getUserByName(name);
			if (userResult.isSuccess()) {
				userDO = userResult.getDefaultModel();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

}
