package com.redbeet.s3.passbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PassbookController {
	
	@Autowired
	private PassbookService passbookService;
	
	@RequestMapping(value="/passbook/passbookList")
	public void passbookList(Model model) throws Exception {
		List<PassbookDTO> ar =  passbookService.getList();
		model.addAttribute("list", ar);
		model.addAttribute("kind", "Passbook El Test");
	}
	
	@RequestMapping(value="/passbook/passbookSelect")
	public ModelAndView passbookSelect(PassbookDTO passbookDTO, ModelAndView modelAndView) throws Exception {
		passbookDTO = passbookService.getSelect(passbookDTO);
		modelAndView.addObject("dto", passbookDTO);
		modelAndView.setViewName("passbook/passbookSelect");
		return modelAndView;
	}
	
	

}
