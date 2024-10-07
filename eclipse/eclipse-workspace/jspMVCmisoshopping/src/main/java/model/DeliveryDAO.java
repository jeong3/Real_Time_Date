package model;

import java.sql.SQLException;

public class DeliveryDAO extends DataBaseInfo{

	public void deliveryInsert(String purchaseNum, String deliveryNum) {
		con = getConnection();
		sql = "merge into delivery d"
				+ " using( select purchase_num from purchase where purchase_num = ?) p "
				+ " on ( d.purchase_num = p.purchase_num )"
				+ " when matched then"
				+ " update set delivery_num = ? "
				+ " when not matched then "
				+ " insert ( purchase_num, delivery_num, delivery_date, DELIVERY_STATUS ) "
				+ " values (p.purchase_num, ? , sysdate, '배송중') ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, purchaseNum);
			pstmt.setString(2, deliveryNum);
			pstmt.setString(3, deliveryNum);
			pstmt.executeUpdate();
			System.out.println("배송정보 입력완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}

	public String deliveryNumSelectOne(String purchaseNum) {
		String deliveryNum = null;
		con = getConnection();
		sql = " select DELIVERY_NUM from delivery where purchase_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, purchaseNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				deliveryNum = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		return deliveryNum;
	}

	public void deliveryStatusUpdate(String purchaseNum) {
		con = getConnection();
		sql = "update delivery set delivery_status = ? where purchase_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "배송완료");
			pstmt.setString(2, purchaseNum);
			pstmt.executeUpdate();
			System.out.println("배송상태수정");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
}
