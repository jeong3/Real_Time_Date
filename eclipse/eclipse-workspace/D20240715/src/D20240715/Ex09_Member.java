package D20240715;

//회원 가입
public class Ex09_Member {
	// 번호 이름 아이디 비번 연락처 주소 성별 -> 변수 , 생성자 , setter , getter , print
	int num;
	String name;
	String id;
	String pw;
	String addr;
	char gender;

	public Ex09_Member() {
	}

	public Ex09_Member(int num, String name, String id, String pw, String addr, char gender) {
		this.num = num;
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.addr = addr;
		this.gender = gender;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getAddr() {
		return addr;
	}

	public char getGender() {
		return gender;
	}
	
	public void print() {
		System.out.println(num);
		System.out.println(name);
		System.out.println(id);
		System.out.println(pw);
		System.out.println(addr);
		System.out.println(gender);
	}

}
