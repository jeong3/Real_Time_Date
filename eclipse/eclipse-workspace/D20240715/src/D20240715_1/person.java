package D20240715_1;

public class person {
	String name; // 은닉
	String phone;
	String addr;
	int age;
	double height;
	boolean gender;
	//저장 메서드
	public void setData(String name, String phone, String addr, int age, double height, boolean gender) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
		this.age = age;
		this.height = height;
		this.gender = gender;
	}
	//출력 메서드
	public void print() {
		System.out.println(name);
		System.out.println(phone);
		System.out.println(addr);
		System.out.println(age);
		System.out.println(height);
		System.out.println(gender);
	}
	//setter
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	//getter
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddr() {
		return addr;
	}
	public int getAge() {
		return age;
	}
	public double getheight() {
		return height;
	}
	public boolean isGender() { //bool타입은 get이 아닌 is로 쓴다.
		return gender;
	}
	
}