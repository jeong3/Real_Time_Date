package D20240717;

public class Homework {

	public static void main(String[] args) {
//	1. 5명의 고객을 저장해야 한다. 고객정보는 회원번호:memberNum, 회원이름: memberName,
//	회원주소:memberAddr, 회원연락처:memberPhone, 회원생년월일:memberBirth , 회원성별:memberGender이다,
//	객체를 생성한 후 5명의 회원 정보를 입의로 입력하시오.
		Home_Ex01 ex[] = new Home_Ex01[5];
		ex[0] = new Home_Ex01("001", "정지원0", "광명", "0100000", "010120", 'M');
		ex[1] = new Home_Ex01("001", "정지원1", "광명", "0100000", "010120", 'M');
		ex[2] = new Home_Ex01("001", "정지원2", "광명", "0100000", "010120", 'M');
		ex[3] = new Home_Ex01("001", "정지원3", "광명", "0100000", "010120", 'M');
		ex[4] = new Home_Ex01("001", "정지원4", "광명", "0100000", "010120", 'M');
//		2. 5개의 상품 정보를 입력해야 한다. 상품정보는 상품번호:goodsNum, 상품명:goodsName, 상품가격:goodsPrice, 상품상세정보: goodsContent이다.
//		  객체를 생성한 후 5개의 상품정보를 입의로 입력하시오.
		Home_Ex02 ex2[] = new Home_Ex02[5];
		ex2[0] = new Home_Ex02("001", "상품명0", 10000, "상품정보0");
		ex2[1] = new Home_Ex02("001", "상품명0", 10000, "상품정보0");
		ex2[2] = new Home_Ex02("001", "상품명0", 10000, "상품정보0");
		ex2[3] = new Home_Ex02("001", "상품명0", 10000, "상품정보0");
		ex2[4] = new Home_Ex02("001", "상품명0", 10000, "상품정보0");
//		3. 투표를 진행하기 위해 후보자들의 정보를 입력하여야한다. 후보자 정보는 후보자번호:candidateNum, 후보자 이름:candidateName,  투표수: vote
//		   후보자3명과 투표수를 임의로 입력하세요.
		Home_Ex03 ex3[] = new Home_Ex03[3];
		ex3[0] = new Home_Ex03(1, "정", 35);
		ex3[1] = new Home_Ex03(2, "지", 56);
		ex3[2] = new Home_Ex03(3, "원", 15);

		// setter/getter , 생성자
		// 객체생성시 생성자를 이용하고 생성한 후 setter를 이용해서 멤버값을 변경하고 getter를 이용해서 맴버값을 출력
//		4. 결제정보를 저장하고 싶다. 결제정보는 승인번호:purchaseNum, 카드번호:cardnum, 결제금액:totalPrice
//		                                    결제일 : appldate , 결제시간:appltime
		Home_Ex04 ex04 = new Home_Ex04("0000", "0000-0000-0000", 0, "0000-00-00", "00:00");
		ex04.setPurchaseNum("1234");
		ex04.setCardNum("0123-1234-5678");
		ex04.setTotalPrice(10000);
		ex04.setAppldate("2024-07-17");
		ex04.setAppltime("16:54");
		System.out.println(ex04.getPurchaseNum());
		System.out.println(ex04.getCardNum());
		System.out.println(ex04.getTotalPrice());
		System.out.println(ex04.getAppldate());
		System.out.println(ex04.getAppltime());
//		5. 리뷰정보를 저장하고 싶다. 리뷰정보는 리뷰번호:reviewNum, 별점:score, 리뷰등록:reviewDate
//		                                     리뷰내용:reviewContent
		Home_Ex05 ex05 = new Home_Ex05("01", 5, "202401", "내용");
		ex05.setReviewNum("02");
		ex05.setScore(1);
		ex05.setReviewDate("20240707");
		ex05.setReviewContent("내용");
		System.out.println(ex05.getReviewNum());
		System.out.println(ex05.getScore());
		System.out.println(ex05.getReviewDate());
		System.out.println(ex05.getReviewContent());
//		6. 상담정보를 저장싶다. 상담정보는 상담 번호:inquireNum, 상담종류 : inquireKind,
//		                                 상담 제목:inquireSubject, 상담내용:inquireContent
//		                                  상담일 : inquireDate , 답변:inquireAnswer
//		                                  답변일:inquireAnswerDate
		Home_Ex06 ex06 = new Home_Ex06(1, "상담종류", "제목", "내용", "20240707", "답변", "20240717");
		ex06.setNum(2);
		ex06.setKind("진로");
		ex06.setSubject("진로와 취업");
		ex06.setContent("진로 내용");
		ex06.setDate("20240808");
		ex06.setAnswer("상담 답변");
		ex06.setAnswerDate("20240809");
		
		System.out.println(ex06.getNum());
		System.out.println(ex06.getKind());
		System.out.println(ex06.getSubject());
		System.out.println(ex06.getContent());
		System.out.println(ex06.getDate());
		System.out.println(ex06.getAnswer());
		System.out.println(ex06.getAnswerDate());
		
		
		
//		7. 상품입고 : 입고번호:ipgoNum, 상품번호:goodsNum, 입고수량:ipgoQty, 입고일:ipgoDate
//		             상품제조일:madeDate, 입고금액:ipgoPrice, 상품금액:goodsPrice
		
		Home_Ex07 ex07 = new Home_Ex07("01", 1, 10, "20240707", "20240606", 1000, 500);
		ex07.setGoodsNum(2);
		ex07.setIpgoNum("02");
		ex07.setGoodsPrice(10000);
		ex07.setIpgoDate("20202020");
		ex07.setIpgoQty(20);
		ex07.setMadeDate("20215464");
		ex07.setIpgoPrice(3000);
		System.out.println(ex07.getIpgoNum());
		System.out.println(ex07.getGoodsNum());
		System.out.println(ex07.getIpgoQty());
		System.out.println(ex07.getIpgoDate());
		System.out.println(ex07.getMadeDate());
		System.out.println(ex07.getIpgoPrice());
		System.out.println(ex07.getGoodsPrice());

	}

}
