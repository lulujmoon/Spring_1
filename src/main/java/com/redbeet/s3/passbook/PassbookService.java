package com.redbeet.s3.passbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassbookService {

	@Autowired
	private PassbookDAO passbookDAO;
	
	public PassbookDTO getSelect(PassbookDTO passbookDTO) throws Exception {
		return passbookDAO.getSelect(passbookDTO);
	}
	
	public List<PassbookDTO> getList() throws Exception {
		return passbookDAO.getList();
	}
}
