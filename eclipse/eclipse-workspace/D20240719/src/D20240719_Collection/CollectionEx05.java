package D20240719_Collection;

import java.util.ArrayList;
import java.util.List;

public class CollectionEx05 {

	public static void main(String[] args) {
		//선언
		List<Book> list = new ArrayList<Book>();
		//저장
		list.add(new Book("태백산맥","정지원"));
		list.add(new Book("무궁화 꽃이 피었습니다.","정지원"));
		//수정
		list.set(0, new Book("산우림","정지원"));
		//출력
		System.out.println(list.get(1).getBookName());
		String author = list.get(1).getAuthor();
		System.out.println(author);
		System.out.println(new Book("태백산맥","정지원").getAuthor());
		//모두 출력
		System.out.println(list);
		//크기
		System.out.println(list.size());
		//삭제
		list.remove(0);
		for(int i = 0; i< list.size(); i++) {
			if(list.get(i).getAuthor() == "정지원") {
				list.remove(i);break;
			}
		}
		//모두 삭제
		list.clear();
		//반복문
		for(Book b : list) {
			b.print();
		}
		
		
		
		
		
		
		
		
		
	}

}
