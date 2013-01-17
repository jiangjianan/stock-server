package com.jiangjianan.stock.server.web.blog;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.object.TokenDO;
import com.jiangjianan.stock.server.service.BlogService;
import com.jiangjianan.stock.server.util.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String code;
	private String message;

	@Autowired
	private BlogService blogService;

	public String execute() throws Exception {
		if (code != null) {
			Result<TokenDO> result = blogService.relogin(code);
			TokenDO tokenDO = result.getDefaultModel();
			message = JsonUtil.objectToString(tokenDO);
		} else {
			message = "";
		}
		return SUCCESS;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BlogService getBlogService() {
		return blogService;
	}

	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
