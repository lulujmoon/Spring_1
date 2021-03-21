package com.redbeet.s1.passbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PassbookController {
	
	@Autowired
	private PassbookService passbookService;
	
	@RequestMapping(value="passbook/passbookAdd")
	public void passbookAdd() {
		System.out.println("passbookAdd");
	}
	
	@RequestMapping(value="passbook/passbookAdd", method = RequestMethod.POST)
	public void passbookAdd(String name, double rate, String sell) {
		
	}
	
	@RequestMapping(value="passbook/passbookList")
	public void passbookList(Model model) throws Exception {
		List<PassbookDTO> ar = passbookService.getList();
		model.addAttribute("list", ar);
		model.addAttribute("kind", "Passbook");
	}
	
	@RequestMapping(value="passbook/passbookSelect")
	public void passbookSelect() {
		
	}
	
	@RequestMapping(value="passbook/passbookUpdate")
	public void passbookUpdate(){
		
	}
	
	@RequestMapping(value="passbook/passbookUpdate", method=RequestMethod.POST)
	public void passbookUpdate(int number){
		
	}	
	
	@RequestMapping(value="passbook/passbookDelete")
	public void passbookDelete() {
		
	}
	
	@RequestMapping(value="passbook/passbookDelete", method=RequestMethod.POST)
	public void passbookDelete(int number) {
		
	}

}
