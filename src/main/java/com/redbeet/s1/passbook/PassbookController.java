package com.redbeet.s1.passbook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PassbookController {
	
	@RequestMapping(value="/passbook/passbookAdd", method=RequestMethod.POST)
	public String passbookAdd() {
		return "WEB-INF/views/passbook/passbookAdd.jsp";
	}

}
