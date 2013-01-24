package com.jiangjianan.stock.server.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jiangjianan.stock.server.dao.BlogDAO;
import com.jiangjianan.stock.server.object.BlogDO;
import com.jiangjianan.stock.server.query.BlogPageQuery;

public class BlogDAOImplTest {
	private BlogDAO blogDAO;
	private BlogDO blogDO;
	private String blogUid;

	@SuppressWarnings("resource")
	@Before
	public void setup() {
		blogDAO = (BlogDAO) new ClassPathXmlApplicationContext(
				"applicationContext.xml").getBean("blogDAO");
		blogUid = "-1";
		blogDO = new BlogDO();
		blogDO.setBlogUid(blogUid);
		blogDO.setBlogName("blogName");
	}

//	@Test
//	public void insertBlog() {
//		assertNull(blogDAO.getBlogById(blogUid));
//		blogDAO.insertBlog(blogDO);
//		assertNotNull(blogDAO.getBlogById(blogUid));
//	}
//
//	@Test
//	public void updateBlog() {
//		blogDAO.insertBlog(blogDO);
//		assertEquals("blogName", blogDAO.getBlogById(blogUid).getBlogName());
//		blogDO.setBlogName("test");
//		blogDAO.updateBlog(blogDO);
//		assertEquals("test", blogDAO.getBlogById(blogUid).getBlogName());
//	}
//
//	@Test
//	public void deleteBlog() {
//		assertNull(blogDAO.getBlogById(blogUid));
//		blogDAO.getBlogById(blogUid);
//		blogDAO.insertBlog(blogDO);
//		assertNotNull(blogDAO.getBlogById(blogUid));
//		blogDAO.deleteBlog(blogUid);
//		assertNull(blogDAO.getBlogById(blogUid));
//	}
//
//	@Test
//	public void getBlogList() {
//		blogDAO.insertBlog(blogDO);
//		assertTrue(blogDAO.getBlogList().size() > 0);
//	}
	
	@Test
	public void getBlogListByPageQuery() {
		BlogPageQuery query = new BlogPageQuery();
		query.setPageSize(1);
		blogDAO.getBlogListByPageQuery(query);
	}
	
}
