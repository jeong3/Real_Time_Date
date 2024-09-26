package model;

import java.util.Date;

public class GoodsDTO {
	String goodsNum;
	String goodsName;
	String goodsContents;
	String goodsMainImage;
	String goodsMainStoreImage;
	String goodsDetailImage;
	String goodsDetailStoreImage;
	String empNum;
	String updateEmpNum;
	int goodsPrice;
	int visitCount;
	Date goodsRegist;
	Date goodsUpdateDate;
	
	public String getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsContents() {
		return goodsContents;
	}
	public void setGoodsContents(String goodsContents) {
		this.goodsContents = goodsContents;
	}
	public String getGoodsMainImage() {
		return goodsMainImage;
	}
	public void setGoodsMainImage(String goodsMainImage) {
		this.goodsMainImage = goodsMainImage;
	}
	public String getGoodsMainStoreImage() {
		return goodsMainStoreImage;
	}
	public void setGoodsMainStoreImage(String goodsMainStoreImage) {
		this.goodsMainStoreImage = goodsMainStoreImage;
	}
	public String getGoodsDetailImage() {
		return goodsDetailImage;
	}
	public void setGoodsDetailImage(String goodsDetailImage) {
		this.goodsDetailImage = goodsDetailImage;
	}
	public String getGoodsDetailStoreImage() {
		return goodsDetailStoreImage;
	}
	public void setGoodsDetailStoreImage(String goodsDetailStoreImage) {
		this.goodsDetailStoreImage = goodsDetailStoreImage;
	}
	public String getEmpNum() {
		return empNum;
	}
	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}
	public String getUpdateEmpNum() {
		return updateEmpNum;
	}
	public void setUpdateEmpNum(String updateEmpNum) {
		this.updateEmpNum = updateEmpNum;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public int getVisitCount() {
		return visitCount;
	}
	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}
	public Date getGoodsRegist() {
		return goodsRegist;
	}
	public void setGoodsRegist(Date goodsRegist) {
		this.goodsRegist = goodsRegist;
	}
	public Date getGoodsUpdateDate() {
		return goodsUpdateDate;
	}
	public void setGoodsUpdateDate(Date goodsUpdateDate) {
		this.goodsUpdateDate = goodsUpdateDate;
	}
	
	
}
