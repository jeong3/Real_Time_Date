package D20240716;

public class Ex05 {

	public static void main(String[] args) {
		Ex05_Employee emp = new Ex05_Employee("123", "정지원");
		System.out.println(emp.empNum);
		System.out.println(emp.empName);
		System.out.println(emp.empAddr);
		System.out.println(emp.empPhone);
		System.out.println(emp.empGender);
		Ex05_Employee emp1 = new Ex05_Employee("서울","0101010",'F');
		System.out.println(emp1.empNum);
		System.out.println(emp1.empName);
		System.out.println(emp1.empAddr);
		System.out.println(emp1.empPhone);
		System.out.println(emp1.empGender);
	}

}
