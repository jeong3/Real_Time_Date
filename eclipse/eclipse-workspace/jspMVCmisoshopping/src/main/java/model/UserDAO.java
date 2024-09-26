package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	String jdbcURL;
	String jdbcDriver;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	
	public UserDAO() {
		jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		jdbcDriver = "oracle.jdbc.driver.OracleDriver";
	}
	public Connection getConnection() {
		Connection co = null;
		try {
			Class.forName(jdbcDriver);
			co = DriverManager.getConnection(jdbcURL,"miso","1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return co;
	}

	public void userRegist(MemberDTO dto) {
		con = getConnection();
		String memberNum = "select concat('mem_',substr(max(member_num),5)+1) from members";
		sql ="insert into members (member_num, member_id, member_pw, member_name, member_phone1, member_phone2, member_addr, member_addr_detail, member_post, member_email, gender)";
		sql += " values ((" + memberNum + "), ?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMemberId());
			pstmt.setString(2, dto.getMemberPw());
			pstmt.setString(3, dto.getMemberName());
			pstmt.setString(4, dto.getMemberPhone1());
			pstmt.setString(5, dto.getMemberPhone2());
			pstmt.setString(6, dto.getMemberAddr());
			pstmt.setString(7, dto.getMemberAddrDetail());
			pstmt.setString(8, dto.getMemberPost());
			pstmt.setString(9, dto.getMemberEmail());
			pstmt.setString(10, dto.getGender());
			int i = pstmt.executeUpdate();
			System.out.println(i+"행 삽입");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	 public AuthInfoDTO loginSelect(String userId) {
	      AuthInfoDTO dto = null;
	      con = getConnection();
	      sql = "select member_id user_id, member_pw user_pw, member_name user_name, member_email user_email, 'mem' grade";
	      sql += " from members where member_id = ? union select emp_id, emp_pw, emp_name, emp_email, 'emp'";
	      sql += " from employees where emp_id = ?";
	      try {
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, userId);
	         pstmt.setString(2, userId);
	         rs = pstmt.executeQuery();
	         if(rs.next()) {
	            dto = new AuthInfoDTO();
	            dto.setUserId(rs.getString("user_id"));
	            dto.setUserPw(rs.getString("user_pw"));
	            dto.setUserName(rs.getString("user_name"));
	            dto.setGrade(rs.getString("grade"));
	            dto.setUserEmail(rs.getString("user_email"));
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         close();
	      }
	      return dto;
	   }

	
	
	public void close() {
		if(rs!=null)try {rs.close();} catch (Exception e) {e.printStackTrace();}
		if(pstmt!=null)try {pstmt.close();} catch (Exception e) {e.printStackTrace();}
		if(con!=null)try {con.close();} catch (Exception e) {e.printStackTrace();}
	}
	
	
	
	
}
