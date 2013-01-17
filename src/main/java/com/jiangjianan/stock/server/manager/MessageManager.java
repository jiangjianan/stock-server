package com.jiangjianan.stock.server.manager;

import java.util.List;

public interface MessageManager {

	public List<String> getMessages();

	public void clearMessages();

	public void addMessage(String message);
}
