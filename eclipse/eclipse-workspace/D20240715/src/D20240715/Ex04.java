package D20240715;

public class Ex04 {

	public static void main(String[] args) {
		Ex04_Board board = new Ex04_Board();
		board.setData(1, "제목", "내용", "정지원");
		
		board.print();
		Ex04_Board board1 = new Ex04_Board();
		board1.setData(1, "제목", "내용", "정지원");
		board1.print();
		board1.setSubject("제목1");
		board1.print();
		board1.subject = "제목2";
		board1.print();
	}

}
