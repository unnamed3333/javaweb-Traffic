package member.service.impl;


import java.util.Base64;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import core.bean.Member;
import core.bean.RelatedPerson;
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
		String base64 = member.getAvatarBase64();
		if (base64 != null && !base64.isEmpty()) {
			byte[] avatar = Base64.getDecoder().decode(base64);
			member.setAvatar(avatar);
		}
		
		int result = dao.update(member);
		return result > 0;
	}

	@Override
	public Member findMemberById(Integer id) {
		return dao.selectByKey(id);
	}

	@Override
	public List<Vehide> vihide(Integer target, Integer id) {
		return dao.vehide(target, id);
	}

	@Override
	public List<RelatedPerson> findRelatedPerson(Integer id) {
		return dao.findRelatedPerson(id);
	}

	@Override
	public boolean forgetPassword(String phoneNo) {
		return dao.forgetPassword(phoneNo);
	}

	@Override
	public boolean resetPassword(Member member) {
		return dao.resetPassword(member) > 1;
	}

	@Override
	public boolean relatedPersonRegister(RelatedPerson relatedPerson, Integer id) {
		String base64 = relatedPerson.getAvatarBase64();
		if (base64 != null && !base64.isEmpty()) {
			byte[] avatar = Base64.getDecoder().decode(base64);
			relatedPerson.setAvatar(avatar);
		}
		int result = dao.relatedPersonInsert(relatedPerson, id);
		return result > 0;
	}

	@Override
	public boolean editRelatedPerson(RelatedPerson relatedPerson) {
		String base64 = relatedPerson.getAvatarBase64();
		if (base64 != null && !base64.isEmpty()) {
			byte[] avatar = Base64.getDecoder().decode(base64);
			relatedPerson.setAvatar(avatar);
		}
		
		int result = dao.updateRelatedPerson(relatedPerson);
		return result > 0;
	}


}
