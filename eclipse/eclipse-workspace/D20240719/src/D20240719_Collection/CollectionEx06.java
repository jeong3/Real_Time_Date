package D20240719_Collection;

import java.util.ArrayList;
import java.util.List;

public class CollectionEx06 {

	public static void main(String[] args) {
		Object obj = 10; //Object타입은 타입 상관없이 값을 저장할 수 있다.
		System.out.println(obj);
		obj = "정지원";
		System.out.println(obj);
		obj = new Book("ㅁㅁㅁ","정지원");
		System.out.println(((Book)obj).getAuthor());// 객체 출력은 형변환을 시켜줘야한다.
		List<Object> list = new ArrayList<Object>();
		list.add(10);
		list.add("정지원1");
		list.add(new Book("ㅁㅁㅁㅁㅁㅁㅁㅁ","정지원12312312312"));
		System.out.println(((Book)list.get(2)).getAuthor()); 
		List list1 = new ArrayList();
		list1.add(10);
		list1.add("정지원1");
		list1.add(new Book("ㅁㅁㅁㅁㅁㅁㅁㅁ","정지원1231235465465412312"));
		System.out.println(((Book)list1.get(2)).getAuthor());
		

	}

}
