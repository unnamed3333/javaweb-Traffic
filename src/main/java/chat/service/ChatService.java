package chat.service;

import java.util.List;

import core.bean.Chat;
import core.bean.ChatRoom;

public interface ChatService {

	int updateStatus(Integer ChatRoomId, Integer memId);
	
	List<ChatRoom> selectChatRoom(Integer memId);
	
	List<Chat> selectChat(Integer ChatRoomId, Integer memId);
	
//	List<Chat> selectChat(Integer ChatRoomId);
	
	boolean insertChat(Chat chat);
}
