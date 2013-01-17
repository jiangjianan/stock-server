package com.jiangjianan.stock.server.util;

import java.io.IOException;
import java.io.StringWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiangjianan.stock.server.object.ArticleDO;
import com.jiangjianan.stock.server.object.BlogDO;
import com.jiangjianan.stock.server.object.TokenDO;

public class JsonUtil {
	public static ArticleDO getArticle(String json) throws IOException,
			ParseException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(json);

		ArticleDO articleDO = new ArticleDO();
		JsonNode codeNode = rootNode.get("code");
		if (codeNode != null) {
			JsonNode dataNode = rootNode.get("data");
			JsonNode blogNameNode = dataNode.get("blog_name");
			JsonNode articleIdNode = dataNode.get("article_id");
			JsonNode articleTitleNode = dataNode.get("article_title");
			JsonNode articleBodyNode = dataNode.get("article_body");
			JsonNode classNameNode = dataNode.get("class_name");
			JsonNode articlePubdateNode = dataNode.get("article_pubdate");
			JsonNode articleUppdateNode = dataNode.get("article_uppdate");
			JsonNode blogUidNode = dataNode.get("blog_uid");
			JsonNode userNickNode = dataNode.get("user_nick");
			JsonNode articleTagNode = dataNode.get("article_tag");

			articleDO.setSuccess(true);
			articleDO.setBlogName(blogNameNode.asText());
			articleDO.setArticleId(articleIdNode.asText());
			articleDO.setArticleTitle(articleTitleNode.asText());
			articleDO.setArticleBody(articleBodyNode.asText());
			articleDO.setClassName(classNameNode.asText());
			articleDO.setArticlePubdate(DateUtil
					.stringToDate(articlePubdateNode.asText()));
			articleDO.setArticleUppdate(DateUtil
					.stringToDate(articleUppdateNode.asText()));
			articleDO.setBlogUid(blogUidNode.asText());
			articleDO.setUserNick(userNickNode.asText());
			articleDO.setArticleTag(articleTagNode.asText());
		} else {
			JsonNode errorCodeNode = rootNode.get("error_code");
			JsonNode errorTextNode = rootNode.get("error_text");
			articleDO.setSuccess(false);
			articleDO.setErrorCode(errorCodeNode.asText());
			articleDO.setErrorText(errorTextNode.asText());
		}
		return articleDO;
	}

	public static BlogDO getBlog(String json) throws IOException,
			ParseException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(json);

		BlogDO blogDO = new BlogDO();
		JsonNode codeNode = rootNode.get("code");
		if (codeNode != null) {
			JsonNode dataNode = rootNode.get("data");
			JsonNode blogUidNode = dataNode.get("blog_uid");
			JsonNode uhostNode = dataNode.get("uhost");
			JsonNode blogUrlNode = dataNode.get("blog_url");
			JsonNode blogNameNode = dataNode.get("blog_name");
			JsonNode userNickNode = dataNode.get("user_nick");
			JsonNode userPicNode = dataNode.get("user_pic");
			JsonNode articleCountNode = dataNode.get("article_count");

			blogDO.setSuccess(true);
			blogDO.setBlogUid(blogUidNode.asText());
			blogDO.setUhost(uhostNode.asText());
			blogDO.setBlogUrl(blogUrlNode.asText());
			blogDO.setBlogName(blogNameNode.asText());
			blogDO.setUserNick(userNickNode.asText());
			blogDO.setUserPic(userPicNode.asText());
			blogDO.setArticleCount(articleCountNode.asInt());
		} else {
			JsonNode errorCodeNode = rootNode.get("error_code");
			JsonNode errorTextNode = rootNode.get("error_text");
			blogDO.setSuccess(false);
			blogDO.setErrorCode(errorCodeNode.asText());
			blogDO.setErrorText(errorTextNode.asText());
		}
		return blogDO;
	}

	public static List<String> getArticleList(String json) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(json);

		List<String> list = new ArrayList<String>();
		JsonNode codeNode = rootNode.get("code");
		if (codeNode != null) {
			JsonNode dataNode = rootNode.get("data");
			JsonNode articleListNode = dataNode.get("article_list");
			Iterator<JsonNode> iterator = articleListNode.iterator();
			while (iterator.hasNext()) {
				JsonNode articleNode = iterator.next();
				list.add(articleNode.get("article_id").asText());
			}
		}
		return list;
	}

	public static TokenDO getToken(String json) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(json);

		TokenDO tokenDO = new TokenDO();
		JsonNode codeNode = rootNode.get("code");
		if (codeNode == null) {
			JsonNode accessTokenNode = rootNode.get("access_token");
			JsonNode expiresInNode = rootNode.get("expires_in");
			JsonNode timeLeftNode = rootNode.get("time_left");
			JsonNode uidNode = rootNode.get("uid");
			tokenDO.setSuccess(true);
			tokenDO.setAccessToken(accessTokenNode.asText());
			tokenDO.setExpiresIn(expiresInNode.asLong());
			tokenDO.setTimeLeft(timeLeftNode.asLong());
			tokenDO.setUid(uidNode.asText());
		} else {
			JsonNode msgNode = rootNode.get("msg");
			tokenDO.setSuccess(false);
			tokenDO.setErrorCode(codeNode.asText());
			tokenDO.setErrorText(msgNode.asText());
		}
		return tokenDO;
	}

	public static String objectToString(Object object) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		StringWriter writer = new StringWriter();
		mapper.writeValue(writer, object);
		return writer.toString();
	}

}
