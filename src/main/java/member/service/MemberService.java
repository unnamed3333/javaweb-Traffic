package member.service;

import java.util.List;

import core.bean.Member;
import core.bean.RelatedPerson;
import core.bean.Vehide;

public interface MemberService {

	boolean register(Member member);

	Member login(Member member);
			
	boolean editMember(Member member);

	Member findMemberById(Integer id);

	List<Vehide> vihide(Integer target, Integer id);

	List<RelatedPerson> findRelatedPerson(Integer id);

	boolean forgetPassword(String phoneNo);

	boolean resetPassword(Member member);

	boolean relatedPersonRegister(RelatedPerson relatedPerson, Integer id);

	boolean editRelatedPerson(RelatedPerson relatedPerson);
	
//	List<Vehide> relatedPersonVihide(Integer id);


	
}