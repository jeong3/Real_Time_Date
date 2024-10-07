package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO extends DataBaseInfo{

	public void reviewInsert(ReviewDTO dto) {
		con = getConnection();
		sql = "merge into reviews r"
				+ " using (select purchase_num, goods_num from purchase_list where purchase_num = ? and goods_num = ?) p"
				+ " on (r.purchase_num = p.purchase_num and r.goods_num = p.goods_num)"
				+ " when matched then"
				+ "		update set review_contents = ?"
				+ " when not matched then "
				+ "		insert (review_num, goods_num, purchase_num, review_date, review_contents, member_id) "
				+ "		values (review_seq.nextval, ?, ?, sysdate, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getPurchaseNum());
			pstmt.setString(2, dto.getGoodsNum());
			pstmt.setString(3, dto.getReviewContent());
			pstmt.setString(4, dto.getGoodsNum());
			pstmt.setString(5, dto.getPurchaseNum());
			pstmt.setString(6, dto.getReviewContent());
			pstmt.setString(7, dto.getMemberId());
			int i = pstmt.executeUpdate();
			System.out.println(i+"개 리뷰 수정/등록 되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}

	public void reviewSelectOne(ReviewDTO dto) {
		con = getConnection();
		sql = "select review_contents from reviews "
				+ "where purchase_num = ? and goods_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getPurchaseNum());
			pstmt.setString(2, dto.getGoodsNum());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setReviewContent(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}

	public void reviewDelete(String reviewNum) {
		con = getConnection();
		sql = " delete from reviews where review_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reviewNum);
			int i = pstmt.executeUpdate();
			System.out.println(i+"개 리뷰삭제");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close();
		}
		
		
	}

	public List<ReviewDTO> reviewSelectAll(String goodsNum) {
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		ReviewDTO dto = new ReviewDTO();
		con = getConnection();
		sql = "select review_num, review_date, review_contents, member_id from reviews where goods_num = ?";		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setReviewNum(rs.getInt(1));
				dto.setReviewDate(rs.getDate(2));
				dto.setReviewContent(rs.getString(3));
				dto.setMemberId(rs.getString(4));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
