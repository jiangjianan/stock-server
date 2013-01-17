package com.jiangjianan.stock.server.util;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import com.jiangjianan.stock.server.util.HttpUtil;

public class HttpUtilTest {
	@Test
	public void get() throws IOException {
		String result = HttpUtil.get("http://www.baidu.com", "utf-8");
		assertNotNull(result);
	}

	@Test
	public void post() throws IOException {
		String result = HttpUtil.post("http://www.baidu.com", null, "utf-8");
		assertNotNull(result);
	}
}
