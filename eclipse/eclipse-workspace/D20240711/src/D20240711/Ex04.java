package D20240711;

public class Ex04 {

	public static void main(String[] args) {
		String [] str = {"정지원","정유진","정여진"};
		String str1 [] = new String[] {"정지원","정유진","정여진"};
		for(String s : str1) {
			System.out.println(s);
		}
		System.out.println(str1.length);
		str1[0] = "김모씨";
		str1[1] = "이모씨";
		str1[2] = "정모씨";
	 // str1[3] = "황모씨"; //크기를 넘을 수 없음
		// 배열의 장점 : 하나 이상의 값을 저장할 수 있다.
		// 배열의 단점 : 크기를 변경할 수 없다. 하나의 타입만 저장 가능하다.
		String str2 [] = new String[3];
		for(String s : str2) {
			System.out.println(s); // 문자열은 기본값이 null이 된다.
			//null : 값은 있되 어떠한 값인지 모른다.
		}
		str2[0] = "강감찬";
		str2[1] = "이순신";
		str2[2] = "안중근";
		for(String s : str2) {
			System.out.println(s);
		}
		
		System.out.println("크기 : " + str2.length);
	  //str2[3] = "정지원"; // 크기를 넘어서 오류
		
	}

}
