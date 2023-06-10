package chat.service.impl;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import chat.dao.ChatDao;
import chat.dao.impl.ChatDaoImpl;
import chat.service.ChatService;
import core.bean.Chat;
import core.bean.ChatRoom;
import ticket.dao.impl.TicketDaoImpl;

@WebServlet("/ChatServiceImpl")
public class ChatServiceImpl implements ChatService {
	private ChatDao dao;

	public ChatServiceImpl() {
		dao = new ChatDaoImpl();
	}

	@Override
	public int updateStatus(Integer ChatRoomId, Integer memId) {
		return dao.updateChatRoom(ChatRoomId, memId);
	}

	@Override
	public List<ChatRoom> selectChatRoom(Integer memId) {
		return dao.selectChatRoomByMemId(memId);
	}

	@Override
	public List<Chat> selectChat(Integer ChatRoomId, Integer memId) {
//		dao.updateChatRoom(ChatRoomId, memId);
		return dao.selectChatByChatRoom(ChatRoomId);
	}
	

	@Override
	public boolean insertChat(Chat chat) {
		return dao.insertChat(chat) > 0;
	}
}
