package member.dao;

import java.util.List;

import core.bean.Member;
import core.bean.RelatedPerson;
import core.bean.Vehide;

public interface MemberDao {
	int insert(Member member);
	
	Member selectForLogin(String phoneNo, String password);

	int update(Member member);
	
	Member selectByKey(Integer id);

	List<Vehide> vehide(Integer target, Integer id);

	List<RelatedPerson> findRelatedPerson(Integer id);

	boolean forgetPassword(String phoneNo);

	int resetPassword(Member member);
	

	
	

}