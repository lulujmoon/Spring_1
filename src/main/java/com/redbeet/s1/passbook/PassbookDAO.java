package com.redbeet.s1.passbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PassbookDAO {

	public Connection connectDB() throws Exception {
		String user = "user01";
		String pw = "user01";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, pw);
		return con;
	}
	
	public List<PassbookDTO> getList() throws Exception {
		Connection con = this.connectDB();
		String sql = "select * from passbook";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<PassbookDTO> ar = new ArrayList<PassbookDTO>();
		
		while(rs.next()) {
			PassbookDTO passbookDTO = new PassbookDTO();
			passbookDTO.setNum(rs.getInt("num"));
			passbookDTO.setName(rs.getString("name"));
			passbookDTO.setIrate(rs.getDouble("irate"));
			passbookDTO.setOpenable(rs.getString("openable"));
			ar.add(passbookDTO);
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return ar;
		
	}
	
	
}
