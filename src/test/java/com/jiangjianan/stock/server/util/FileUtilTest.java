package com.jiangjianan.stock.server.util;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.jiangjianan.stock.server.util.FileUtil;

public class FileUtilTest {
	@Test
	public void getFileContent() throws IOException {
		String file = "src/test/resources/com/jiangjianan/stock/server/util/test.txt";
		String result = FileUtil.readTextFile(file);
		assertEquals("test", result);
	}
}
