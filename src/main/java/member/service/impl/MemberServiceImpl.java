package member.service.impl;


import java.util.List;

import javax.servlet.annotation.WebServlet;

import core.bean.Member;
import core.bean.Vehide;
import member.dao.MemberDao;
import member.dao.impl.MemberDaoImpl;
import member.service.MemberService;


@WebServlet("/LoginServiceImpl")
public class MemberServiceImpl implements MemberService {
	private MemberDao dao;
	
	public MemberServiceImpl() {
		dao = new MemberDaoImpl();
	}

	@Override
	public boolean register(Member member) {
		int result = dao.insert(member);
		return result > 0;
	}
	
	@Override
	public Member login(Member member) {
		return dao.selectForLogin(member.getPhoneNo(), member.getPassword());
	}
	
	@Override
	public boolean editMember(Member member) {
		int result = dao.update(member);
		return result > 0;
	}

//	@Override
//	public List<Member> findAllMember() {
//		return dao.selectAll();
//	}

	@Override
	public Member findMemberById(Integer id) {
		return dao.selectByKey(id);
	}

	@Override
	public List<Vehide> vihide(Integer target, Integer id) {
		return dao.vehide(target, id);
	}

//	@Override
//	public List<Vehide> relatedPersonVihide(Integer id) {
//		// TODO Auto-generated method stub
//		return dao.relatedPersonVehide(id);
//	}
}
