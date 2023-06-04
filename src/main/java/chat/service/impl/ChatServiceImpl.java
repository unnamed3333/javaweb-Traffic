package chat.service.impl;

import javax.servlet.annotation.WebServlet;

import chat.dao.ChatDao;
import chat.service.ChatService;


@WebServlet("/ChatServiceImpl")
public class ChatServiceImpl implements ChatService {
	private ChatDao dao;
	
	
}
