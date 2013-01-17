package com.jiangjianan.stock.server.object;

import com.jiangjianan.stock.server.common.object.BaseDO;

public class SinaBaseDO extends BaseDO {
	private static final long serialVersionUID = 1L;
	private boolean isSuccess;
	private String errorCode;
	private String errorText;

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorText() {
		return errorText;
	}

	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}

}
