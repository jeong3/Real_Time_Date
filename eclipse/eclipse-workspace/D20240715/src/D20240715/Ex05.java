package D20240715;

public class Ex05 {

	public static void main(String[] args) {
		Ex05_Board board = new Ex05_Board();
		board.setData(1, "제목1", "내용1", "정지원");
		
		board.print();
		
		Ex05_Board board1 = new Ex05_Board();
		board1.setData(2, "재목2", "내용2", "정지원");
		board1.print();
		//board1.subject = "제목2"; //은닉 : private 접근 지정자를 사용해서 이렇게 사용할 수 없도록 만든다.
		board1.setSubject("제목2");
		board1.print();
	
		int num = board1.getNum(); //호출 메서드
		System.out.println(board1.getNum());
	}

}
