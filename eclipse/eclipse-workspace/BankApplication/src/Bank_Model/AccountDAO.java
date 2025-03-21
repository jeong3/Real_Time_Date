package Bank_Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// AccountDAO 클래스는 데이터베이스와 연결하여 계좌 정보를 삽입, 조회, 수정, 삭제하는 기능을 수행
public class AccountDAO {
	// 데이터베이스 연결에 필요한 URL, 드라이버 클래스 이름, 연결 객체, SQL 실행을 위한 객체 등을 선언
	String jdbcURL;
	String jdbcDriver;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;

	// 기본 생성자 - 데이터베이스 연결에 필요한 URL과 드라이버 클래스를 초기화
	public AccountDAO() {
		// 데이터베이스 연결 문자열 (Oracle DB에 접속하기 위한 URL)
		jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		// Oracle JDBC 드라이버 클래스 이름
		jdbcDriver = "oracle.jdbc.driver.OracleDriver";
	}

	// 데이터베이스와 연결을 설정하는 메서드
	public Connection getConnection() {
		Connection conn = null;
		try {
			// JDBC 드라이버를 메모리에 로드하여 데이터베이스와의 연결을 가능하게 함
			Class.forName(jdbcDriver);
			// 지정된 URL과 사용자 계정으로 데이터베이스에 연결을 시도
			conn = DriverManager.getConnection(jdbcURL, "miso", "1234");
		} catch (Exception e) {
			// 오류가 발생했을 경우 에러 메시지를 출력하여 확인할 수 있도록 함
			e.printStackTrace();
		}
		// 데이터베이스 연결 객체를 반환
		return conn;
	}

	// 새로운 계좌를 데이터베이스에 삽입하는 메서드
	public void accountInsert(AccountDTO dto) {
		// 데이터베이스 연결 객체를 가져옴
		con = getConnection();
		// SQL 삽입 쿼리 정의 (계좌 번호, 소유자, 잔고 정보를 계좌 테이블에 삽입)
		sql = "insert into account(accountno, owner, balance) values(?,?,?)";
		try { // 예외처리
				// PreparedStatement 객체를 생성하여 SQL 쿼리를 준비
			pstmt = con.prepareStatement(sql);
			// SQL 쿼리의 첫 번째 파라미터에 계좌 번호를 설정
			pstmt.setInt(1, dto.getAccountNo());
			// SQL 쿼리의 두 번째 파라미터에 소유자 이름을 설정
			pstmt.setString(2, dto.getOwner());
			// SQL 쿼리의 세 번째 파라미터에 잔고를 설정
			pstmt.setInt(3, dto.getBalance());
			// SQL 쿼리를 실행하여 데이터베이스에 삽입을 수행, 결과로 삽입된 행의 수를 반환
			int i = pstmt.executeUpdate(); // executeUpdate() : insert, update, delete
			// 삽입된 행의 수를 출력하여 확인
			System.out.println(i + "개가 삽입되었습니다.");
		} catch (Exception e) {
			// 오류가 발생했을 경우 에러 메시지를 출력하여 확인할 수 있도록 함
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public List<AccountDTO> accountAll() {
		List<AccountDTO> list = new ArrayList<AccountDTO>();
		con = getConnection();
		sql = "select accountno, owner, balance from account";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); // select => record set
			while (rs.next()) {
				AccountDTO dto = new AccountDTO();
				dto.setAccountNo(rs.getInt(1));
				dto.setOwner(rs.getString(2));
				dto.setBalance(rs.getInt(3));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;

	}

	public AccountDTO accountOne(int accountNo) {
		AccountDTO dto = null;
		con = getConnection();
		sql = "select accountno, owner, balance from account where accountno = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, accountNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new AccountDTO();
				dto.setAccountNo(rs.getInt("accountno"));
				dto.setOwner(rs.getString("owner"));
				dto.setBalance(rs.getInt("balance"));	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}
	public void depositUpdate(AccountDTO dto) {
		con = getConnection();
		sql = "update account set balance = balance + ? where accountNo = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBalance());
			pstmt.setInt(2, dto.getAccountNo());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다.");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public void withdrawUpdate(AccountDTO dto) {
		con = getConnection();
		sql = "update account set balance = balance - ? where accountNo = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBalance());
			pstmt.setInt(2, dto.getAccountNo());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
				
	}

	public void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
			}
		}
	}

}
