package J20240828;



public class Ex09 {

	public static void main(String[] args) {
		Inquire inquire = new Inquire();
		inquire.setInqNum(1);
		System.out.println(inquire.getInqNum());

		Inquire inquire1 = new Inquire(1,"제목","배송","답변");
		Inquire inquire2 = new Inquire(1,"제목2","상품","답변2");
		Inquire inquire3 = new Inquire(1,"제목3","금액","답변3");
		
		Inquire inq [] = new Inquire[] {inquire1,inquire2,inquire3};
		
		for(Inquire i : inq) {
			System.out.println(i);
		}
	}

}
