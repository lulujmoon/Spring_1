package com.redbeet.s3.passbook;

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
	
	public int setWrite(PassbookDTO passbookDTO) throws Exception {
		Connection con = this.connectDB();
		String sql = "insert into passbook values (pb_num.nextval, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, passbookDTO.getName());
		ps.setDouble(2, passbookDTO.getIrate());
		ps.setString(3, passbookDTO.getOpenable());
		
		int result = ps.executeUpdate();
		
		ps.close();
		con.close();
		
		return result;
	}
	
	public PassbookDTO getSelect(PassbookDTO passbookDTO) throws Exception {
		Connection con = this.connectDB();
		String sql = "select * from passbook where num=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, passbookDTO.getNum());
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			passbookDTO.setNum(rs.getInt("num"));
			passbookDTO.setName(rs.getString("name"));
			passbookDTO.setIrate(rs.getDouble("irate"));
			passbookDTO.setOpenable(rs.getString("openable"));
			
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return passbookDTO;
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
