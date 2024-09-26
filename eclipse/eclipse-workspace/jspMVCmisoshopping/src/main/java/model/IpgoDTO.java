package model;

import java.util.Date;

public class IpgoDTO {
	String goodsNum;
	String ipgoNum;
	int ipgoQty;
	Date ipgoDate;
	Date madeDate;
	int ipgoPrice;
	String empNum;
	
	public String getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getIpgoNum() {
		return ipgoNum;
	}
	public void setIpgoNum(String ipgoNum) {
		this.ipgoNum = ipgoNum;
	}
	public int getIpgoQty() {
		return ipgoQty;
	}
	public void setIpgoQty(int ipgoQty) {
		this.ipgoQty = ipgoQty;
	}
	public Date getIpgoDate() {
		return ipgoDate;
	}
	public void setIpgoDate(Date ipgoDate) {
		this.ipgoDate = ipgoDate;
	}
	public Date getMadeDate() {
		return madeDate;
	}
	public void setMadeDate(Date madeDate) {
		this.madeDate = madeDate;
	}
	public int getIpgoPrice() {
		return ipgoPrice;
	}
	public void setIpgoPrice(int ipgoPrice) {
		this.ipgoPrice = ipgoPrice;
	}
	public String getEmpNum() {
		return empNum;
	}
	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}
	
	
}
