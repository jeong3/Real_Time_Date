package D20240722_wrapper;

public class WrapperEx01 {

	public static void main(String[] args) {
		//리터널 자료형
		byte b;
		short sh;
		int i;
		long l;
		float f;
		double d;
		boolean bl;
		char ch;
		//Wrapper 자료형 // 포장
		Byte b1; //기본값 null
		Short sh1;
		Integer i1;
		Long l1;
		Float f1;
		Double d1;
		Boolean bl1;
		Character ch1;
		
		//Wrapper 자료형 사용이유 : null 값 처리 / 문자열을 리터널로 변환하기위해서
		
		String str = "10";
		i = Integer.parseInt(str);
		d = Double.parseDouble(str);
		
		

	}

}
