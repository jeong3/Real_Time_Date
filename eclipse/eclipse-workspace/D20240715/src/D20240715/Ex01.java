package D20240715;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		// 변수 : 하나만 저장 가능, 정해진 타입만 저장 가능
//		2장 변수와 타입
//		1. 변수에 대해 잘못 설명한 것은 무엇입니까?
//		➊ 변수는 하나의 값만 저장할 수 있다.
//		➋ 변수는 선언 시에 사용한 타입의 값만 저장할 수 있다.
//		➌ 변수는 변수가 선언된 중괄호 { } 안에서만 사용 가능하다.
//		➍ 변수는 초기값이 저장되지 않은 상태에서 읽을 수 있다
//		답 : 4
//		2. 다음 표의 빈 칸에 자바의 기본 타입 8개를 적어보세요.
//		        크기  1byte 	2byte 	4byte 8byte
//		타입 
//		정수타입    (1)       (2)     (3)     (4) 
//		실수타입                      (5)      (6)
//		논리타입    (7)
//		문자타입             (8) 
//		
//		3. 다음 코드에서 타입, 변수 이름, 리터럴에 해당하는 것을 적어보세요
//		int age;
//		age = 10;
//		double price = 3.14;
//
//		타입       : 
//		변수 이름: 
//		리터럴    : 
//
//		4. 다음 자동 타입 변환에서 컴파일 에러가 발생하는 것을 선택하세요.
//		byte byteValue = 10;
//		char charValue = 'A';
//		➊ int intValue = byteValue;
//		➋ int intValue = charValue;
//		➌ short shortValue = charValue;
//		➍ double doubleValue = byteValue;
//		short사인드 < char언사인드 답 3번 
//		5. 다음 강제 타입 변환에서 컴파일 에러가 발생하는 것을 선택하세요.
//		int intValue = 10;
//		char charValue = 'A';
//		double doubleValue = 5.7;
//		String strValue = "A";
//		➊ double var = (double) intValue;
//		➋ byte var = (byte) intValue;
//		➌ int var = (int) doubleValue;
//		➍ char var = (char) strValue;
//		문자열은 문자로 쪼갤수없다 4번
//		6. 연산식의 타입 변환 중에서 컴파일 에러가 발생하는 것을 선택하세요
//		byte byteValue = 10;
//		float floatValue = 2.5F;
//		double doubleValue = 2.5;
//		➊ byte result = byteValue + byteValue;
//		➋ int result = 5 + byteValue;
//		➌ float result = 5 + floatValue;
//		➍ double result = 5 + doubleValue;
//		
//		1번 : byte끼리 더하는 것이 1byte의 최댓값을 넘어설 수 있기 때문에 성립되지 않는다. 
//
//		3장 연산자.
//		7. 534자루의 연필을 30명의 학생들에게 똑같은 개수로 나누어 줄 때 1인당 몇 개를 가질 수 있고,
//		마지막에 몇 개가 남는지를 구하는 코드입니다.
//		int pencils = 534;
//		int students = 30;
//		//학생 한 명이 가지는 연필 수
//		int pencilsPerStudent = ( 코드 작성 );
//		System.out.println(pencilsPerStudent);
//		//남은 연필 수
//		int pencilsLeft = ( 코드 작성 );
//		System.out.println(pencilsLeft);
//
//		pencils /  students ,   pencils % students
//
//		4장 제어문
//		4-1. 조건문
//		8. Scanner를 이용해서 홍길동이라는 학생의 수학, 영어, 국어 점수를 입력한 후 각 과목의 점수가 40점 이상이고 평균이 60점 이상이면 합격 아니면 불합격이라고 출력되게 하시오.
//		예시) 홍길동은 불합격입니다.
//		Scanner sc = new Scanner(System.in);
//		System.out.print("이름 입력 : ");
//		String name = sc.nextLine();
//		System.out.print("수학 점수 입력 : ");
//		int mat = sc.nextInt();
//		System.out.print("국어 점수 입력 : ");
//		int kor = sc.nextInt();
//		System.out.print("영어 점수 입력 : ");
//		int eng = sc.nextInt();
//		if(kor >=40 && eng >=40 && mat>=40 && (kor+eng+mat)/3 >= 60) {
//			System.out.print(name+"은 합격 입니다.");
//		}else {
//			System.out.print(name+"은 불합격 입니다.");
//		}
//
//		9.  Scanner를 통해 1부터 4까지의 값을 입력받아 아래 예제가 입력받은 숫자에 따라 덧셈, 뺄셈, 곱셈, 나눗셈이 되도록 하시오.(switch 사용)
//		int num1 = 10;
//		int num2 = 20;
//		Scanner sc = new Scanner(System.in);
//		System.out.println("1.더하기 | 2.빼기 | 3.곱하기 | 4.나누기");
//		System.out.print("1부터 4사이의 값을 하세요 : ");
//		int i = sc.nextInt();
//		switch(i) {
//		case 1 -> System.out.println(num1 + num2); 
//		case 2 -> System.out.println(num1 - num2); 
//		case 3 -> System.out.println(num1 * num2); 
//		case 4 -> System.out.println(num1 / num2); 
//		default -> System.out.println("1~4까지만 입력하세요");
//		} // -> 는 break;를 입력한 것과 같다

