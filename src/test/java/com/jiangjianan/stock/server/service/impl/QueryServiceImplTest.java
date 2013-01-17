//package com.jiangjianan.stock.server.service.impl;
//
//import static org.junit.Assert.assertNotNull;
//
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.jiangjianan.stock.server.common.service.Result;
//import com.jiangjianan.stock.server.object.BlogDO;
//import com.jiangjianan.stock.server.service.QueryService;
//
//public class QueryServiceImplTest {
//	private QueryService queryService;
//
//	@SuppressWarnings("resource")
//	@Before
//	public void setUp() {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext(
//				"applicationContext.xml");
//		queryService = (QueryService) ctx.getBean("queryService");
//	}
//
//	@Test
//	public void getBlogList() {
//		Result<List<BlogDO>> result = queryService.getBlogList();
//		assertNotNull(result.getDefaultModel());
//	}
//
//	@Test
//	public void getBlogById() {
//		String blogUid = "1147298365";
//		Result<BlogDO> result = queryService.getBlogById(blogUid);
//		assertNotNull(result.getDefaultModel());
//	}
//}
