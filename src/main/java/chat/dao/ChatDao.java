package chat.dao;

import java.util.List;

import core.bean.Chat;
import core.bean.ChatRoom;

public interface ChatDao {
	
	List<ChatRoom> selectChatRoomByMemId(Integer memId);
	
	List<Chat> selectChatByChatRoom(Integer ChatRoomId);

	int insertChatRoom(Integer memId1, Integer memId2);
	
	int updateChatRoom(Integer ChatRoomId, Integer memId);
	
	int insertChat(Chat chat);
	
}