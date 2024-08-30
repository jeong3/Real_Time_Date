package D20240722;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx02 {

	public static void main(String[] args) {
		// 선언
		List<String> list = new ArrayList<String>();
		// 저장
		list.add("정지원0");
		list.add("정지원1");
		list.add("정지원2");
		list.add("정지원3");
		list.add("정지원4");
		// 출력
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println(list.get(4));
		// 수정
		list.set(3, "정지원03");
		System.out.println(list.get(3));
		// 크기
		System.out.println(list.size());
		// 삭제
		list.remove(0);
		list.remove("정지원1");
		// pop : 값을 반환받으면서 삭제 / index 로 가능
		String pop = list.remove(0);
		System.out.println(pop);
		// 모두 출력
		System.out.println(list);
		for(String s : list) {
			System.out.println(s);
		}
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		// 문자열 변환
		String result = list.toString();
		System.out.println(result);
		// 모두 삭제
		list.clear();
		System.out.println(list);
		
		
		
		
		
		
		
		
		
		
		

	}

}
