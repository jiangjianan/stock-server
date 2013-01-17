package com.jiangjianan.stock.server.object;

import java.util.Date;

import com.jiangjianan.stock.server.common.object.BaseDO;

public class StockAnnouncementDO extends BaseDO {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String code;
	private String title;
	private String url;
	private Long date;
	private Date gmtCreate;
	private Date gmtModified;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
	
	public String getDateString() {
		long year = date / 10000;
		long month = date % 10000 / 100;
		long day = date % 100;
		return year + "-" + month + "-" + day;
	}

}
