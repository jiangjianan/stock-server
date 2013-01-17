package com.jiangjianan.stock.server.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtil {
	public static String get(String url, String charset) throws IOException {
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		String result = null;
		try {
			HttpResponse httpResponse = httpClient.execute(httpGet);
			HttpEntity httpEntity = httpResponse.getEntity();
			result = EntityUtils.toString(httpEntity, charset);
		} finally {
			httpGet.releaseConnection();
		}
		return result;
	}

	public static String post(String url, Map<String, String> parameters,
			String charset) throws IOException {
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		if (parameters != null) {
			for (Map.Entry<String, String> entry : parameters.entrySet()) {
				params.add(new BasicNameValuePair(entry.getKey(), entry
						.getValue()));
			}
		}
		String reuslt = null;
		try {
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(params,
					charset);
			httpPost.setEntity(uefEntity);
			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			reuslt = EntityUtils.toString(httpEntity, charset);
		} finally {
			httpPost.releaseConnection();
		}
		return reuslt;
	}
}
