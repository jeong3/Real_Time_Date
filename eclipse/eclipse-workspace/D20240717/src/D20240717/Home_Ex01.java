package D20240717;

public class Home_Ex01 {
//	1. 5명의 고객을 저장해야 한다. 고객정보는 회원번호:memberNum, 회원이름: memberName,
//	회원주소:memberAddr, 회원연락처:memberPhone, 회원생년월일:memberBirth , 회원성별:memberGender이다,
//	객체를 생성한 후 5명의 회원 정보를 임의로 입력하시오.
	String memberNum;
	String memberName;
	String memberAddr;
	String memberPhone;
	String memberBirth;
	char memberGender;
	
	public Home_Ex01() {}
	public Home_Ex01(String memberNum, String memberName, String memberAddr, String memberPhone, String memberBirth, char memberGender) {
		this.memberNum = memberNum;
		this.memberName = memberName;
		this.memberAddr = memberAddr;
		this.memberPhone = memberPhone;
		this.memberBirth = memberBirth;
		this.memberGender = memberGender;
	}
	
}
