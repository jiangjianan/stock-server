package com.jiangjianan.stock.server.manager.impl;

import java.util.ArrayList;
import java.util.List;

import com.jiangjianan.stock.server.common.manager.BaseManager;
import com.jiangjianan.stock.server.manager.MessageManager;

public class MessageManagerImpl extends BaseManager implements MessageManager {

	private List<String> messages;

	public MessageManagerImpl() {
		messages = new ArrayList<String>();
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public void clearMessages() {
		messages = new ArrayList<String>();
	}

	public void addMessage(String message) {
		if (messages.size() > 1000) {
			clearMessages();
		}
		messages.add(message);
	}
}
