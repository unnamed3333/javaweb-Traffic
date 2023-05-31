package member.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;

import core.bean.Member;
import core.bean.Vehide;
import member.dao.MemberDao;

public class MemberDaoImpl implements MemberDao{

	
	@Override
	public int insert(Member member) {
		
		final String sql = "insert into Member(Name, Password, Ncikname, Identitynumber, Birthday, Phoneno, Address, Email, Avatar ) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)
		) {
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getNickname());
			pstmt.setString(4, member.getIdentityNumber());
			pstmt.setString(5, member.getBirthday());
			pstmt.setString(6, member.getPhoneNo());
			pstmt.setString(7, member.getAddress());
			pstmt.setString(8, member.getEmail());
			pstmt.setString(8, member.getAvatar());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	@Override
	public Member selectForLogin(String phoneNo, String password) {
		final String sql = "select * from Member where Phoneno = ? and Password = ?";
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)
		) {
			pstmt.setString(1, phoneNo);
			pstmt.setString(2, password);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					Member member = new Member();
					member.setId(rs.getInt("ID"));
					return member;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int update(Member member) {
		System.out.println(member.getPassword());
		String sql = "update Member set ";
		//修改名子
		String name = member.getName();
		if(name != null && !name.isEmpty()) {sql += "Name = ?";}
		//修改密碼
		String password = member.getPassword();
		if(password != null && !password.isEmpty()) {sql += "Password = ?";}
		//修改暱稱
		String nickname = member.getNickname();
		if(nickname != null && !nickname.isEmpty()) {sql += "Nickname = ?";}
		//修改身分證號碼
		String identityNo = member.getIdentityNumber();
		if(identityNo != null && !identityNo.isEmpty()) {sql += "IdentityNumber = ?";}
		//修改生日
		String birthday = member.getBirthday();
		if(birthday != null && !birthday.isEmpty()) {sql += "Birthday = ?";}
		//修改手機號碼
		String phoneNo = member.getPhoneNo();
		if(phoneNo != null && !phoneNo.isEmpty()) {sql += "Phoneno = ?";}
		//修改地址
		String address = member.getAddress();
		if(address != null && !address.isEmpty()) {sql += "Address = ?";}
		//修改email
		String email = member.getEmail();
		if(email != null && !email.isEmpty()) {sql += "Email = ?";}
		//修改頭像
		String avatar = member.getAvatar();
		if(avatar != null && !avatar.isEmpty()) {sql += "Avatar = ?";}
		
		sql += " where ID = ?";
		
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)
		) {
			if(name != null && !name.isEmpty()) {pstmt.setString(1, name);}
			if(password != null && !password.isEmpty()) {pstmt.setString(1, password);}
			if(nickname != null && !nickname.isEmpty()) {pstmt.setString(1, nickname);}
			if(identityNo != null && !identityNo.isEmpty()) {pstmt.setString(1, identityNo);}
			if(birthday != null && !birthday.isEmpty()) {pstmt.setString(1, birthday);}
			if(phoneNo != null && !phoneNo.isEmpty()) {pstmt.setString(1, phoneNo);}
			if(address != null && !address.isEmpty()) {pstmt.setString(1, address);}
			if(email != null && !email.isEmpty()) {pstmt.setString(1, email);}
			if(avatar != null && !avatar.isEmpty()) {pstmt.setString(1, avatar);}
			pstmt.setInt(2, member.getId());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public Member selectByKey(Integer id) {
		final String SQL = "select * from Member where ID = ?";
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL)	
		) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					Member member = new Member();
					member.setId(rs.getInt("ID"));
					member.setAvatar(rs.getString("Avatar"));;
					member.setName(rs.getString("Name"));
					member.setPassword(rs.getString("Password"));
					member.setNickname(rs.getString("Nickname"));
					member.setIdentityNumber(rs.getString("IdentityNumber"));
					member.setBirthday(rs.getString("Birthday"));
					member.setPhoneNo(rs.getString("PhoneNo"));
					member.setEmail(rs.getString("Email"));
					member.setAddress(rs.getString("Address"));
					member.setChatPermissions(rs.getBoolean("ChatPermissions"));
					member.setForumPermissions(rs.getBoolean("ForumPermissions"));

					return member;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Vehide> vehide(Integer target, Integer id) {
		String sql = "select * from Vehicle where ";
		if (target == 1) {
			sql += "MemID = ?";
		} else {
			sql += "RelatedPersonID = ?";
		}
		List<Vehide> resultList = new ArrayList<>();
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);	
		) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					Vehide vehide = new Vehide();
					vehide.setVehideType(rs.getString("VehicleType"));
					vehide.setVehideNumber(rs.getString("VehicleNo"));
					resultList.add(vehide);
				}
				return resultList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	


}
	
