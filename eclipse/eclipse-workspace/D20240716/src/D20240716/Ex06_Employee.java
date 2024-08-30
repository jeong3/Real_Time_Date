package D20240716;

public class Ex06_Employee {
	// 직원 번호 이름 주소 연락처
	String empNum;
	String empName;
	String empAddr;
	String empPhone;
	char empGender;
	
	public Ex06_Employee() {}
	public Ex06_Employee(String empAddr, String empPhone, char empGender) {
		this.empAddr = empAddr;
		this.empPhone = empPhone;
		this.empGender = empGender;
	}
	public Ex06_Employee(String empNum, String empName) {
		this("광명","010101", 'M');
		this.empNum = empNum;
		this.empName = empName;
	}

//	public Ex06_Employee(String empNum, String empName, String empAddr, String empPhone, char empGender) {
//		this.empNum = empNum;
//		this.empName = empName;
//		this.empAddr = empAddr;
//		this.empPhone = empPhone;
//		this.empGender = empGender;
//	}
	
	
}
