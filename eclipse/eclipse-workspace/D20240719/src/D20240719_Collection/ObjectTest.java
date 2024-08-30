package D20240719_Collection;

public class ObjectTest {

	public static void main(String[] args) {
		Book book = new Book("산울림", "정지원");
		book.getAuthor();
		// 일회성
		new Book("산울림", "정지원").getAuthor();
	}

}
