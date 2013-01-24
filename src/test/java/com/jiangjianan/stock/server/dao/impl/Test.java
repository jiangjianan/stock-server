package com.jiangjianan.stock.server.dao.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Test {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		String text = "浦发银行支行长非法吸储63亿&nbsp;间接受害人超500名";
		System.out.println(URLDecoder.decode(text, "UTF-8"));

	}

}
