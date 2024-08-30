package D20240718_ArrayEx01;

import java.util.Scanner;

public class ArrayEx01 {
	public static void main(String[] args) {
		// 길이가 10인 배열을 선언, 1~10까지 반복문을 이용하여 저장하고 출력
		/*
		 * int i [] = new int[10]; for(int idx = 0; idx < i.length; idx++) { i[idx] =
		 * idx + 1; } for(int val : i) { System.out.println(val); }
		 */
		// 사용자에게 입력받은 양의 정수만큼 배열크기를 할당하고 1부터 입력받은 값까지 배열에 초기화한후 출력
		Scanner sc = new Scanner(System.in);
		/*
		 * int num = sc.nextInt(); int i [] = new int [num]; for(int j = 0; j <
		 * i.length; j++) { i[j] = j + 1; } for(int j : i) { System.out.println(j); }}
		 */
		// 길이가 5인 String 배열 선언
		/*
		 * String[] str = { "사과", "귤", "포도", "복숭아", "참외" }; for (String val : str) {
		 * System.out.println(val); if (val.equals("포도")) break;
		 */
		// 길이가 10인 배열을 선언하고 1부터 10까지의 값을 반복문/ 역순으로 배열 인덱스에 넣은후 그값을 출력
		/*
		 * int i [] = new int [10]; for(int j = 0, val = 10; j < 10; j++,val--) { i[j] =
		 * val; } for(int j : i) { System.out.println(j); }
		 */
		// 요일 월~일까지 초기화된 문자 배열을 만들고 0~6까지 숫자를 입력받아
		// 입력한 숫자와 같은 인덱스에 있는 요일을 출력하고 범위에 없는 숫자를 입력시 "잘못입력하셨습니다" 를 출력하라

		/*
		 * char week [] = {'월','화','수','목','금','토','일'}; int num = sc.nextInt();
		 * switch(num) { case 1 : System.out.println(week[0]);break; case 2 :
		 * System.out.println(week[1]);break; case 3 :
		 * System.out.println(week[2]);break; case 4 :
		 * System.out.println(week[3]);break; case 5 :
		 * System.out.println(week[4]);break; case 6 :
		 * System.out.println(week[5]);break; default :
		 * System.out.println("잘못 입력하셨습니다."); }
		 * 
		 * if(num >=0 && num <=6) { System.out.println(week[num]); }else {
		 * System.out.println("잘못 입력하셨습니다"); }
		 */
		// 사용자가 배열의 길이를 직접 입력하여 그 값만큼 정수형 배열을 선언 및 할당
		// 배열의 크기만큼 사용자가 직접 값을 입력하여 각각의 인덱스에 값을 초기화 하세요.
		// 그리고 배열 전체 값을 나열하고 각 인덱스에 저장된 값들의 합을 출력
		/*
		 * System.out.print("배열 크기 입력 : "); int num = sc.nextInt(); int i[] = new
		 * int[num]; int sum = 0;
		 * 
		 * for (int j = 0; j < i.length; j++) { System.out.print("정수 입력 : ");
		 * 
		 * i[j] = sc.nextInt(); sum = sum + i[j]; } System.out.print("출력 : ");
		 * 
		 * for(int val : i) { System.out.print(val+ " "); } System.out.println();
		 * System.out.println("합 : "+sum);
		 * 
		 */
		// "양념", "후라이드", "순살"인 문자열 배열에 사용자가 입력한 값이 배열에 있는지 검색하여
		// 있으면 "ㅇㅇㅇ 치킨 배달가능", 없으면 "ooo 치킨은 없는 메뉴입니다"를 출력하세요

		/*내가 푼거
		 * String ch[] = { "양념", "후라이드", "순살" };
		 * System.out.print("배달 시킬 치킨 양념, 후라이드, 순살 중에 입력해주세요 :"); String str =
		 * sc.nextLine(); switch (str) { case "양념": System.out.println(str + "치킨 배달가능");
		 * break; case "후라이드": System.out.println(str + "치킨 배달가능"); break; case "순살":
		 * System.out.println(str + "치킨 배달가능"); break; default: System.out.println(str +
		 * "치킨은 없는 메뉴입니다."); }
		 * -------------------------------------------- 다른 풀이
		 * // boolean isEx =false; for (int i = 0; i < ch.length; i++) {
		 * if(ch[i].equals(str)) { System.out.println(ch[i]+"치킨 배달가능"); isEx = true; } }
		 * if(isEx == false)System.out.println(str+"치킨은 없는 메뉴입니다");
		 */
	}

}
