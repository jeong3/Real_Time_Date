package J20240828;

public class Wrapper {

	public static void main(String[] args) {
		int i = 0;
		long l = 0;
		float f = 0.0f;
		double d = 0.0;
		boolean b = false;
		char ch = 0;
		
		Integer i1 = null;
		Long li = null;
		Float f1 = null;
		Double d1 = null;
		Boolean b1 = null;
		Character ch1 = null;
		
		String str1 = "10";
		String str2 = "20";
		i = Integer.parseInt(str1) + Integer.parseInt(str2);
		str1 = "10.5";
		str2 = "20.5";
		d = Double.parseDouble(str1) + Double.parseDouble(str2);
		
		i1 = i; // boxing : Wrapper 자료형에서 정수형자료형으로 박싱
		i = i1; // unboxing : 정수형자료형에서 Wrapper자료형으로 언박싱 

	}

}
