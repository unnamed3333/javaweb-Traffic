package member.dao;

import java.util.List;

import member.bean.Member;

public interface MemberDao {
	int insert(Member member);
	
	Member selectForLogin(String username, String password);

	int update(Member member);
	
	List<Member> selectAll();
	
	Member selectByKey(Integer id);
	
//	int deleteByKey(Integer id);
	
	

}