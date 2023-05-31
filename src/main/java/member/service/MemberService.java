package member.service;

import java.util.List;

import core.bean.Member;
import core.bean.Vehide;

public interface MemberService {

	boolean register(Member member);

	Member login(Member member);
			
	boolean editMember(Member member);

	Member findMemberById(Integer id);

	List<Vehide> vihide(Integer target, Integer id);
	
//	List<Vehide> relatedPersonVihide(Integer id);


	
}