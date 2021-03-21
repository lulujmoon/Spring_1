package com.redbeet.s1.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	public Connection connectDB() throws Exception{
		
		String user = "user01";
		String pw = "user01";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,user,pw);
		
		return con;
	}
	
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		Connection con = this.connectDB();
		String sql = "insert into member (id, pw, name, phone, email) values (?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memberDTO.getId());
		ps.setString(2, memberDTO.getPw());
		ps.setString(3, memberDTO.getName());
		ps.setString(4, memberDTO.getPhone());
		ps.setString(5, memberDTO.getEmail());
		
		int result = ps.executeUpdate();
		
		ps.close();
		con.close();
		
		return result;
		
	}
	
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
		
		Connection con = this.connectDB();
		String sql = "select * from member where id=? and pw=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memberDTO.getId());
		ps.setString(2, memberDTO.getPw());
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			memberDTO.setName(rs.getString("name"));
			memberDTO.setPhone(rs.getString("phone"));
			memberDTO.setEmail(rs.getString("email"));
		}else {
			memberDTO = null;
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return memberDTO;
	}
}
