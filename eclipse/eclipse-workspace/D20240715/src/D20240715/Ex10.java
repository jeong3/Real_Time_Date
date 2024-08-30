package D20240715;

public class Ex10 {

	public static void main(String[] args) {
		// setter, getter, 생성자
		// 객체 생성 시 생성자를 이용하고 생성한 후 setter를 이용해서 멤버값을 변경하고, getter를 이용해서 멤버값을 출력
		/*
		 * 상담번호 : inquireNum, 상담종류 : inquireKind, 상담 제목 : inquireSubject, 상담 내용 :
		 * inquireContent 상담일 : inquireDate, 답변 : inquireAnswer, 답변일 : inquireAnswerDate
		 */
		Ex10_QnA qna = new Ex10_QnA(1, "심리", "심리 제목", "심리 내용", "20240715", "상담 답변", "20240715");
		System.out.println(qna.getNum());
		System.out.println(qna.getKind());
		System.out.println(qna.getSubject());
		System.out.println(qna.getContent());
		System.out.println(qna.getDate());
		System.out.println(qna.getAnswer());
		System.out.println(qna.getAnswerDate());
		
		qna.setNum(2);
		qna.setKind("진로");
		qna.setSubject("진로와 취업");
		qna.setContent("진로 내용");
		qna.setDate("20240808");
		qna.setAnswer("상담 답변");
		qna.setAnswerDate("20240809");
		
		System.out.println(qna.getNum());
		System.out.println(qna.getKind());
		System.out.println(qna.getSubject());
		System.out.println(qna.getContent());
		System.out.println(qna.getDate());
		System.out.println(qna.getAnswer());
		System.out.println(qna.getAnswerDate());

	}

}
