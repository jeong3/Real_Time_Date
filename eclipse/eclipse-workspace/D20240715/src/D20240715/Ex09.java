package D20240715;

import java.util.Scanner;

public class Ex09 {

	public static void main(String[] args) {
		// 3명의 회원정보를 입력 ,  2명은 생성자를 이용해서 초기화 , 1명은 기본생성자를 이용해서 객체 생성
		Scanner sc = new Scanner(System.in);
		int num;
		String name;
		String id;
		String pw;
		String addr;
		char gender;
		System.out.println("회원1의 정보 입력하세요");
		num =  sc.nextInt();
		sc.nextLine();
		name = sc.nextLine();
		id = sc.nextLine();
		pw= sc.nextLine();
		addr= sc.nextLine();
		gender= sc.next().charAt(0);
		
		Ex09_Member mem = new Ex09_Member(num, name, id, pw, addr, gender);
		System.out.println("회원2의 정보 입력하세요");
		num =  sc.nextInt();
		sc.nextLine();
		name = sc.nextLine();
		id = sc.nextLine();
		pw= sc.nextLine();
		addr= sc.nextLine();
		gender= sc.next().charAt(0);
		Ex09_Member mem2 = new Ex09_Member(num, name, id, pw, addr, gender);
		System.out.println("회원3의 정보 입력하세요");
		num =  sc.nextInt();
		sc.nextLine();
		name = sc.nextLine();
		id = sc.nextLine();
		pw= sc.nextLine();
		addr= sc.nextLine();
		gender= sc.next().charAt(0);
		Ex09_Member mem3 = new Ex09_Member();
		
		mem3.setNum(num); 
		mem3.setName(name);
		mem3.setId(id);
		mem3.setPw(pw);
		mem3.setAddr(addr);
		mem3.setGender(gender);
		mem.print();
		mem2.print();
		System.out.println(mem3.getNum());
		System.out.println(mem3.getName());
		System.out.println(mem3.getId());
		System.out.println(mem3.getPw());
		System.out.println(mem3.getAddr());
		System.out.println(mem3.getGender());

	}

}
