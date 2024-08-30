package J20240828;

public class employees {
	String empNum;
	String empName;
	int salary;
	double commissionPct;
	
	public employees() {
	}

	public employees(String empNum, String empName, int salary, double commissionPct) {
		this.empNum = empNum;
		this.empName = empName;
		this.salary = salary;
		this.commissionPct = commissionPct;
	}

	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setCommissionPct(double commissionPct) {
		this.commissionPct = commissionPct;
	}

	public String getEmpNum() {
		return empNum;
	}

	public String getEmpName() {
		return empName;
	}

	public int getSalary() {
		return salary;
	}

	public double getCommissionPct() {
		return commissionPct;
	}
	
	
	
	
	
}
