package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO extends DataBaseInfo {

	public void wishItem(String memberNum, String goodsNum) {
		con = getConnection();
		sql = "merge into wish w";
		sql += " using ( select goods_num from goods where goods_num = ? ) g";
		sql += " on ( w.goods_num = g.goods_num and member_num = ? )";
		sql += " when matched then ";
		sql += " update set wish_date = sysdate";
		sql += " delete where member_num = ? and goods_num = ?";
		sql += " when not matched then ";
		sql += " insert (member_num, goods_num, wish_date)";
		sql += " values (?, ?, sysdate)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			pstmt.setString(2, memberNum);
			pstmt.setString(3, memberNum);
			pstmt.setString(4, goodsNum);
			pstmt.setString(5, memberNum);
			pstmt.setString(6, goodsNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 관심 등록");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public int wishSelectOne(String memberNum, String goodsNum) {
		con = getConnection();
		sql = "select 'a' from wish where member_num = ? and goods_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberNum);
			pstmt.setString(2, goodsNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return 1;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;

	}

	public void cartMerge(CartDTO dto) {
		con = getConnection();
		sql = "merge into cart c " + " using (select goods_num from goods where goods_num = ?) g "
				+ " on (c.goods_num = g.goods_num and member_num = ?)" + " when matched then"
				+ " update set cart_qty = cart_qty + ?" + " when not matched then "
				+ " insert (member_num, goods_num, cart_date, cart_qty)" + " values ( ?, ?, sysdate, ?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.goodsNum);
			pstmt.setString(2, dto.memberNum);
			pstmt.setInt(3, dto.cartQty);
			pstmt.setString(4, dto.memberNum);
			pstmt.setString(5, dto.goodsNum);
			pstmt.setInt(6, dto.cartQty);
			pstmt.executeUpdate();
			System.out.println("장바구니에 담았습니다");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public List<CartListDTO> cartSelectList(String memberNum) {
		List<CartListDTO> list = new ArrayList<CartListDTO>();
		con = getConnection();
		sql = " select g.goods_num, goods_name, goods_price, goods_main_store_image "
				+ ", member_num, cart_date, cart_qty " 
				+ ", goods_price*cart_qty as total_price "
				+ " from goods g join cart c " 
				+ " on g.goods_num = c.goods_num " 
				+ " where member_num = ? "
				+ " order by g.goods_num desc ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberNum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CartListDTO dto = new CartListDTO();
				dto.setGoodsNum(rs.getString(1));
				dto.setGoodsName(rs.getString(2));
				dto.setGoodsPrice(rs.getInt(3));
				dto.setGoodsImage(rs.getString(4));
				dto.setMemberNum(rs.getString(5));
				dto.setCartDate(rs.getDate(6));
				dto.setCartQty(rs.getInt(7));
				dto.setTotalPrice(rs.getInt(8));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	public void itemQtyDownUpdate(String goodsNum, String memberNum) {
		con = getConnection();
		sql = "update cart " + " set cart_qty = cart_qty - 1" + " where member_num = ? and goods_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberNum);
			pstmt.setString(2, goodsNum);
			pstmt.executeUpdate();
			System.out.println("장바구니 1개 삭제");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public void itemDelete(String goodsNums, String memberNum) {
		con = getConnection();
		sql = "delete from cart where goods_num= ? and member_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNums);
			pstmt.setString(2, memberNum);
			pstmt.executeUpdate();
			System.out.println("장바구니 상품 1개 삭제");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public CartListDTO itemSelectOne(String goodsNum, String memberNum) {
		CartListDTO dto = new CartListDTO();
		con = getConnection();
		sql = " select g.goods_num, goods_name, goods_price, goods_main_store_image "
				+ ", member_num, cart_date, cart_qty " + ", goods_price*cart_qty as total_price "
				+ " from goods g join cart c " + " on g.goods_num = c.goods_num "
				+ " where member_num = ? and g.goods_num = ? " + " order by g.goods_num desc ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberNum);
			pstmt.setString(2, goodsNum);
			rs = pstmt.executeQuery();
			rs.next();
			dto.setGoodsNum(rs.getString(1));
			dto.setGoodsName(rs.getString(2));
			dto.setGoodsPrice(rs.getInt(3));
			dto.setGoodsImage(rs.getString(4));
			dto.setMemberNum(rs.getString(5));
			dto.setCartDate(rs.getDate(6));
			dto.setCartQty(rs.getInt(7));
			dto.setTotalPrice(rs.getInt(8));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}

	public void purchaseInsert(PurchaseDTO dto) {
		con = getConnection();
		sql = "insert into purchase ( PURCHASE_NUM, PURCHASE_DATE, PURCHASE_PRICE, DELIVERY_ADDR, DELIVERY_ADDR_DETAIL, DELIVERY_POST, DELIVERY_PHONE, MESSAGE, PURCHASE_STATUS, MEMBER_NUM, DELIVERY_NAME, PURCHASE_NAME)"
				+ " values (?,sysdate,?,?,?,?,?,?,'결제 대기중',?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getPurchaseNum());
			pstmt.setLong(2, dto.getPurchasePrice());
			pstmt.setString(3, dto.getDeliveryAddr());
			pstmt.setString(4, dto.getDeliveryAddrDetail());
			pstmt.setString(5, dto.getDeliveryPost());
			pstmt.setString(6, dto.getDeliveryPhone());
			pstmt.setString(7, dto.getMessage());
			pstmt.setString(8, dto.getMemberNum());
			pstmt.setString(9, dto.getDeliveryName());
			pstmt.setString(10, dto.getPurchaseName());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 행 삽입");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public void purchaseListInsert(String purchaseNum, String goodsNum, String memberNum) {
		con = getConnection();
		sql = "insert into purchase_list(goods_num, PURCHASE_NUM, PURCHASE_QTY, GOODS_UNIT_PRICE)"
				+ " select ?, ?, cart_qty, cart_qty * goods_price" + " from cart c join goods g"
				+ " on c.goods_num = g.goods_num" + " where g.goods_num = ? and member_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			pstmt.setString(2, purchaseNum);
			pstmt.setString(3, goodsNum);
			pstmt.setString(4, memberNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 삽입");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public List<PurchaseInfoDTO> purchaseItemSelect(String memberNum) {
		List<PurchaseInfoDTO> list = new ArrayList<PurchaseInfoDTO>();
		con = getConnection();
		sql = "select g.goods_num , goods_name , goods_main_store_image";
		sql += ",p.purchase_num, purchase_status, purchase_price, member_num ";
		sql += ", APPLDATE, CONFIRMNUMBER ";
		sql += ", delivery_num , delivery_status";
		sql += ", review_num";
		sql += " from goods g join purchase_list pl";
		sql += " on g.goods_num = pl.goods_num join purchase p";
		sql += " on pl.purchase_Num = p.purchase_Num left outer join payment pm";
		sql += " on pm.purchase_num = p.purchase_num left outer join delivery d";
		sql += " on d.purchase_num = p.purchase_num left outer join reviews r";
		sql += " on r.purchase_num = pl.purchase_num and r.goods_num = pl.goods_num";
		
		if (memberNum != null)
			sql += " where member_num = ?" ;
		
		sql += " order by p.purchase_num desc";
		try {
			pstmt = con.prepareStatement(sql);
			if(memberNum != null) pstmt.setString(1, memberNum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				PurchaseInfoDTO dto = new PurchaseInfoDTO();
				dto.setGoodsNum(rs.getString(1));
				dto.setGoodsName(rs.getString(2));
				dto.setGoodsImage(rs.getString(3));
				dto.setPurchaseNum(rs.getLong(4));
				dto.setPurchaseStatus(rs.getString(5));
				dto.setPurchasePrice(rs.getLong(6));
				dto.setMemberNum(rs.getString(7));
				dto.setApplDate(rs.getString(8));
				dto.setConfirmNum(rs.getString("CONFIRMNUMBER"));
				dto.setDeliveryNum(rs.getLong(10));
				dto.setDeliveryStatus(rs.getString(11));
				dto.setReviewNum(rs.getInt(12));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public void paymentInsert(PaymentDTO dto) {
		con = getConnection();
		sql = "insert into payment(purchase_num, confirmNumber, cardNum, TID, totalPrice, "
				+ " resultMassage, payMathod, applDate, appTime) " + " values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getPurchaseNum());
			pstmt.setString(2, dto.getConfirmNumber());
			pstmt.setString(3, dto.getCardNum());
			pstmt.setString(4, dto.getTid());
			pstmt.setString(5, dto.getTotalPrice());
			pstmt.setString(6, dto.getResultMessage());
			pstmt.setString(7, dto.getPayMethod());
			pstmt.setString(8, dto.getApplDate());
			pstmt.setString(9, dto.getApplTime());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행이 삽입되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public PurchaseDTO purchaseSelectOne(String purchaseNum) {
		PurchaseDTO dto = null;
		con = getConnection();
		sql = "select purchase_price, delivery_name, delivery_phone, purchase_name, member_num  from purchase where purchase_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, purchaseNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new PurchaseDTO();
				dto.setPurchasePrice(rs.getLong(1));
				dto.setDeliveryName(rs.getString(2));
				dto.setDeliveryPhone(rs.getString(3));
				dto.setPurchaseName(rs.getString(4));
				dto.setMemberNum(rs.getString(5));

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}

	public void paymentDelete(String purchaseNum) {
		con = getConnection();
		sql = "delete from payment where purchase_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, purchaseNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행이 삭제되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void purchaseStatusUpdate(String purchaseNum) {
		con = getConnection();
		sql = "update purchase set purchase_status = ? where purchase_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "구매확정");
			pstmt.setString(2, purchaseNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 구매확정");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
}