//		

//		
//		10. 8세 미만은  "미 취학 아동입니다." , 입장료가 1000 
//		    14세 미만은 "초등학생 입니다." , 입장료가 2000
//		     20세 미만은 "중, 고등학생 입니다." 입장료 2500
//		    이상은 "일반인 입니다." , 입장료 3000원이 출력되게 다음코드를 완성하시오. if문 사용
//		    int age = 12;
//		    int charge = 1000;

//		11. 위 예제를 switch문으로 작성하시오.
//
//		12.  12월 1월 2월은 "겨울입니다."
//		      3월 4월 5월은 "봄입니다."
//		      6월 7월 8월은 "여름입니다."
//		      9월 10월 11월은 "가을입니다."
//		     이외의 숫자는 "날짜가 잘못되었습니다."가 되도록 if문으로 코드를 작성하시오.
//
//		13. 위 예제를 switch문으로 작성하시오,
//
//
//		14.  Scanner를 통해서 전화의 지역번호를 city에 입력하고 02를 입력했다면 "서울입니다"가 출력되고 031을 입력하면 "경기도입니다"를 출력, 
//		    032을 입력하면 "인천광역시입니다"를 출력, 041을 입력하면 "충청남도입니다"를 출력, 051을 입력하면 "부산광역시입니다"를 출력하고 
//		    나머지는 "프로그램 종료"가 출력하는 코드를  작성하시오.

//		Scanner sc = new Scanner(System.in);
//	    sc.nextLine();
//	    System.out.print("번호 입력 : ");
//		String city = sc.nextLine();
//		switch(city){
//		case "02" -> System.out.println("서울입니다");
//		case "031" -> System.out.println("경기도입니다");
//		case "032" -> System.out.println("인천광역시입니다");
//		case "041" -> System.out.println("충청남도입니다");
//		case "051" -> System.out.println("부산광역시입니다");
//		default -> System.out.println("프로그램 종료"); 
//		// "->"를 사용하면 break;가 필요없는 마지막 case에도 "->"를 사용해야한다
//		} //0이 시작이면 문자로 판별한다.
//
//		 
//
//		4-2. 반복문
//		15. 1부터 100까지의 수 중 짝수의 값만 합하시오.
//
//		16.  4단부터 6단까지 실행 될 때 곱은 5곱부터 8곱까지만 출력되게 하시오.
//
//		17.  for 문을 이용해서 다음과 같은 실행 결과가 나오는 코드를 작성해보세요.
//		*
//		**
//		***
//		****
//		*****
//		for(int i = 1; i <= 5; i++) {
//			for(int j = 1; j <= i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		18. while 문과 Scanner.nextInt() 메소드를 이용해서 다음 실행 결과와 같이 키보드로부터
//		입력된 데이터로 예금, 출금, 조회, 종료 기능을 제공하는 코드를 작성해보세요.
//		예금이면 balance에 입력한 값이 더하고 출금이면  balance의 값을 입력한 만큼 빼야한다. 잔고는  balance에 있는 값을 출력하면 된다.
//		----------------------------------
//		1.예금 | 2.출금 | 3.잔고 | 4.종료
//		----------------------------------
//		선택> 1
//		예금액>10000
//		----------------------------------
//		1.예금 | 2.출금 | 3.잔고 | 4.종료
//		----------------------------------
//		선택> 2
//		출금액>2000
//		----------------------------------
//		1.예금 | 2.출금 | 3.잔고 | 4.종료
//		----------------------------------
//		선택> 3
//		잔고>8000
//		----------------------------------
//		1.예금 | 2.출금 | 3.잔고 | 4.종료
//		----------------------------------
//		선택> 4
//		프로그램 종료
//		boolean run = true;
//		int balance = 0;
//		Scanner scanner = new Scanner(System.in);
//		while (run) { // run이 false일 때가지 무한루프
//			System.out.println("-------------------------------------");
//			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
//			System.out.println("-------------------------------------");
//			System.out.print("선택> ");
//			int menuNum = scanner.nextInt();
//			switch (menuNum) {
//			case 1 -> {
//				System.out.print("예금액> ");
//				balance += scanner.nextInt();
//			}
//			case 2 -> {
//				System.out.print("출금액> ");
//				balance -= scanner.nextInt();
//			}
//			case 3 -> {
//				System.out.print("잔고> ");
//				System.out.println(balance);
//			}
//			case 4 -> {
//				run = false;
//				System.out.println("프로그램 종료");
//			}
//			}
//		}
//

//

