package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDAO {
	String jdbcURL;
	String jdbcDriver;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	
	public EmployeeDAO() {
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

	public void employeeInsert(EmployeeDTO dto) {
		con = getConnection();
		sql = "insert into employees ( EMP_NUM, EMP_ID, EMP_PW, EMP_NAME, EMP_ADDR, EMP_ADDR_DETAIL, EMP_POST, EMP_PHONE, EMP_JUMIN, EMP_EMAIL, EMP_HIRE_DATE)";
		sql += "values (?,?,?,?,?,?,?,?,?,?,sysdate)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getEmpNum());
			pstmt.setString(2, dto.getEmpId());
			pstmt.setString(3, dto.getEmpPw());
			pstmt.setString(4, dto.getEmpName());
			pstmt.setString(5, dto.getEmpAddr());
			pstmt.setString(6, dto.getEmpAddrDetail());
			pstmt.setString(7, dto.getEmpPost());
			pstmt.setString(8, dto.getEmpPhone());
			pstmt.setString(9, dto.getEmpJumin());
			pstmt.setString(10, dto.getEmpEmail());
			int i = pstmt.executeUpdate();
			System.out.println(i+"행 삽입");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
	}
	public List<EmployeeDTO> EmployeeSelectAll() {
		con = getConnection();
		sql = "select EMP_NUM, EMP_ID, EMP_PW, EMP_NAME, EMP_ADDR, EMP_ADDR_DETAIL, EMP_POST, EMP_PHONE, EMP_JUMIN, EMP_EMAIL, EMP_HIRE_DATE from employees";
		List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		EmployeeDTO dto = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new EmployeeDTO();
				dto.setEmpNum(rs.getString(1));
				dto.setEmpId(rs.getString(2));
				dto.setEmpPw(rs.getString(3));
				dto.setEmpName(rs.getString(4));
				dto.setEmpAddr(rs.getString(5));
				dto.setEmpAddrDetail(rs.getString(6));
				dto.setEmpPost(rs.getString(7));
				dto.setEmpPhone(rs.getString(8));
				dto.setEmpJumin(rs.getString(9));
				dto.setEmpEmail(rs.getString(10));
				dto.setEmpHireDate(rs.getDate(11));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		return list;
	}
	public EmployeeDTO employeeSelectOne(String empNum) {
		con = getConnection();
		sql = "select EMP_NUM, EMP_ID, EMP_PW, EMP_NAME, EMP_ADDR, EMP_ADDR_DETAIL, EMP_POST, EMP_PHONE, EMP_JUMIN, EMP_EMAIL, EMP_HIRE_DATE from employees";
		sql += " where emp_num = ?";
		EmployeeDTO dto = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new EmployeeDTO();
				dto.setEmpNum(rs.getString(1));
				dto.setEmpId(rs.getString(2));
				dto.setEmpPw(rs.getString(3));
				dto.setEmpName(rs.getString(4));
				dto.setEmpAddr(rs.getString(5));
				dto.setEmpAddrDetail(rs.getString(6));
				dto.setEmpPost(rs.getString(7));
				dto.setEmpPhone(rs.getString(8));
				dto.setEmpJumin(rs.getString(9));
				dto.setEmpEmail(rs.getString(10));
				dto.setEmpHireDate(rs.getDate(11));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}
	public void employeeUpdate(EmployeeDTO dto) {
		con = getConnection();
		sql = "update employees set EMP_ID=?, EMP_PW=?, EMP_NAME=?, EMP_ADDR=?, EMP_ADDR_DETAIL=?, EMP_POST=?, EMP_PHONE=?, EMP_JUMIN=?, EMP_EMAIL=?";
		sql += " where emp_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getEmpId());
			pstmt.setString(2, dto.getEmpPw());
			pstmt.setString(3, dto.getEmpName());
			pstmt.setString(4, dto.getEmpAddr());
			pstmt.setString(5, dto.getEmpAddrDetail());
			pstmt.setString(6, dto.getEmpPost());
			pstmt.setString(7, dto.getEmpPhone());
			pstmt.setString(8, dto.getEmpJumin());
			pstmt.setString(9, dto.getEmpEmail());
			pstmt.setString(10, dto.getEmpNum());
			int i = pstmt.executeUpdate();
			System.out.println(i+"행 수정");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	public void employeeDelete(String empNum) {
		con = getConnection();
		sql = "delete from employees where emp_num=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empNum);
			int i = pstmt.executeUpdate();
			System.out.println(i+"행 삭제");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		
		
	}
	public String EmployeeAutoNum() {
		con = getConnection();
		sql = " select concat('emp_', nvl(substr(max(emp_num),5),100000)+1 )from employees";
		String num = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			num = rs.getString(1);
			System.out.println("직원번호 : " + num );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
		
	}
	public String employeeNumSelect(String empId) {
		
		con = getConnection();
		sql = "select emp_num from employees where emp_id = ?";
		String empNum = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empId);
			rs = pstmt.executeQuery();
			rs.next();
			empNum = rs.getString(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return empNum;
	}
	public void EmployeePwUpdate(String newPw, String userId) {
		con = getConnection();
		sql = "update employees set emp_pw = ? where emp_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newPw);
			pstmt.setString(2, userId);
			int i = pstmt.executeUpdate();
			System.out.println(i+"행 비밀번호 변경");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public String empNumSelect(String empId) {
		String empNum = null;
		con =  getConnection();
		sql = "select emp_num from employees where emp_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empId);
			rs = pstmt.executeQuery();
			rs.next();
			empNum = rs.getString(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return empNum;
	}
	
	
	public void close() {
		if(rs != null)
			try {
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(pstmt != null)
			try {
				pstmt.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(con != null)
			try {
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}



	

	

	
	

	



}
