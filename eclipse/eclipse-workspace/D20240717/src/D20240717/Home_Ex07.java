package D20240717;

public class Home_Ex07 {
//	7. 상품입고 : 입고번호:ipgoNum, 상품번호:goodsNum, 입고수량:ipgoQty, 입고일:ipgoDate
//    상품제조일:madeDate, 입고금액:ipgoPrice, 상품금액:goodsPrice
	String ipgoNum;
	int goodsNum;
	int ipgoQty;
	String ipgoDate;
	String madeDate;
	int ipgoPrice;
	int goodsPrice;
	public Home_Ex07(String ipgoNum, int goodsNum, int ipgoQty, String ipgoDate, String madeDate, int ipgoPrice,
			int goodsPrice) {
		super();
		this.ipgoNum = ipgoNum;
		this.goodsNum = goodsNum;
		this.ipgoQty = ipgoQty;
		this.ipgoDate = ipgoDate;
		this.madeDate = madeDate;
		this.ipgoPrice = ipgoPrice;
		this.goodsPrice = goodsPrice;
	}
	public String getIpgoNum() {
		return ipgoNum;
	}
	public void setIpgoNum(String ipgoNum) {
		this.ipgoNum = ipgoNum;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public int getIpgoQty() {
		return ipgoQty;
	}
	public void setIpgoQty(int ipgoQty) {
		this.ipgoQty = ipgoQty;
	}
	public String getIpgoDate() {
		return ipgoDate;
	}
	public void setIpgoDate(String ipgoDate) {
		this.ipgoDate = ipgoDate;
	}
	public String getMadeDate() {
		return madeDate;
	}
	public void setMadeDate(String madeDate) {
		this.madeDate = madeDate;
	}
	public int getIpgoPrice() {
		return ipgoPrice;
	}
	public void setIpgoPrice(int ipgoPrice) {
		this.ipgoPrice = ipgoPrice;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	
}
