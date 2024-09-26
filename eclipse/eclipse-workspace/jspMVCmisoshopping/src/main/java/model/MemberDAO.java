package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	String jdbcURL;
	String jdbcDriver;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;

	public MemberDAO() {
		jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		jdbcDriver = "oracle.jdbc.driver.OracleDriver";
	}

	public Connection getConnection() {
		Connection co = null;
		try {
			Class.forName(jdbcDriver);
			co = DriverManager.getConnection(jdbcURL, "miso", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return co;
	}

	public void memberInsert(MemberDTO dto) {
		con = getConnection();
		sql = "insert into members (member_num, member_name, MEMBER_ID, MEMBER_PW, MEMBER_ADDR, MEMBER_ADDR_DETAIL, MEMBER_POST, MEMBER_REGIST, GENDER, MEMBER_PHONE1, MEMBER_PHONE2, MEMBER_EMAIL, MEMBER_BIRTH, MEMBER_POINT)";
		sql += " values (?,?,?,?,?,?,?,sysdate,?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMemberNum());
			pstmt.setString(2, dto.getMemberName());
			pstmt.setString(3, dto.getMemberId());
			pstmt.setString(4, dto.getMemberPw());
			pstmt.setString(5, dto.getMemberAddr());
			pstmt.setString(6, dto.getMemberAddrDetail());
			pstmt.setString(7, dto.getMemberPost());
			pstmt.setString(8, dto.getGender());
			pstmt.setString(9, dto.getMemberPhone1());
			pstmt.setString(10, dto.getMemberPhone2());
			pstmt.setString(11, dto.getMemberEmail());
			pstmt.setDate(12, new Date(dto.getMemberBirth().getTime()));
			pstmt.setInt(13, 0);
			int i = pstmt.executeUpdate();
			System.out.println(i + "행 삽입");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public List<MemberDTO> memberSelectAll() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		MemberDTO dto = null;
		con = getConnection();
		sql = " select member_num, member_name, MEMBER_ID, MEMBER_PW, MEMBER_ADDR, MEMBER_ADDR_DETAIL, MEMBER_POST, MEMBER_REGIST, GENDER, MEMBER_PHONE1, MEMBER_PHONE2, MEMBER_EMAIL, MEMBER_BIRTH, MEMBER_POINT from members ";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new MemberDTO();
				dto.setMemberNum(rs.getString(1));
				dto.setMemberName(rs.getString(2));
				dto.setMemberId(rs.getString(3));
				dto.setMemberPw(rs.getString(4));
				dto.setMemberAddr(rs.getString(5));
				dto.setMemberAddrDetail(rs.getString(6));
				dto.setMemberPost(rs.getString(7));
				dto.setMemberRegist(rs.getDate(8));
				dto.setGender(rs.getString(9));
				dto.setMemberPhone1(rs.getString(10));
				dto.setMemberPhone2(rs.getString(11));
				dto.setMemberEmail(rs.getString(12));
				dto.setMemberBirth(rs.getDate(13));
				dto.setMemberPoint(rs.getInt(14));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public String memberAutoNum() {
		con = getConnection();
		sql = "select concat('mem_', nvl(substr(max(member_num),5), 100000) +1 ) from members"; // mem_100001

		String memberNum = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			memberNum = rs.getString(1);
			System.out.println("회원번호 : " + memberNum);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return memberNum;

	}

	public MemberDTO memberSelectOne(String memberNum) {
		con = getConnection();
		sql = " select member_num, member_name, MEMBER_ID, MEMBER_PW, MEMBER_ADDR, MEMBER_ADDR_DETAIL, MEMBER_POST, MEMBER_REGIST, GENDER, MEMBER_PHONE1, MEMBER_PHONE2, MEMBER_EMAIL, MEMBER_BIRTH, MEMBER_POINT";
		sql += " from members where member_num = ?";
		MemberDTO dto = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new MemberDTO();
				dto.setMemberNum(rs.getString(1));
				dto.setMemberName(rs.getString(2));
				dto.setMemberId(rs.getString(3));
				dto.setMemberPw(rs.getString(4));
				dto.setMemberAddr(rs.getString(5));
				dto.setMemberAddrDetail(rs.getString(6));
				dto.setMemberPost(rs.getString(7));
				dto.setMemberRegist(rs.getDate(8));
				dto.setGender(rs.getString(9));
				dto.setMemberPhone1(rs.getString(10));
				dto.setMemberPhone2(rs.getString(11));
				dto.setMemberEmail(rs.getString(12));
				dto.setMemberBirth(rs.getDate("member_birth"));
				dto.setMemberPoint(rs.getInt(14));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}

	public void MemberUpdate(MemberDTO dto) {
		con = getConnection();
		sql = "update members set member_name = ?, MEMBER_ID = ?, MEMBER_PW = ?, MEMBER_ADDR = ?, MEMBER_ADDR_DETAIL = ?, MEMBER_POST = ?,  GENDER =?, MEMBER_PHONE1 = ? , MEMBER_PHONE2 = ?, MEMBER_EMAIL = ?, MEMBER_BIRTH = ? , MEMBER_POINT = ?";
		sql += " where member_num = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMemberName());
			pstmt.setString(2, dto.getMemberId());
			pstmt.setString(3, dto.getMemberPw());
			pstmt.setString(4, dto.getMemberAddr());
			pstmt.setString(5, dto.getMemberAddrDetail());
			pstmt.setString(6, dto.getMemberPost());
			pstmt.setString(7, dto.getGender());
			pstmt.setString(8, dto.getMemberPhone1());
			pstmt.setString(9, dto.getMemberPhone2());
			pstmt.setString(10, dto.getMemberEmail());
			pstmt.setDate(11, new Date(dto.getMemberBirth().getTime()));
			pstmt.setInt(12, 0);
			pstmt.setString(13, dto.getMemberNum());
			int i = pstmt.executeUpdate();
			System.out.println(i + "행 수정");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}
	public void memberDelete(String memberNum) {
		con = getConnection();
		sql = "delete from members where member_num = ?";
		try {
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, memberNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "행 삭제");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(memberNum);
		
		
	}
	public String memberNumSelect(String memberId) {
		String memberNum = null;
		con = getConnection();
		sql = " select member_num from members where member_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberNum = rs.getString(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return memberNum;
	}
	
	public void MemberPwUpdate(String newPw, String userId) {
		con = getConnection();
		sql = "update members set member_pw = ? where member_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newPw);
			pstmt.setString(2, userId);
			int i = pstmt.executeUpdate();
			System.out.println(i+"행 비밀번호가 변경");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	

	public void close() {
		if (rs != null)
			try {
				rs.close();
			} catch (Exception e) {
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (Exception e) {
			}
		if (con != null)
			try {
				con.close();
			} catch (Exception e) {
			}
	}

	

	

	

	

}