//
//		5. 배열
//		19. 길이가 10인 배열을 선언하고 1부터 10까지의 값을 반복문을 이용하여 순서대로 배열 인덱스에 넣은 후 그 값을 출력하세요.(반복 변수는 0부터 시작)
//		ex : 1 2 3 4 5 6 7 8 9 10
//		int [] arr = new int[10];
//		for(int i = 0; i <arr.length; i ++) {
//			arr[i] = i + 1;
//		}
//		for(int val : arr) {
//			System.out.println(val);
//		}
//		String str = "정지원";
//		System.out.println(str.length()); //배열이 아닐 때의 크기를 구할 때는 length() 이다.
//
//		20. 길이가 10인 배열을 선언하고 1부터 10까지의 값을 반복문을 이용하여 역순으로 배열 인덱스에 넣은 후 그 값을 출력하세요.(반복 변수는 0부터 시작)
//		ex : 10 9 8 7 6 5 4 3 2 1
//
//		int [] arr = new int[10];
//		int num = arr.length;
//		for(int i = 0; i <arr.length; i ++) {
//			arr[i] = num--;
//		}
//		for(int val : arr) {
//		System.out.println(val);
//		}
//
//		21. 다음 배열의 크기만큼  반복문을 사용하지 말고 배열의 요소에 임의의 값을 입력하고 배열의 크기를 출력하시오.
//		    (배열 i1과 i2 모두 반복문 사용하지 말고 입력하고 크기를 출력)
//		int [] i1 = new int[6];
//
//		int len = 6;
//		int [] i2 = new int[len]; 
//
//
//
//
//		22. 사용자에게 입력 받은 양의 정수만큼 배열 크기를 할당하고 1부터 입력 받은 값까지 배열에 초기화한 후 출력하세요.
//		예시)
//		양의 정수 : 5
//		1 2 3 4 5
//
//		Scanner sc = new Scanner(System.in);
//		System.out.print("양의 정수 : ");
//		int num = sc.nextInt();
//
//
//		23. 2차원 배열의 크기와 1차원 배열의 크기를 출력하시오.
//		int[][] array = {{95, 86}, {83, 92, 96}, {78, 83, 93, 87, 88}};
//
//		24. 다음 같은 실행이 되도록 코드를 작성 하시오. 
//		double height[] = new double[4];
//
//		예시)
//		몸무게를 입력하시오 : 45.5
//		몸무게를 입력하시오 : 27.3
//		몸무게를 입력하시오 : 12.6
//		몸무게를 입력하시오 : 65.4
//		최대값=65.40
//		최소값=12.60
//		합=150.80
//		평균=37.70
//
//		double weight[] = new double[4];
//		Scanner sc = new Scanner(System.in);
//		for (int i = 0; i < 4; i++) {
//			System.out.print("몸무게 입력 : ");
//			weight[i] = sc.nextDouble();
//		}
//		double max = weight[0];
//		double min = weight[0];
//		double sum = 0;
//		for(int i = 0; i < weight.length; i++) {
//			if(max < weight[i]) max = weight[i];
//			if(min > weight[i]) min = weight[i];
//			sum += weight[i];
//		}
//		double svg = sum / weight.length;
//		System.out.println(max);
//		System.out.println(min);
//		System.out.println(sum);
//		System.out.println(svg);
//
//
//		25. 학생들의 점수를 분석하는 프로그램을 만들려고 합니다. 키보드로부터 학생 수와 각 학생들의 점
//		수를 입력받고 while 문과 Scanner의 nextInt() 메소드를 이용해서 최고 점수 및 평균 점수를
//		출력하는 코드를 작성해보세요.
//		boolean run = true;
//		int studentNum = 0;   // 배열크기
//		int[] scores = null;
//		Scanner sc = new Scanner(System.in);
//		while(run) {
//		 	System.out.println("--------------------------------------------------------------");
//		 	System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
//		 	System.out.println("--------------------------------------------------------------");
//		 	System.out.print("선택> ");
//		 	int selectNo = sc.nextInt();
//			switch(selectNo) {
//			case 1: System.out.println("학생 수 입력 :");
//				studentNum = sc.nextInt();
//				scores = new int[studentNum]; break;
//			
//			case 2: for(int idx = 0; idx < studentNum; idx++) {
//				System.out.println("scores["+idx+"] >");
//				scores[idx] = sc.nextInt();
//			}break;
//			case 3: int idx = 0; 
//			for(int val : scores) {
//				System.out.println("scores["+idx+++"] >" + val); 
//			}break;
//			case 4: int max = 0; int sum = 0; 
//			for(int val : scores) { 
//				if(max < val) max = val; 
//				sum += val;
//			}
//			double avg = sum/studentNum;
//				System.out.println(max);
//				System.out.println(sum);
//				System.out.println(avg); break;
//			case 5 : run = false; System.out.print("종료");
//			}
//			
//		}
//
//		------------------------------------------------------
//		1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료
//		------------------------------------------------------
//		선택> 1
//		학생수> 3
//		------------------------------------------------------
//		1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료
//		------------------------------------------------------
//		선택> 2
//		scores[0]> 85
//		scores[1]> 95
//		scores[2]> 93
//		------------------------------------------------------
//		1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료
//		------------------------------------------------------
//		선택> 3
//		scores[0]: 85
//		scores[1]: 95
//		scores[2]: 93
//		------------------------------------------------------
//		1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료
//		------------------------------------------------------
//		선택> 4
//		최고 점수: 95
//		평균 점수: 91.0
//		------------------------------------------------------
//		1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료
//		------------------------------------------------------
//		선택> 5
//		프로그램 종료

	}

}
