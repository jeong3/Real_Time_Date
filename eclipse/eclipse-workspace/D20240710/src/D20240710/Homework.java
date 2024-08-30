package D20240710;

public class Homework {

	public static void main(String[] args) {
//		0. 반복이 10번 수행이 되는 동안 "이쓰앰님을 전적으로 믿으셔야합니다."를 출력하시오.
		for (int i = 1; i <= 10; i++) {
			System.out.println("이쓰앰님을 전적으로 믿으셔야합니다.");
		}
		System.out.println("-----------------------------");
//		1. for문에 있는 변수 i가 초기값 10을 가지고 있으며 10회를 반복할 때 변수 i를 2씩 증가시킨후 더한 값 출력되도록 하시오.
		for (int i = 10; i <= 19; i += 2) {
			System.out.println(i);
		}
		System.out.println("-----------------------------");
//		2. for문에 있는 변수 i가 초기값 20을 가지고 있으며 10회를 반복할 때 변수 i를 2씩 감시킨 후 더한 값 출력되도록 하시오.
		for (int i = 20; i >= 11; i -= 2) {
			System.out.println(i);
		}
		System.out.println("-----------------------------");
//		3. 구구단 6단 중 홀수 곱만 출력하시오.
		for (int gop = 1; gop <= 9; gop++) {
			if (gop % 2 != 0)
				System.out.println("6 x " + gop + " = " + 6 * gop);
		}
		System.out.println("-----------------------------");
//		4.  for문을 이용해서 구구단 7단을 출력하되 홀수만을 출력하고 for문안에 있는 변수는 반복하는 용도로만 사용한다. 
		int i = 1;
		for (int gop = 1; gop <= 9; gop++) {
			if (i % 2 != 0)
				System.out.println("7 x " + i + " = " + 7 * i);
			i++;
		}
		System.out.println("-----------------------------");
//		5. 구구단 6단 중 홀수 곱만 출력할 때 continue이용할 것
		for (int gop = 1; gop <= 9; gop++) {
			if (gop % 2 == 0)
				continue;
			System.out.println("6 x " + gop + " = " + 6 * gop);
		}
		System.out.println("-----------------------------");
//		6. int rnd = (int)(Math.random() * 9)+1;을 이용하여 1부터 rnd만큼 구구단의 8단을 출력하시오.
		int rnd = (int) (Math.random() * 9) + 1;
		System.out.println("마지막 수 : " + rnd);
		for (int gop = 1; gop <= rnd; gop++) {
			System.out.println("8 x " + gop + " = " + 8 * gop);
		}
		System.out.println("-----------------------------");
//		7. 각각의 변수가 아래와 같을 때 
//		    int x = 1;
//		     int z = 10;
//		     int g = 4;
//		x는 초기값 z는 반복의 조건이고 g는 증가값으로 반복문을 만드시오
		int x = 1;
		int z = 10;
		int g = 4;
		for (; x < z; x += g) {
			System.out.println(x);
		}
		System.out.println("-----------------------------");
//		8. 아래와 같이 출력되게 하세요.
//		6단 시작
//		6 * 4= 24
//		6 * 5= 30
//		6 * 6= 36
//		6단 끝
//		7단 시작
//		7 * 4= 28
//		7 * 5= 35
//		7 * 6= 42
//		7단 끝
		int startDan = 6;
		int lastDan = 7;
		int startGop = 4;
		int lastGop = 6;
		for (int dan = startDan; dan <= lastDan; dan++) {
			System.out.println(dan + "단 시작");
			for (int gop = startGop; gop <= lastGop; gop++) {
				System.out.println(dan+" x " + gop + " = " + dan * gop);
			}
			System.out.println(dan + "단 끝");
		}
		System.out.println("-----------------------------");
//		9. 아래와 같이 출력되게 하시오.
//		6단 시작
//		6 * 4= 24         6 * 5= 30         6 * 6= 36
//		6단 끝
//		7단 시작
//		7 * 4= 28         7 * 5= 35         7 * 6= 42
//		7단 끝
		for (int dan = startDan; dan <= lastDan; dan++) {
			System.out.println(dan + "단 시작");
			for (int gop = startGop; gop <= lastGop; gop++) {
				System.out.print(dan+" x " + gop + " = " + dan * gop+"     ");
			}
			System.out.println("");
			System.out.println(dan + "단 끝");
		}
		System.out.println("-----------------------------");
//		10. 반복문을 사용하여 아래 와 같이 출력결과가 나오게 하세요.
//		<table border='1'>
//		<tr><td> 1 </td><td> 2 </td><td> 3 </td><td> 4 </td></tr>
//		<tr><td> 1 </td><td> 2 </td><td> 3 </td><td> 4 </td></tr>
//		<tr><td> 1 </td><td> 2 </td><td> 3 </td><td> 4 </td></tr>
//		<tr><td> 1 </td><td> 2 </td><td> 3 </td><td> 4 </td></tr>
//		</table>
		System.out.println("<table border='1'>");
		int startnum = 1;
		int lastnum = 4;
		for(int tr = startnum; tr <= lastnum; tr++) {
			System.out.print("<tr>");
			for(int y = startnum; y <= lastnum; y++) {
				System.out.print("<td> "+ y +" </td>");
			}
			System.out.print("</tr>");
			System.out.println("");
		}
		System.out.println("</table>");
		System.out.println("-----------------------------");
//		11. int rnd1 = (int)(Math.random() * 45)+1;코드를 사용해서 rnd1값을 6개씩 5번출력되게 하세요.
//		단, 중복값 허용
		for(i = 1; i <= 5; i++) {
			for(int y = 1; y <= 6; y++) {
				int rnd1 = (int)(Math.random() * 45)+1;
				System.out.print(rnd1);
				System.out.print(" ");
			}
			System.out.println("");
		}
		System.out.println("-----------------------------");
//		12. 6단을 출력할 때 3곱부터 8곱까지만 출력하시오.
		int startGop_6 = 3;
		int lastGop_6 = 8;
		for(i = startGop_6; i <= lastGop_6; i++) {
			System.out.println("6 x "+ i +" = "+ 6 * i);
		}
		System.out.println("-----------------------------");
//		13. 1부터 45중 랜덤수 6개만 가지고 오시오 (복원 추출, 중복 허용)
		
		for(i = 1; i <= 6; i++) {
			int rnd2 = (int)(Math.random() * 45)+1;
			System.out.print(rnd2);
			System.out.print(" ");
		}
		System.out.println("");
		System.out.println("-----------------------------");
//		14. i는 1부터 15까지 1씩 증가하여야 하며 y는 1000 부터 10씩 감소 할때만 
//		    이 때 "자바는 나의 사랑"이라는 문구가 출력되도록 하시오.
		int y = 1000;
		for(i = 1, y = 1000; i <= 15 && y > 0; i++ ,y -= 10) {
			System.out.println("자바는 나의 사랑");
		}

	}

}
