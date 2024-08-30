package D20240719_Collection;

import java.util.ArrayList;
import java.util.List;

public class CollectionEx02 {

	public static void main(String[] args) {
		// 선언
		//  <type> : 제네릭 타입
		List<String> list = new ArrayList<String>();
		// 저장
		list.add("정지원1");
		list.add("정지원2");
		list.add("정지원3");
		list.add("정지원4");
		// 수정
		list.set(2, "정지원03");
		// 출력
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		// 모두 출력
		System.out.println(list);
		// 크기 확인
		System.out.println(list.size());
		// 삭제
		list.remove(3);// 인덱스로 삭제
		list.remove("정지원1");// 오브젝트로 삭제
		String str1 = list.remove(0); // 인덱스 0인 list를 삭제하면서 출력할 수 있다.
		System.out.println(str1);
		
		
		
		
		// 모두 삭제
		//list.clear();
		// 문자열로 변환
		String str = list.toString();
		System.out.println(str); // [] 대괄호까지 문자열로 변환
		// 반복문으로 출력
		for(int i = 0; i <list.size(); i++) {
			System.out.println(list.get(i));
		}
		for(String s : list) {
			System.out.println(s);
		}
		
		
		
		
	}

}
