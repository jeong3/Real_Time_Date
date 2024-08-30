package D20240719_approach;

public class MyData {
	 // private는 상속이 되지 않는다. 이외는 모두 상속이 가능하다
	private int day;
	protected int month;
	int year; // default
	// 접근할 수 없는 멤버(private)를 사용하기 위해서 메서드를 만들어서 사용
	public void setDay(int day) {
		this.day = day;
	}
	public int getDay() {
		return day;
	}
	
	
	
	
	
}
