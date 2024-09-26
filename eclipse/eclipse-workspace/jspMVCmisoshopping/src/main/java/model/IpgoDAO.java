package model;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IpgoDAO extends DataBaseInfo{
	public String AutoIpgoNum() {
		String ipgoNum = null;
		con = getConnection();
		sql = "select concat('ipgo_',nvl(substr(max(ipgo_num),6),100000)+1) from goods_ipgo";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			ipgoNum = rs.getString(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ipgoNum;
	}

	public void IpgoRegist(IpgoDTO dto) {
		con = getConnection();
		sql = "insert into goods_ipgo (GOODS_NUM, IPGO_NUM, IPGO_QTY, IPGO_DATE, MADE_DATE, IPGO_PRICE, EMP_NUM)";
		sql += " values (?,?,?,sysdate,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getGoodsNum());
			pstmt.setString(2, dto.getIpgoNum());
			pstmt.setInt(3, dto.getIpgoQty());
			pstmt.setDate(4, new Date(dto.getMadeDate().getTime()));
			pstmt.setInt(5, dto.getIpgoPrice());
			pstmt.setString(6, dto.getEmpNum());
			int i = pstmt.executeUpdate();
			System.out.println(i+"행 삽입");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}

	public List<IpgoDTO> IpgoSelectAll() {
		List<IpgoDTO> list = new ArrayList<IpgoDTO>();
		IpgoDTO dto = null;
		con = getConnection();
		sql = "select GOODS_NUM, IPGO_NUM, IPGO_QTY, IPGO_DATE, MADE_DATE, IPGO_PRICE, EMP_NUM from goods_ipgo";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new IpgoDTO();
				dto.setGoodsNum(rs.getString(1));
				dto.setIpgoNum(rs.getString(2));
				dto.setIpgoQty(rs.getInt(3));
				dto.setIpgoDate(rs.getDate(4));
				dto.setMadeDate(rs.getDate(5));
				dto.setIpgoPrice(rs.getInt(6));
				dto.setEmpNum(rs.getString(7));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}

	public IpgoDTO IpgoSelectOne(String ipgoNum) {
		IpgoDTO dto = null;
		con = getConnection();
		sql = "select GOODS_NUM, IPGO_NUM, IPGO_QTY, IPGO_DATE, MADE_DATE, IPGO_PRICE, EMP_NUM from goods_ipgo ";
		sql += " where ipgo_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ipgoNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new IpgoDTO();
				dto.setGoodsNum(rs.getString(1));
				dto.setIpgoNum(rs.getString(2));
				dto.setIpgoQty(rs.getInt(3));
				dto.setIpgoDate(rs.getDate(4));
				dto.setMadeDate(rs.getDate(5));
				dto.setIpgoPrice(rs.getInt(6));
				dto.setEmpNum(rs.getString(7));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
		
	}

	public void IpgoUpdate(String ipgoNum) {
		IpgoDTO dto = new IpgoDTO();
		con = getConnection();
		sql = "update goods_ipgo set GOODS_NUM = ?, IPGO_QTY=?, IPGO_DATE=?, MADE_DATE=?, IPGO_PRICE=?, EMP_NUM=?"
				+ " where ipgo_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getGoodsNum());
			pstmt.setInt(2, dto.getIpgoQty());
			pstmt.setDate(3, new Date(dto.getIpgoDate().getTime()));
			pstmt.setDate(4, new Date(dto.getMadeDate().getTime()));
			pstmt.setInt(5, dto.getIpgoPrice());
			pstmt.setString(6, dto.getEmpNum());
			pstmt.setString(7, ipgoNum);
			int i = pstmt.executeUpdate();
			System.out.println(i+"행 수정");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
}
