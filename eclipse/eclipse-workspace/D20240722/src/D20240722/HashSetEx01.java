package D20240722;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx01 {

	public static void main(String[] args) {
		// set : 집합(중복이 없음), index 가 없다(순서가 없음)
		// 		 중복 데이터를 허용하지 않는다.
		// 선언
		Set<String> set = new HashSet<String>();
		// 저장
		set.add("정지원0");
		set.add("정지원0");
		set.add("정지원1");
		set.add("정지원2");
		set.add("정지원3");
		set.add("정지원4");
		// 모두 출력 for each (for 문은 인덱스가 없기 때문에 사용할 수 없다.)
		System.out.println(set);
		for(String s : set) {
			System.out.println(s);
		}
		// 크기
		System.out.println(set.size());
		// 문자열 변환
		String str = set.toString();
		// 데이터 유무
		System.out.println(set.contains("정지원0"));
		// 삭제
		set.remove("정지원0");
		System.out.println(set);
		// 모두 삭제
		set.clear();
		System.out.println(set);

	}

}
