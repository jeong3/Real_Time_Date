package D20240709;

public class Ex17 {

	public static void main(String[] args) {
		//A 90-100 B 80-89 C 70-79 D 60-69 E 50-59 F 50미만
		int score = 74;
		if(score >= 90) {
			System.out.println("A");
		} else {
			if(score >= 80) {
				System.out.println("B");
			} else {
				if(score >= 70) {
					System.out.println("C");
				} else {
					if(score >= 60) {
						System.out.println("D");
					} else {
						if(score >= 50) {
							System.out.println("E");
						} else {
							System.out.println("F");
						}
					}
				}
			}
		}

	}

}
