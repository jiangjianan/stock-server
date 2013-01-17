package com.jiangjianan.stock.server.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
	public static String readTextFile(String file) throws IOException {
		return readTextFile(file, "");
	}

	public static String readTextFile(String file, String separator)
			throws IOException {
		BufferedReader reader = null;
		StringBuilder builder = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			builder = new StringBuilder();
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				builder.append(tempString);
				if (separator != null && !separator.equals("")) {
					builder.append(separator);
				}
			}
		} finally {
			reader.close();
		}
		return builder.toString();
	}

	public static void writeTextFile(File file, String content, boolean isAppend)
			throws IOException {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file, isAppend));
			writer.append(content);
		} finally {
			writer.close();

		}
	}
}
