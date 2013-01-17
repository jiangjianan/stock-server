package com.jiangjianan.stock.server.common.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ResultSupport<T> implements Result<T> {
	private static final long serialVersionUID = 1L;

	private boolean isSuccess;

	private Map<String, Object> models;

	private T defaultModel;

	public ResultSupport() {
		this.isSuccess = false;
		models = new HashMap<String, Object>();
	}

	public ResultSupport(boolean isSuccess) {
		this.isSuccess = isSuccess;
		models = new HashMap<String, Object>();
	}

	@Override
	public boolean isSuccess() {
		return this.isSuccess;
	}

	@Override
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	@Override
	public T getDefaultModel() {
		return this.defaultModel;
	}

	@Override
	public void setDefaultModel(T defaultModel) {
		this.defaultModel = defaultModel;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <K> K getModel(String key) {
		return (K) models.get(key);
	}

	@Override
	public <K> void setModel(String key, K value) {
		models.put(key, value);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <K> Map<String, K> getModels() {
		return (Map<String, K>) models;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
