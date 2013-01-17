package com.jiangjianan.stock.server.object;

import java.util.Date;

import com.jiangjianan.stock.server.common.object.BaseDO;

public class UserDO extends BaseDO {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String password;
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

}
