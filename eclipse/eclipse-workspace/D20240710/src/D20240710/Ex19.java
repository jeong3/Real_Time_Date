package D20240710;

public class Ex19 {

	public static void main(String[] args) {
		//5단부터 8단까지 출력 => 이중 while문
		int dan = 5;
		while(dan <= 8) {
			int gop = 1;
			while(gop <= 9) {
				System.out.println(dan+ " x " +gop+ " = " + dan * gop);
				gop++;
			}
			dan++;
		}
		
		dan = 5; //초기화
		while(dan <= 8) {
			for(int gop = 1; gop <= 9; gop++) {
				System.out.println(dan+ " x " +gop+ " = " + dan * gop);
			}
			dan++;
		}
		

	}

}
