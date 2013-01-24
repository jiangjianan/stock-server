package com.jiangjianan.stock.server.util;

public class ValidationUtil {
	public boolean isNotNull(String value) {
		if (value != null && !value.equals("")) {
			return true;
		} else {
			return false;
		}
	}

}
