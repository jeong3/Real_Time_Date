package D20240722;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx01 {

	public static void main(String[] args) {
		// 컬렉션 : 하나 이상의 값을 저장
		// 크기가 유동적 : list(ArrayList), set
		// list 선언
		List <Integer> list = new ArrayList<Integer>();
		// 저장
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		// 수정
		list.set(0, 20);
		// 출력
		System.out.println(list.get(0));
		// 전체 출력
		System.out.println(list);
		// 크기
		System.out.println(list.size());
		// 삭제
		list.remove(0);
		// list.remove(30); // 정수는 오브젝트 삭제가 되지 않는다.
		// 값을 받아오면서 삭제
		int pop = list.remove(0); // index를 사용 (오브젝트 X)
		System.out.println(pop);
		System.out.println(list);
		
		// 모두 삭제
		list.clear();
		System.out.println(list);
		
		
	}

}
