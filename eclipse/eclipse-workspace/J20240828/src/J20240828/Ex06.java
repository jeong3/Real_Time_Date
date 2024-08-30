package J20240828;

public class Ex06 {

	public static void main(String[] args) {
		Board board1 = new Board(10,"제목","내용",0);
		board1.setBoardContent("내용2");
		System.out.println(board1.getBoardContent());
		

	}

}
