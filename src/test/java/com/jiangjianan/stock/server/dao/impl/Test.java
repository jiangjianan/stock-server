package com.jiangjianan.stock.server.dao.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Test {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		String text = "�ַ�����֧�г��Ƿ�����63��&nbsp;����ܺ��˳�500��";
		System.out.println(URLDecoder.decode(text, "UTF-8"));

	}

}
