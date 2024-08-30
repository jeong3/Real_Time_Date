package D20240717;

public class Home_Ex06 {
//	6. 상담정보를 저장싶다. 상담정보는 상담 번호:inquireNum, 상담종류 : inquireKind,
//    상담 제목:inquireSubject, 상담내용:inquireContent
//     상담일 : inquireDate , 답변:inquireAnswer
//     답변일:inquireAnswerDate
	
	int inquireNum;
	String inquireKind;
	String inquireSubject;
	String inquireContent;
	String inquireDate;
	String inquireAnswer;
	String inquireAnswerDate;

	public Home_Ex06(int inquireNum, String inquireKind, String inquireSubject, String inquireContent,
			String inquireDate, String inquireAnswer, String inquireAnswerDate) {
		this.inquireNum = inquireNum;
		this.inquireKind = inquireKind;
		this.inquireSubject = inquireSubject;
		this.inquireContent = inquireContent;
		this.inquireDate = inquireDate;
		this.inquireAnswer = inquireAnswer;
		this.inquireAnswerDate = inquireAnswerDate;
	}
	public void setNum(int inquireNum) {
		this.inquireNum = inquireNum;
	}
	public void setKind(String inquireKind) {
		this.inquireKind = inquireKind;
	}
	public void setSubject(String inquireSubject) {
		this.inquireSubject = inquireSubject;
	}
	public void setContent(String inquireContent) {
		this.inquireContent = inquireContent;
	}
	public void setDate(String inquireDate) {
		this.inquireDate = inquireDate;
	}
	public void setAnswer(String inquireAnswer) {
		this.inquireAnswer = inquireAnswer;
	}
	public void setAnswerDate(String inquireAnswerDate) {
		this.inquireAnswerDate = inquireAnswerDate;
	}
//
	public int getNum( ) {
		return inquireNum;
	}
	public String getKind( ) {
		return inquireKind;
	}
	public String getSubject( ) {
		return inquireSubject;
	}
	public String getContent( ) {
		return inquireContent;
	}
	public String getDate( ) {
		return inquireDate;
	}
	public String getAnswer( ) {
		return inquireAnswer;
	}
	public String getAnswerDate( ) {
		return inquireAnswerDate;
	}
	

	
	
	
	
}
