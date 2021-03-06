package com.redbeet.s1.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	//memberJoin이라는 메서드. print로 확인. url : /member/memberLogin.do
	
	@RequestMapping(value="member/memberJoin")
	private String memberJoin() {
		return "member/memberJoin";
	}
	
	
	@RequestMapping(value="member/memberJoin", method= RequestMethod.POST)
	private void memberJoin2(String id, String pw, String name, String phone, String email) throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPw(pw);
		memberDTO.setName(name);
		memberDTO.setPhone(phone);
		memberDTO.setEmail(email);
		memberService.memberJoin(memberDTO);
	}
	
	
	
	
	
	@RequestMapping(value="member/memberLogin") 
	public String memberLogin(String name, int age) {
		System.out.println(name);
		System.out.println(age);
		return "member/memberLogin";
	}
	
	@RequestMapping(value="member/memberLogin", method = RequestMethod.POST)
	public void memberLogin2(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPw(pw);
		memberDTO = memberService.memberLogin(memberDTO);
		System.out.println(memberDTO);
	}
	
	
	
}
