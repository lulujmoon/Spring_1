package com.redbeet.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		memberDAO.login(memberDTO);
		return memberDTO;
	}

	public void memberJoin(MemberDTO memberDTO) throws Exception{
		memberDAO.join(memberDTO);
	}
}
