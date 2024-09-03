package board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	String jdbcURL;
	String jdbcDriver;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	
	
	
	public BoardDAO() {
		jdbcURL="jdbc:oracle:thin:@localhost:1521:xe";
		jdbcDriver="oracle.jdbc.driver.OracleDriver";
	}
	public Connection getConnection() {
		Connection co = null;
		try {//예외처리 : 에러가 있어도 프로그램은 실행시키기 위함
			Class.forName(jdbcDriver);
			co = DriverManager.getConnection(jdbcURL, "miso", "1234");
		} catch (Exception e) { //에러메세지 받아오기
			e.printStackTrace();
		}
		
		return co;
	}
	public void boardInsert(BoardDTO dto) {
		con = getConnection();
		String boardNum = "select nvl(max(board_num),0)+1 from board";
		sql = "insert into board(board_num, board_writer, board_subject, board_content) "
				+ " values( ("+boardNum+")  , ?,?,?) ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBoardWriter());
			pstmt.setString(2, dto.getBoardSubject());
			pstmt.setString(3, dto.getBoardContent());
			int i = pstmt.executeUpdate();
			System.out.println(i+"개 행이 삽입되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	public List<BoardDTO> boardSelectAll() {
		con = getConnection();
		sql = "select board_num, board_writer, board_subject, board_content from board order by 1 asc";
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBoardNum(rs.getInt("board_num"));
				dto.setBoardWrite(rs.getString("board_writer"));
				dto.setBoardSubject(rs.getString("board_subject"));
				dto.setBoardContent(rs.getString("board_content"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	public BoardDTO boardSelectOne(int boardNum) {
		con = getConnection();
		sql = "select board_num, board_writer, board_subject, board_content from board ";
		sql += "where board_num = ?";
		BoardDTO dto = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new BoardDTO();
				dto.setBoardNum(rs.getInt("board_Num"));
				dto.setBoardSubject(rs.getString("board_subject"));
				dto.setBoardWrite(rs.getString("board_writer"));
				dto.setBoardContent(rs.getString("board_content"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}
	public void boardUpdate(BoardDTO dto) {
		con = getConnection();
		sql = "update board set board_writer = ? , board_subject = ? , board_content = ? "
				+ " where board_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBoardWriter());
			pstmt.setString(2, dto.getBoardSubject());
			pstmt.setString(3, dto.getBoardContent());
			pstmt.setInt(4, dto.getBoardNum());
			int i = pstmt.executeUpdate();
			System.out.println(i+"개 행이 수정되었습니다.");
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public void boardDelete(int boardNum) {
		con = getConnection();
		sql = "delete from board where board_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 행이 삭제되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	
	
	public void close() {
		if(rs != null) try {rs.close();}catch(Exception e) {}
		if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
		if(con != null) try {con.close();}catch(Exception e) {}
	}
	
	
	
	
	
	
}
