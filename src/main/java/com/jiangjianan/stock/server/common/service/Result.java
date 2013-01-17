package com.jiangjianan.stock.server.common.service;

import java.io.Serializable;
import java.util.Map;

public interface Result<T> extends Serializable {
	public boolean isSuccess();

	public void setSuccess(boolean isSuccess);

	public T getDefaultModel();

	public void setDefaultModel(T defaultModel);

	public <K> void setModel(String key, K Value);

	public <K> K getModel(String key);

	public <K> Map<String, K> getModels();
}
