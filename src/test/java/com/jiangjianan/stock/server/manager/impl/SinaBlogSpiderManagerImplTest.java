package com.jiangjianan.stock.server.manager.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.jiangjianan.stock.server.common.manager.ManagerException;
import com.jiangjianan.stock.server.manager.SinaBlogSpiderManager;
import com.jiangjianan.stock.server.manager.impl.SinaBlogSpiderManagerImpl;
import com.jiangjianan.stock.server.object.ArticleDO;

public class SinaBlogSpiderManagerImplTest {
	@Test
	public void getArticle() throws ManagerException {
		SinaBlogSpiderManager manager = new SinaBlogSpiderManagerImpl();
		ArticleDO articleDO = manager.getArticle("2182731187",
				"8219d5b301014mpk");
		assertNotNull(articleDO.getArticleBody());
	}

	@Test
	public void getArticlePages() throws ManagerException {
		SinaBlogSpiderManager manager = new SinaBlogSpiderManagerImpl();
		int page = manager.getArticlePages("2182731187");
		assertTrue(page > 0);
	}

	@Test
	public void get() throws ManagerException {
		SinaBlogSpiderManager manager = new SinaBlogSpiderManagerImpl();
		List<String> list = manager.getArticleList("2182731187", 1);
		assertEquals(50, list.size());
	}
}
