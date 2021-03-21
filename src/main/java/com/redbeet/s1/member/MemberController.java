package com.redbeet.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/member/memberJoin")
	public String memberJoin() {
		return "member/memberJoin";
	}
	
	@RequestMapping(value="/member/memberJoin", method = RequestMethod.POST)
	public void memberJoin(MemberDTO memberDTO) throws Exception {
		int result = memberService.memberJoin(memberDTO);
		System.out.println(result);
		
	}
	
	@RequestMapping(value ="/member/memberLogin")
	public String memberLogin() {
		System.out.println("hi");
		return "member/memberLogin";
	}
	
	@RequestMapping(value ="/member/memberLogin", method=RequestMethod.POST)
	public void memberLogin(MemberDTO memberDTO) throws Exception {
		memberDTO = memberService.memberLogin(memberDTO);
		System.out.println(memberDTO.getEmail());
	}
}
