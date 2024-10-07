package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InquireDAO extends DataBaseInfo {

	public void inquireInsert(InquireDTO dto) {
		con = getConnection();
		sql = " insert into inquire (inquire_num, member_num, goods_num, inquire_subject, INQUIRE_CONTENTS, INQUIRE_KIND, INQUIRE_DATE)"
				+ " values (review_seq.nextval, ?, ?, ?, ?, ?, sysdate)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMemberNum());
			pstmt.setString(2, dto.getGoodsNum());
			pstmt.setString(3, dto.getInquireSubject());
			pstmt.setString(4, dto.getInquireContent());
			pstmt.setString(5, dto.getInquireKind());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 문의삽입");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public List<InquireDTO> inquireSelectAll(String goodsNum) {
		List<InquireDTO> list = new ArrayList<InquireDTO>();
		con = getConnection();
		sql = " select INQUIRE_NUM, MEMBER_NUM, GOODS_NUM, INQUIRE_SUBJECT"
				+ "       ,INQUIRE_CONTENTS, inquire_kind, inquire_date "
				+ "       ,inquire_answer, inquire_answer_date,emp_num" 
				+ " from inquire ";
		if(goodsNum != null) {
			sql += " where goods_num = ?  ";
		}
		
		try {
			pstmt = con.prepareStatement(sql);
			if(goodsNum != null) {
				pstmt.setString(1, goodsNum);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				InquireDTO dto = new InquireDTO();
				dto.setEmpNum(rs.getString("emp_num"));
				dto.setGoodsNum(rs.getString("GOODS_NUM"));
				dto.setInquireAnswer(rs.getString("inquire_answer"));
				dto.setInquireContent(rs.getString("INQUIRE_CONTENTs"));
				dto.setInquireDate(rs.getDate("inquire_date"));
				dto.setInquireKind(rs.getString("inquire_kind"));
				dto.setInquireNum(rs.getLong("INQUIRE_NUM"));
				dto.setInquireSubject(rs.getString("INQUIRE_SUBJECT"));
				dto.setMemberNum(rs.getString("MEMBER_NUM"));
				dto.setInquireAnswerDate(rs.getDate("inquire_answer_date"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public void inquireSelectOne(InquireDTO dto) {
		
		con = getConnection();
		sql = " select INQUIRE_NUM, MEMBER_NUM, GOODS_NUM, INQUIRE_SUBJECT"
				+ "       ,INQUIRE_CONTENTS, inquire_kind, inquire_date "
				+ "       ,inquire_answer, inquire_answer_date,emp_num" 
				+ " from inquire ";
		sql += " where inquire_num = ?  ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, dto.getInquireNum());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setEmpNum(rs.getString("emp_num"));
				dto.setGoodsNum(rs.getString("GOODS_NUM"));
				dto.setInquireAnswer(rs.getString("inquire_answer"));
				dto.setInquireContent(rs.getString("INQUIRE_CONTENTs"));
				dto.setInquireDate(rs.getDate("inquire_date"));
				dto.setInquireKind(rs.getString("inquire_kind"));
				dto.setInquireNum(rs.getLong("INQUIRE_NUM"));
				dto.setInquireSubject(rs.getString("INQUIRE_SUBJECT"));
				dto.setMemberNum(rs.getString("MEMBER_NUM"));
				dto.setInquireAnswerDate(rs.getDate("inquire_answer_date"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void inquireUpdate(InquireDTO dto) {
		con = getConnection();
		sql = "update inquire "
			+ "set  inquire_subject=?, INQUIRE_CONTENTS=?, INQUIRE_KIND=?"
			+ "where inquire_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getInquireSubject());
			pstmt.setString(2, dto.getInquireContent());
			pstmt.setString(3, dto.getInquireKind());
			pstmt.setLong(4, dto.getInquireNum());
			int i = pstmt.executeUpdate();
			System.out.println(i+"개 문의가 수정됨");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
	}

	public void inquireDelete(String inquireNum) {
		con = getConnection();
		sql = "delete from inquire where inquire_num =?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, inquireNum);
			int i = pstmt.executeUpdate();
			System.out.println(i+"개 문의가 삭제됨");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}

	public void inquireReplyUpdate(InquireDTO dto) {
		con = getConnection();
		sql = "update inquire"
			+ " set inquire_answer = ?, emp_num=?, inquire_answer_date = sysdate"
			+ " where inquire_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getInquireAnswer());
			pstmt.setString(2, dto.getEmpNum());
			pstmt.setLong(3, dto.getInquireNum());
			int i = pstmt.executeUpdate();
			System.out.println(i+"개 문의 답변 수정");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		
	}

}
