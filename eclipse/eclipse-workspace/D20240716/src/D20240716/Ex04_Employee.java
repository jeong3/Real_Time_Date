package D20240716;

public class Ex04_Employee {
	// 직원 번호 이름 주소 연락처
	String empNum;
	String empName;
	String empAddr;
	String empPhone;
	char empGender;

	public Ex04_Employee() {
	}

	public Ex04_Employee(String empNum, String empName) {
//		this.empNum = empNum;
//		this.empName = empName;
		setData(empNum, empName, "광명", "010~", 'M');
	}

	// 오버로딩일 때(같은 생성자가 두 개 이상일 때) 매개변수가 같은 타입에 같은 개수면 안된다.
	// 적어도 같은 개수에 타입이 다르거나, 같은 타입에 개수가 달라야 한다.
	public Ex04_Employee(String empAddr, String empPhone, char empGender) {
		setData("321", "정지원1", empAddr, empPhone, empGender);
	}

	public Ex04_Employee(String empNum, String empName, String empAddr, String empPhone, char empGender) {
		this.empNum = empNum;
		this.empName = empName;
		this.empAddr = empAddr;
		this.empPhone = empPhone;
		this.empGender = empGender;
	}
	public void setData(String empNum, String empName, String empAddr, String empPhone, char empGender) {
		this.empNum = empNum;
		this.empName = empName;
		this.empAddr = empAddr;
		this.empPhone = empPhone;
		this.empGender = empGender;
	}
	

}
