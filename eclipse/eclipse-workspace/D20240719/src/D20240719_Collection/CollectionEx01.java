package D20240719_Collection;

import java.util.ArrayList;
import java.util.List;

public class CollectionEx01 {

	public static void main(String[] args) {
		// 변수 단점 : 하나의 값만 저장
		// 배열 장점 : 하나이상의 값을 저장
		// 배열 단점 : 하나의 타입만 저장, 크기를 변경할 수 없다. 
		// Collection 장점 : 크기가 유동적이다.
		// Collection 단점 : 하나의 타입만 저장가능
		//list , set
		List<String> list = new ArrayList<String>();
		// 리스트는 크기가 정해져 있지 않기 때문에 얼마든지 저장할 수 있다.
		list.add("정지원");
		list.add("정지원1");
		list.add("정지원2");
		list.add("정지원2"); // 중복가능
		
		System.out.println(list.size()); // 현재 리스트에 저장된 크기
		for(String val : list) {
			System.out.println(val);
		}
		System.out.println(list.get(0));// 배열의 인덱스와 같다 str[0]
		list.remove(0);
		list.remove(0);
		System.out.println();
		System.out.println(list.get(0));
		list.remove("정지원2"); // 중복된 것을 지울 때는 하나만 삭제 된다.
		System.out.println(list.size());
		
		list.clear();
		System.out.println(list.size());
		
		
		
		
		
		
	}

}
