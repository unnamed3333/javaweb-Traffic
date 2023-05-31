package member.dao;

import java.util.List;

import core.bean.Member;
import core.bean.Vehide;

public interface MemberDao {
	int insert(Member member);
	
	Member selectForLogin(String phoneNo, String password);

	int update(Member member);
	
	Member selectByKey(Integer id);

	List<Vehide> vehide(Integer target, Integer id);
	
//	List<Vehide> relatedPersonVehide(Integer id);
	
//	int deleteByKey(Integer id);
	
	

}