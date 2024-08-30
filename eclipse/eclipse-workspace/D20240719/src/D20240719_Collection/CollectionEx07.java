package D20240719_Collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CollectionEx07 {

	public static void main(String[] args) {
		// Set : 집합
		// 1. 순서가 없다 =>하나씩 수정, 출력이 불가능하다.
		// 2. 중복을 허용하지 않는다.
		Set<String> set = new HashSet<String>();
		// 저장
		set.add("정지원");
		set.add("정지원1");
		set.add("정지원2");
		set.add("정지원3");
		//출력
		for(String s : set) { 
			System.out.println(s);
		}
		// 문자열 변환
		System.out.println(set.toString());
		// 데이터 유무
		// 집합 안에 내가 찾을 데이터를 검색
		System.out.println(set.contains("정지원")); 
		// 삭제
		set.remove("정지원"); // 순서가 없기에 오브젝트로만 삭제 가능
		// 모두 삭제
		set.clear();
		
		
		
		

	}

}
