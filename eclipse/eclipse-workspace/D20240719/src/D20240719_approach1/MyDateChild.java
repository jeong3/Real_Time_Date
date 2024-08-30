package D20240719_approach1;

import D20240719_approach.MyData;

public class MyDateChild extends MyData{
	// prodected 멤버는 다른 패키지에도 상속이 가능하다.
	public void setMonth(int month) {
		this.month = month;
	}
	// default 멤버는 다른패키지에선 상속이 불가하다.
	public void setYear(int year) {
		//this.year = year;
	}
	
	
	
	
}
