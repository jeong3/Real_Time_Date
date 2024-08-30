package D20240722_map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapEx01 {

	public static void main(String[] args) {
		// 선언
		//   key      value                 key     value
		Map<Integer, String> map = new HashMap<Integer, String>();
		// 저장
		map.put(1, "정지원1");// map.put(key,value);
		map.put(2, "정지원2");
		map.put(3, "정지원3");
		map.put(4, "정지원4");
		// 수정 : 저장과 마찬가지로 map.put(key,value);로 수정할 value의 키를 입력 후 저장할 value를 입력
		map.put(4, "정지원04");
		map.replace(4, "정지원4");
		// 출력 : System.out.println(map.get(key));
		System.out.println(map.get(1));
		// 키값 가져오기
		for(Integer key : map.keySet()) {
			System.out.print(key);
			System.out.println(map.get(key));
		}
		// 모든 키 가져오기
		System.out.println("------");
		Collection<String> val = (Collection<String>)map.values();
		System.out.println("val : "+ val);
		// 크기
		System.out.println(map.size());
		// 삭제
		map.remove(1);
		map.remove(2, "정지원2");// key 값과 value 값이 일치하지않으면 지워지지 않음
		System.out.println(map);
		// 모두삭제
		map.clear();
		System.out.println(map.size());
		
		
		
		
	}

}
