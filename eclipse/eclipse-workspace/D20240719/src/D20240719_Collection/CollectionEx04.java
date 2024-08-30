package D20240719_Collection;

import java.util.ArrayList;
import java.util.List;

public class CollectionEx04 {

	public static void main(String[] args) {
		int i [] = new int[2];
		Book b1 = new Book("태백산맥", "정지원");
		Book b2 = new Book("무궁화 꽃이 피었습니다","정지원");
		Book b[] = new Book[2];
		b[0] = new Book("태백산맥", "정지원");
		b[1] = new Book("무궁화 꽃이 피었습니다","정지원");
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		List<Book> list1 = new ArrayList<Book>();
		list1.add(new Book("태백산맥", "정지원"));
		list1.add(new Book("무궁화 꽃이 피었습니다","정지원"));
		b[0].getAuthor();
		list1.get(0).getAuthor();
		System.out.println(list1.get(0).getAuthor());
	}

}
