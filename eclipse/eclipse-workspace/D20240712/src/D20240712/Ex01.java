package D20240712;

import java.util.Arrays;

public class Ex01 {

	public static void main(String[] args) {
//		1. 정수 배열을 만들었을 때 초기값은?
//				   실수 배열을 만들엇을 때 초기값은?
//				   부울 배열을 만들었을 때 초기값은?
//				   문자열 배열을 만들었을 때 초기값은?
//				   문자 배열을 만들었을 때 초기값은?
		
//				2. 1차원배열을 선언하는 4가지 방법에 대해서 나열하시오.
		int [] i0 = {1,2,3};
		int [] i1 = new int [] {1,2,3};
		int [] i2 = new int [3];
		int [] i3;
//				3. int [] dan8 = new int[9]을 이용해서 8단을 저장하고 foreach를 이용해서 출력하시오.
		int [] dan8 = new int[9];
		for (int idx = 0; idx < dan8.length; idx++ ) {
			dan8[idx] = 8 * (idx+1);
		}
		for(int val : dan8) {
			System.out.print(val + "\t");
		}
		System.out.println();
//				4.  위 예제에서 4번요소와 8번요소를 더한값을 출력하시오.
		System.out.println(dan8[4]+dan8[8]);
//				5. char [] alphabets = new char[52];
//				   char ch ='A';
//				   을 이용해서 alphabets배열에 문자를 A~Zz~a가지 저장하시오. 
		 char[] alphabets = new char[52];
	        char ch = 'A';
	        for (int i = 0; i < 52; i++) {
	        	if(i < 26)alphabets[i] = ch++;
	        	if(i == 26) ch = 'z';
	        	if(i >= 26)alphabets[i] = ch--;
	        }
	        for(char val : alphabets) {
	        	System.out.println(val);
	        }
//				6. 구구단을 다음 배열에 저장하시오.
//				int [][] array = new int[8][9];// 2 부터 구구단을 저장할 2차원 배열
	        
//				7. 구구단을 다음과 같이 출력하시오
//				2단 : [2,4,6,8,10,12,14,16,18]
//				3단 : [3,6,9,12,15,18,21,24,27]
//				4단 : [4,8,12,16,20,24,28,32,36]
//				5단 : 
//				6단 : 
//				7단 :
//				8단 :
//				9단 : 
	        int [][] array = new int[8][9];
	        for(int dan = 2; dan <= 9; dan++) {
	        	for(int gop = 1; gop <= 9; gop++) {
	        		array[dan-2][gop-1] = dan * gop;
	        	}
	        }
	        int d = 2;
	        for(int z[] : array) {
	        	System.out.print(d++ + "단 : ");
	        	System.out.println(Arrays.toString(z));
	        }
//				8. 가변 2차원 배열을 이용해서
//				첫번째 행은 5단에서 1 ~ 3까지의 곱을 저장
//				두번재 행은 6단에서 1 ~ 6까지의 곱을 저장
//				세번째 행은 7단에서 1 ~ 9까지의 곱을 저장
	        int array2 [][] = new int[3][];
	        array2[0] = new int[3];
	        array2[1] = new int[6];
	        array2[2] = new int[9];
	        for(int rowidx = 0; rowidx < array2.length; rowidx++) {
	        	for(int colidx = 0; colidx < array2[rowidx].length; colidx++) {
	        		array2[rowidx][colidx] = (rowidx + 5) * (colidx + 1);
	        	}
	        }
	        for(int [] dan1 : array2 ) {
	        	System.out.println(Arrays.toString(dan1));
	        }
//				9. 주어진 배열에서 최대값을 구하시오.
//				int max = 0;
//				int [] array = {1,5,3,8,2};
//
//				System.out.println("max : " + max);
			int a = 10;
			int b = 20;
			int temp = b;
			b = a;
			a = temp;
	        int max = 0;
			int [] array3 = {1,5,3,8,2};
			max = array3[0];
			for(int idx = 0; idx < array3.length; idx++) {
				if(array3[idx] > max) max = array3[idx];
			}
			System.out.println("max : " + max);
//				10. 주어진 배열에 있는 요소들의 합과 평균을 구하시오.
//				int [][] array = {{95,86},{83,92,96},{78,83,93,87,88}}
//				int sum = 0;
//				double avg = 0.0;

//				System.out.println("sum : " + sum);
//				System.out.println("avg : " + avg);
			int [][] array4 = {{95,86},{83,92,96},{78,83,93,87,88}};
			int sum = 0;
			int count = 0;
			double avg = 0.0;
			for(int rowidx = 0; rowidx < array4.length; rowidx++) {
				for(int colidx = 0; colidx < array4[rowidx].length; colidx++) {
					sum += array4[rowidx][colidx];
					count++;
				}
			}
			avg = (double)sum / count;
			
			System.out.println("sum : " + sum);
			System.out.println("avg : " + avg);


	}

}
