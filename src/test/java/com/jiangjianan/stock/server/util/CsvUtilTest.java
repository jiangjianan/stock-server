package com.jiangjianan.stock.server.util;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class CsvUtilTest {
	@Test
	public void getStockPrice() throws IOException {
		String csv = FileUtil
				.readTextFile(
						"src/test/resources/com/jiangjianan/stock/server/util/600000.csv",
						";");
		assertEquals(3149, CsvUtil.getStockPrice(csv).size());
	}
}
