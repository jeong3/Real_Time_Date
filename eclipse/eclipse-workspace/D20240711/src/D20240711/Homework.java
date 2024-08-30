package D20240711;

public class Homework {

	public static void main(String[] args) {
//		1. 정수 배열을 만들었을 때 초기값은?
//				   실수 배열을 만들엇을 때 초기값은?
//				   부울 배열을 만들었을 때 초기값은?
//				   문자열 배열을 만들었을 때 초기값은?
//				   문자를 배열을 만들었을 때 초기값은?
		int i9[] = new int[1];
		System.out.println(i9[0]);
		double d[] = new double[1];
		System.out.println(d[0]);
		boolean bl[] = new boolean[1];
		System.out.println(bl[0]);
		String str[] = new String[1];
		System.out.println(str[0]);
		char ch1[] = new char[1];
		System.out.println(ch1[0]);
		System.out.println("-----------------------------");
//				2. 1차원배열을 선언하는 4가지 방법에 대해서 나열하시오.
		System.out.println("int i1[] = new int[3];\r\n"
				+ "int i2[] = { 0, 1, 2 };\r\n"
				+ "int i3[] = new int[] { 0, 1, 2 };\r\n"
				+ "int i4[];");

		System.out.println("-----------------------------");
//				3. int [] dan8 = new int[9]을 이용해서 8단을 저장하고 foreach를 이용해서 출력하시오.
		int[] dan8 = new int[9];
		for (int idx = 0; idx < dan8.length; idx++) {
			dan8[idx] = 8 * (idx + 1);
		}
		int num = 0;
		for (int i : dan8) {
			num++;
			System.out.println("8 x "+num+" = "+i);
		}
		System.out.println("-----------------------------");
//				4.  위 예제에서 4번요소와 8번요소를 더한값을 출력하시오.
		System.out.println(dan8[4] + dan8[8]);
		System.out.println("-----------------------------");
//				5. char [] alphabets = new char[52];
//				   char ch ='A';
//				   을 이용해서 alphabets배열에 문자를 A~Zz~a가지 저장하시오. 
		
	        char[] alphabets = new char[52];
	        char ch = 'A';
	        for (int i = 0; i < 52; i++) {
	            if (i < 26) {
	                alphabets[i] = ch;
	                ch++;
	            } else if (i == 26) {
	            	ch = 'z';
	            	alphabets[i] = ch;
	            } else {
	                ch--;
	                alphabets[i] = ch;
	            }
	            System.out.println(alphabets[i]);
	        }

	    
		
//				6. 구구단을 다음 배열에 저장하시오.
//				int [][] array = new int[8][9];// 2 부터 구구단을 저장할 2차원 배열
		int [][] array = new int[8][9];
		for(int row = 0; row < array.length; row++ ) {
			for(int col = 0; col < array[row].length; col++) {
				System.out.println((row+2)+" x "+(col+1)+" = "+(row+2)*(col+1));
			}
		}
//				7. 구구단을 다음과 같이 출력하시오
//				2단 : [2,4,6,8,10,12,14,16,18]
//				3단 : [3,6,9,12,15,18,21,24,27]
//				4단 : [4,8,12,16,20,24,28,32,36]
//				5단 : 
//				6단 : 
//				7단 :
//				8단 :
//				9단 : 
//		System.out.print("단");
		for(int row = 0; row < array.length; row++ ) {
			System.out.print(row+2+"단 : [");
			
			for(int col = 0; col < array[row].length; col++) {
				System.out.print((row+2)*(col+1)+", ");
				if((col+1) != 9) {
                    System.out.print((row+2)*(col+1)+" ,");
                }else {
                    System.out.print((row+2)*(col+1));
                }
			}
			System.out.println("]");
		}
//				8. 가변 2차원 배열을 이용해서
//				첫번째 행은 5단에서 1 ~ 3까지의 곱을 저장
//				두번재 행은 6단에서 1 ~ 6까지의 곱을 저장
//				세번째 행은 7단에서 1 ~ 9까지의 곱을 저장
		int [][] dan = new int [3][];
		int [] dan5 = new int [3];
		int [] dan6 = new int [6];
		int [] dan7 = new int [9];
		
		for (int row=0; row < dan5.length; row++) {
			dan5[row] = (row+1)*5;
			System.out.print(dan5[row]+" ");
		}
		System.out.println("");
		for (int row=0; row < dan6.length; row++) {
			dan6[row] = (row+1)*6;
			System.out.print(dan6[row]+" ");
		}
		System.out.println("");
		for (int row=0; row < dan7.length; row++) {
			dan7[row] = (row+1)*7;
			System.out.print(dan7[row]+" ");
		}
		System.out.println("");
//				9. 주어진 배열에서 최대값을 구하시오.
//				int max = 0;
//				int [] array = {1,5,3,8,2};
//
//				System.out.println("max : " + max);
		int max = 0;
		int [] array1 = {1,5,3,8,2};
		
		for(int x : array1) {
			if(x > max) {
				max = x;	
			}
		}
		System.out.println("max : " + max);
		
//
//				10. 주어진 배열에 있는 요소들의 합과 평균을 구하시오.
//				int [][] array = {{95,86},{83,92,96},{78,83,93,87,88}}
//				int sum = 0;
//				double avg = 0.0;
//
//		System.out.println("sum : " + sum);
//		System.out.println("avg : " + avg);
		int [][] array3 = {{95,86},{83,92,96},{78,83,93,87,88}};
		int sum = 0;
		double avg = 0.0;
		int a = 0;
		for(int i = 0; i < array3.length; i++) {
			a += array3[i].length;
			for(int y = 0; y <array3[i].length; y++) {
				sum += array3[i][y];
			}
		}
		avg = (double)sum / a;
		System.out.println("sum : " + sum);
		System.out.println("avg : " + avg);
	}

}
