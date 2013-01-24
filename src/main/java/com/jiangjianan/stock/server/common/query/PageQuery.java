package com.jiangjianan.stock.server.common.query;

import java.util.List;

public abstract class PageQuery<T> {
	private int page = 1;
	private int count = 0;
	private int start = 0;
	private int pageSize = 50;
	private List<T> list;
	private int pageCount;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getStart() {
		if (page <= 0) {
			start = 0;
		} else {
			start = (page - 1) * pageSize;
		}
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getPageCount() {
		pageCount = (int) Math.ceil(1.0 * count / pageSize);
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

}
