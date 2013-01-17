package com.jiangjianan.stock.server.object;

import java.util.Date;

import com.jiangjianan.stock.server.common.object.BaseDO;

public class StockInfoDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String code;
	private String name;
	private Date gmtCreate;
	private Date gmtModified;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

}
