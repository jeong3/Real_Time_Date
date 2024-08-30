package D20240710;

public class Ex20 {

	public static void main(String[] args) {
		int gop = 1;
		while (true) { //while문은 true를 주고 원하는 조건에서 break;를 사용하여 멈춤
			System.out.println("5 x "+gop+" = " + 5*gop);
			gop++;
			if(gop == 10) break;
		}
		//홀수 곱만 출력
		gop = 1;
		while (gop <= 9) {
			if(gop % 2 != 0)
			System.out.println("5 x "+gop+" = " + 5*gop);
			gop++;
		}
		gop = 0;
		while (gop <= 9) {
			gop++;
			if(gop % 2 == 0)continue;//continue; 위로 다시 돌아가서 실행 : 증감식이 continue보다 위로
			System.out.println("5 x "+gop+" = " + 5*gop);
			
		}

	}

}
