package model;

import java.sql.SQLException;

public class HelpDAO extends DataBaseInfo {


	public AuthInfoDTO findIdSelect(String userName, String userEmail) {
		AuthInfoDTO dto = null;
		con = getConnection();
		sql = "select member_id user_id, member_pw user_pw, member_name user_name, member_email user_email, 'mem' grade";
	      sql += " from members where member_name = ? and member_email = ? union select emp_id, emp_pw, emp_name, emp_email, 'emp'";
	      sql += " from employees where emp_name = ? and emp_email = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, userEmail);
			pstmt.setString(3, userName);
			pstmt.setString(4, userEmail);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new AuthInfoDTO();
				dto.setUserId(rs.getString("user_id"));
				System.out.println(rs.getString("user_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}

	public AuthInfoDTO findPwSelect(String userId, String userPhone) {
		AuthInfoDTO dto = null;
		con = getConnection();
		sql = "select  member_pw user_pw, member_name user_name, member_email user_email, member_phone1 user_phone, 'mem' grade";
	      sql += " from members where member_id = ? and member_phone1 = ? union select emp_pw, emp_name, emp_email, emp_phone, 'emp'";
	      sql += " from employees where emp_id = ? and emp_phone = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPhone);
			pstmt.setString(3, userId);
			pstmt.setString(4, userPhone);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new AuthInfoDTO();
				dto.setUserPw(rs.getString("user_pw"));
				System.out.println(rs.getString("user_pw"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}
	
	public String userSearch(String userId, String userPhone) {
		String i = null;
		con = getConnection();
		sql = "select 'mem' from members where member_id = ? and ( member_phone1 =? or member_phone2 = ? ) ";
		sql += " union select 'emp' from employees where emp_id = ? and emp_phone = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPhone);
			pstmt.setString(3, userPhone);
			pstmt.setString(4, userId);
			pstmt.setString(5, userPhone);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				i = rs.getString(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {close();}
				
		
		return i;
	}
	public void userPwUpdate(String userId, String newPw, String grade) {
		con = getConnection();
		switch(grade) {
		case "mem" : sql = "update members set member_pw = ? where member_id = ?";
		break;
		case "emp" : sql = "update employees set emp_pw = ? where emp_id = ?";
		break;
		}
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newPw);
			pstmt.setString(2, userId);
			int i = pstmt.executeUpdate();
			System.out.println("비번변경댐");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {close();}
		
	}

	
}
