//package com.jiangjianan.stock.server.service.impl;
//
//import org.apache.commons.lang3.builder.ToStringBuilder;
//import org.junit.Before;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.jiangjianan.stock.server.common.service.Result;
//import com.jiangjianan.stock.server.object.TokenDO;
//import com.jiangjianan.stock.server.service.AdminService;
//
//public class AdminServiceImplTest {
//	private AdminService adminService;
//
//	@SuppressWarnings("resource")
//	@Before
//	public void setUp() {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext(
//				"applicationContext.xml");
//		adminService = (AdminService) ctx.getBean("adminService");
//	}
//
//	@SuppressWarnings("unused")
//	@Ignore
//	@Test
//	public void relogin() {
//		String url = "https://auth.sina.com.cn/oauth2/authorize?client_id=1679260282&redirect_uri=http://www.jiangjianan.com";
//		Result<TokenDO> result = adminService
//				.relogin("76bf524f242b8d9737ab5f60b41c63fb");
//		if (result.isSuccess()) {
//			System.out.println(ToStringBuilder.reflectionToString(result
//					.getDefaultModel()));
//		}
//	}
//
//	@Test
//	public void updateBlogArticleById() {
//		adminService.setAccessToken("1e76476661MEeUq1PE0jg3CE5r847733");
//		String blogUid = "1531861501";
//		adminService.updateBlogArticleById(blogUid, false, false);
//	}
//
//	@Ignore
//	@Test
//	public void deleteBlogById() {
//		String blogUid = "1147298365";
//		adminService.deleteBlogById(blogUid);
//	}
//}
