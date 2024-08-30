package D20240717;

public class Home_Ex04 {
	// setter/getter , 생성자
			// 객체생성시 생성자를 이용하고 생성한 후 setter를 이용해서 멤버값을 변경하고 getter를 이용해서 맴버값을 출력
//			4. 결제정보를 저장하고 싶다. 결제정보는 승인번호:purchaseNum, 카드번호:cardnum, 결제금액:totalPrice
//			                                    결제일 : appldate , 결제시간:appltime
	String purchaseNum;
	String cardNum;
	int totalPrice;
	String appldate;
	String appltime;
	public Home_Ex04(String purchaseNum, String cardNum, int totalPrice, String appldate, String appltime) {
		this.purchaseNum = purchaseNum;
		this.cardNum = cardNum;
		this.totalPrice = totalPrice;
		this.appldate = appldate;
		this.appltime = appltime;
	}
	
	public void setPurchaseNum(String purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void setAppldate(String appldate) {
		this.appldate = appldate;
	}
	public void setAppltime(String appltime) {
		this.appltime = appltime;
	}
	
	
	public String getPurchaseNum() {
		return purchaseNum;
	}
	public String getCardNum() {
		return cardNum;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public String getAppldate() {
		return appldate;
	}
	public String getAppltime() {
		return appltime;
	}
	
	
}
