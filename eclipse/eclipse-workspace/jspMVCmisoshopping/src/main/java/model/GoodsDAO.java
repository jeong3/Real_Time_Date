package model;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDAO extends DataBaseInfo{
	public String AutoGoodsNum() {
		String num = null;
		con = getConnection();
		sql = "select concat('goods_', nvl(substr(max(goods_num),7),100000)+1) from goods";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			num = rs.getString(1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return num;
	}
	public void GoodsRegist(GoodsDTO dto) {
		con = getConnection();
		sql = "insert into goods(EMP_NUM, UPDATE_EMP_NUM, GOODS_REGIST, GOODS_UPDATE_DATE, VISIT_COUNT, GOODS_NUM, GOODS_NAME, GOODS_PRICE, GOODS_CONTENTS, GOODS_MAIN_IMAGE, GOODS_MAIN_STORE_IMAGE, GOODS_DETAIL_IMAGE, GOODS_DETAIL_STORE_IMAGE)";
		sql += "values (?, ?, sysdate, sysdate, 0, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getEmpNum());
			pstmt.setString(2, dto.getUpdateEmpNum());
			pstmt.setString(3, dto.getGoodsNum());
			pstmt.setString(4, dto.getGoodsName());
			pstmt.setInt(5, dto.getGoodsPrice());
			pstmt.setString(6, dto.getGoodsContents());
			pstmt.setString(7, dto.getGoodsMainImage());
			pstmt.setString(8, dto.getGoodsMainStoreImage());
			pstmt.setString(9, dto.getGoodsDetailImage());
			pstmt.setString(10, dto.getGoodsDetailStoreImage());
			int i = pstmt.executeUpdate();
			System.out.println(i+"행 삽입");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public List<GoodsDTO> GoodsSelectAll() {
		GoodsDTO dto = null;
		List<GoodsDTO> list = new ArrayList<GoodsDTO>();
		con = getConnection();
		sql = "select EMP_NUM, UPDATE_EMP_NUM, GOODS_REGIST, GOODS_UPDATE_DATE, VISIT_COUNT, GOODS_NUM, GOODS_NAME, GOODS_PRICE, GOODS_CONTENTS, GOODS_MAIN_IMAGE, GOODS_MAIN_STORE_IMAGE, GOODS_DETAIL_IMAGE, GOODS_DETAIL_STORE_IMAGE";
		sql += " from goods";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new GoodsDTO();
				dto.setEmpNum(rs.getString(1)); 
				dto.setUpdateEmpNum(rs.getString(2));
				dto.setGoodsRegist(rs.getDate(3));
				dto.setGoodsUpdateDate(rs.getDate(4));
				dto.setVisitCount(rs.getInt(5));
				dto.setGoodsNum(rs.getString(6));
				dto.setGoodsName(rs.getString(7));
				dto.setGoodsPrice(rs.getInt(8));
				dto.setGoodsContents(rs.getString(9));
				dto.setGoodsMainImage(rs.getString(10));
				dto.setGoodsMainStoreImage(rs.getString(11));
				dto.setGoodsDetailImage(rs.getString(12));
				dto.setGoodsDetailStoreImage(rs.getString(13));
				list.add(dto);
			}
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
	}
	public GoodsDTO GoodsSelectOne(String goodsNum) {
		GoodsDTO dto = null;
		con = getConnection();
		sql = "select EMP_NUM, UPDATE_EMP_NUM, GOODS_REGIST, GOODS_UPDATE_DATE, VISIT_COUNT, GOODS_NUM, GOODS_NAME, GOODS_PRICE, GOODS_CONTENTS, GOODS_MAIN_IMAGE, GOODS_MAIN_STORE_IMAGE, GOODS_DETAIL_IMAGE, GOODS_DETAIL_STORE_IMAGE";
		sql += " from goods where goods_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new GoodsDTO();
				dto.setEmpNum(rs.getString(1)); 
				dto.setUpdateEmpNum(rs.getString(2));
				dto.setGoodsRegist(rs.getDate(3));
				dto.setGoodsUpdateDate(rs.getDate(4));
				dto.setVisitCount(rs.getInt(5));
				dto.setGoodsNum(rs.getString(6));
				dto.setGoodsName(rs.getString(7));
				dto.setGoodsPrice(rs.getInt(8));
				dto.setGoodsContents(rs.getString(9));
				dto.setGoodsMainImage(rs.getString(10));
				dto.setGoodsMainStoreImage(rs.getString(11));
				dto.setGoodsDetailImage(rs.getString(12));
				dto.setGoodsDetailStoreImage(rs.getString(13));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
		
		
	}
	public void GoodsUpdate(GoodsDTO dto) {
		con = getConnection();
		sql = "update goods set UPDATE_EMP_NUM = ? , GOODS_UPDATE_DATE = sysdate,  GOODS_NAME =?, GOODS_PRICE=?, GOODS_CONTENTS=?";
		sql += ", visit_count = 0 , emp_num = ? ";
		sql += " where goods_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUpdateEmpNum());
			pstmt.setString(2, dto.getGoodsName());
			pstmt.setInt(3, dto.getGoodsPrice());
			pstmt.setString(4, dto.getGoodsContents());
			pstmt.setString(5, dto.getEmpNum());
			pstmt.setString(6, dto.getGoodsNum());
			int i =  pstmt.executeUpdate();
			System.out.println(i+"행 수정");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
	}
	public int GoodsDelete(String goodsNum) {
		con = getConnection();
		sql = "delete from goods where goods_num = ?";
		int i = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			i = pstmt.executeUpdate();
			System.out.println(i+"행 삭제");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return i;
		
	}
	public void visitCount(String goodsNum) {
		con = getConnection();
		sql = "update goods set visit_count = visit_count + 1 where goods_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			pstmt.executeUpdate();
			System.out.println("조회 수 1 증가");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	
	
}
