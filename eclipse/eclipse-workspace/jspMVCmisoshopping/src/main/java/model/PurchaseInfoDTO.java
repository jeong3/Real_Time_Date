package model;

public class PurchaseInfoDTO {
	//상품정보
	String goodsNum;
	String goodsImage;
	String goodsName;
	//주문정보
	Long purchaseNum;
	String purchaseStatus;
	Long purchasePrice;
	String memberNum;
	//결제정보
	String confirmNum;
	String applDate;
	//배송정보
	Long deliveryNum;
	String deliveryStatus;
	//후기정보
	int reviewNum;
	
	
	public int getReviewNum() {
		return reviewNum;
	}
	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}
	public Long getDeliveryNum() {
		return deliveryNum;
	}
	public void setDeliveryNum(Long deliveryNum) {
		this.deliveryNum = deliveryNum;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public void setPurchasePrice(Long purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public String getConfirmNum() {
		return confirmNum;
	}
	public void setConfirmNum(String confirmNum) {
		this.confirmNum = confirmNum;
	}
	public String getApplDate() {
		return applDate;
	}
	public void setApplDate(String applDate) {
		this.applDate = applDate;
	}
	public Long getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(long purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public String getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getGoodsImage() {
		return goodsImage;
	}
	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Long getPurchaseNum() {
		return purchaseNum;
	}
	public void setPurchaseNum(Long purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
	public String getPurchaseStatus() {
		return purchaseStatus;
	}
	public void setPurchaseStatus(String purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}
	public String getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
	}
	
	
}
