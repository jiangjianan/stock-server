package com.jiangjianan.stock.server.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jiangjianan.stock.server.dao.ArticleDAO;
import com.jiangjianan.stock.server.object.ArticleDO;

public class ArticleDAOImplTest {
	private ArticleDAO articleDAO;
	private ArticleDO articleDO;
	private String articleId;

	@SuppressWarnings("resource")
	@Before
	public void setup() {
		articleDAO = (ArticleDAO) new ClassPathXmlApplicationContext(
				"applicationContext.xml").getBean("articleDAO");
		articleId = "-1";
		articleDO = new ArticleDO();
		articleDO.setBlogUid(articleId);
		articleDO.setArticleBody("articleBody");
	}

	@Test
	public void insertArticle() {
		assertNull(articleDAO.getArticleById(articleId));
		articleDAO.insertArticle(articleDO);
		assertNotNull(articleDAO.getArticleById(articleId));
	}

	@Test
	public void updateArticle() {
		articleDAO.insertArticle(articleDO);
		assertEquals("articleBody", articleDAO.getArticleById(articleId)
				.getArticleBody());
		articleDO.setArticleBody("test");
		articleDAO.updateArticle(articleDO);
		assertEquals("test", articleDAO.getArticleById(articleId)
				.getArticleBody());
	}

	@Test
	public void deleteArticle() {
		assertNull(articleDAO.getArticleById(articleId));
		articleDAO.getArticleById(articleId);
		articleDAO.insertArticle(articleDO);
		assertNotNull(articleDAO.getArticleById(articleId));
		articleDAO.deleteArticleById(articleId);
		assertNull(articleDAO.getArticleById(articleId));
	}

}
