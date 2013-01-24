package com.jiangjianan.stock.server.object;

import java.util.Date;

import com.jiangjianan.stock.server.common.object.BaseDO;

public class UserDO extends BaseDO {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String password;
	private String email;
	private Date login;
	private int type;
	private int status;
	private Date gmtCreate;
	private Date gmtModifide;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModifide() {
		return gmtModifide;
	}

	public void setGmtModifide(Date gmtModifide) {
		this.gmtModifide = gmtModifide;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getLogin() {
		return login;
	}

	public void setLogin(Date login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
