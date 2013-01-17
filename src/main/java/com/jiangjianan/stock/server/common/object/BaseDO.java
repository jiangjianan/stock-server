package com.jiangjianan.stock.server.common.object;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class BaseDO implements Serializable {
	private static final long serialVersionUID = 1L;

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
