package D20240716;

public class Ex12_Student {
	int id;
	String name;
	int grade;
	String address;
	
	public Ex12_Student() {}
	public Ex12_Student(int id, String name, int grade, String address) {
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.address = address;
	}
	public void print() {
		System.out.println(id);
		System.out.println(name);
		System.out.println(grade);
		System.out.println(address);
	}
}
