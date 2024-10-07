package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class BoardDAO {
	String jdbcURL;
	String jdbcDriver;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	
	public BoardDAO() {
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

	public void boardInsert(BoardDTO dto) {
		con = getConnection();
		String boardNum = "select nvl(max(board_num),0)+1 from board";
		sql = "insert into board (board_num, board_writer, board_subject, board_content) ";
		sql+= "values (("+boardNum+"), ?,?,? )";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBoardWriter());
			pstmt.setString(2, dto.getBoardSubject());
			pstmt.setString(3, dto.getBoardContent());
			int i = pstmt.executeUpdate();
			System.out.println(i+"행 삽입");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		
	}

	public List<BoardDTO> boardSelectAll() {
		BoardDTO dto = null;
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		con = getConnection();
		sql = "select board_num, board_writer, board_subject, board_content from board order by 1";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new BoardDTO();
				dto.setBoardNum(rs.getInt(1));
				dto.setBoardWriter(rs.getString(2));
				dto.setBoardSubject(rs.getString(3));
				dto.setBoardContent(rs.getString(4));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
	}
	public BoardDTO BoardSelectOne(int boardNum) {
		BoardDTO dto = null;
		con = getConnection();
		sql = "select board_num, board_writer, board_subject, board_content from board where board_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new BoardDTO();
				dto.setBoardNum(rs.getInt(1));
				dto.setBoardSubject(rs.getString(3));
				dto.setBoardWriter(rs.getString(2));
				dto.setBoardContent(rs.getString(4));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
		
		
	}
	public void BoardUpdate(BoardDTO dto) {
		con = getConnection();
		sql = "update board set board_writer=? , board_subject=? , board_content=? where board_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBoardWriter());
			pstmt.setString(2, dto.getBoardSubject());
			pstmt.setString(3, dto.getBoardContent());
			pstmt.setInt(4, dto.getBoardNum());
			int i = pstmt.executeUpdate();
			System.out.println(i+"행 수정");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}

	public void boardDelete(int boardNum) {
		con = getConnection();
		sql = "delete from board where board_num =?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			int i = pstmt.executeUpdate();
			System.out.println(i+"행이 삭제");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	public void close() {
		if(rs != null)try {rs.close();}catch (Exception e) {}
		if(con != null)try {con.close();}catch (Exception e) {}
		if(pstmt != null)try {pstmt.close();}catch (Exception e) {}
		
	}

	
	
}
