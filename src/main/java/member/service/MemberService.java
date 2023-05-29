package member.service;

import java.util.List;

import member.bean.Member;

public interface MemberService {

	boolean register(Member member);

	Member login(Member member);
			
	boolean editMember(Member member);

	Member findMemberById(Integer id);
	
	List<Member> findAllMember();

	
}