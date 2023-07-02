package chat.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import chat.dao.ChatDao;
import core.bean.Chat;
import core.bean.ChatRoom;

public class ChatDaoImpl implements ChatDao {

	// 聊天室的recycleview資料
	@Override
	public List<ChatRoom> selectChatRoomByMemId(Integer memId) {
		final String sql = "select r.*, \r\n"
				+ "    case when r.MemID1 != ? then m1.nickname else m2.Nickname end as Nickname,\r\n"
				+ "    case when r.MemID1 != ? then m1.avatar else m2.Avatar end as Avatar,\r\n"
				+ "    sum(case when c.ReadStatus = 0 then 1 else 0 end) as unread\r\n"
				+ "from chatroom r\r\n"
				+ "left join member m1 on m1.id = r.MemID1\r\n"
				+ "left join member m2 on m2.id = r.MemID2\r\n"
				+ "left join chat c on c.chatroomID = r.ID and c.SenderID != ?\r\n"
				+ "where (r.MemID1 = ? or r.MemID2 = ?)\r\n"
				+ "group by r.ID";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, memId);
			pstmt.setInt(2, memId);
			pstmt.setInt(3, memId);
			pstmt.setInt(4, memId);
			pstmt.setInt(5, memId);
			try (ResultSet rs = pstmt.executeQuery()) {
				List<ChatRoom> list = new ArrayList<>();
				while (rs.next()) {
					ChatRoom chatroom = new ChatRoom();
					chatroom.setID(rs.getInt("id"));
					chatroom.setMemID1(rs.getInt("memID1"));
					chatroom.setMemID2(rs.getInt("memID2"));
					chatroom.setNickname(rs.getString("nickname"));
					chatroom.setAvatar(rs.getBytes("avatar"));
					chatroom.setUnread(rs.getInt("unread"));
					list.add(chatroom);
				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 選擇進入個別聊天室後看到的recycleview資料
	@Override
	public List<Chat> selectChatByChatRoom(Integer ChatRoomId) {
		final String sql = "select c.*, r.memid1, r.memid2, \r\n"
				+ "    case when r.memid1 = c.senderid then m1.nickname else m2.nickname end as nickname,\r\n"
				+ "    case when r.memid1 = c.senderid then m1.avatar else m2.avatar end as avatar\r\n"
				+ "from chat c\r\n" + "left join chatroom r on r.id = c.chatroomid\r\n"
				+ "left join member m1 on m1.id = r.memid1\r\n" + "left join member m2 on m2.id = r.memid2\r\n"
				+ "where r.id = ?\r\n" + "order by SendTime;";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, ChatRoomId);
			try (ResultSet rs = pstmt.executeQuery()) {
				List<Chat> list = new ArrayList<>();
				while (rs.next()) {
					Chat chat = new Chat();
					chat.setID(rs.getInt("id"));
					chat.setSenderID(rs.getInt("senderid"));
				    chat.setChatroomID(rs.getInt("chatroomid"));
				    chat.setContent(rs.getString("content"));
				    chat.setAppendix(rs.getBytes("appendix"));
				    chat.setSendTime(rs.getTimestamp("sendtime"));
				    chat.setReadStatus(rs.getBoolean("readstatus"));
				    chat.setMemId1(rs.getInt("memid1"));
				    chat.setMemId2(rs.getInt("memid2"));
				    chat.setNickname(rs.getString("nickname"));
				    chat.setAvatar(rs.getBytes("avatar"));
				    list.add(chat);
				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 新增聊天室資料
	@Override
	public int insertChatRoom(Integer memId1, Integer memId2) {
		final String sql = "insert into chatroom(MemID1, MemID2) values(?, ?)";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, memId1);
			pstmt.setInt(2, memId2);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	// 已讀狀態改變
	@Override
	public int updateChatRoom(Integer ChatRoomId, Integer memId) {
		final String sql = "update chat set ReadStatus = 1 where (chatroomID = ? and SenderID != ?);";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, ChatRoomId);
			pstmt.setInt(2, memId);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	// 新增聊天內容
	@Override
	public int insertChat(Chat chat) {
		final String sql = "insert into chat(SenderID, chatroomID, Content, Appendix) values(?, ?, ?, ?)";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, chat.getSenderID());
			pstmt.setInt(2, chat.getChatroomID());
			pstmt.setString(3, chat.getContent());
			pstmt.setBytes(4, chat.getAppendix());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
} // 刪除聊天內容