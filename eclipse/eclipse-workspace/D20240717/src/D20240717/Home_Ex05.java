package D20240717;

public class Home_Ex05 {
//	5. 리뷰정보를 저장하고 싶다. 리뷰정보는 리뷰번호:reviewNum, 별점:score, 리뷰등록:reviewDate
//    리뷰내용:reviewContent
	String reviewNum;
	int score;
	String reviewDate;
	String reviewContent;
	
	public Home_Ex05(String reviewNum, int score, String reviewDate, String reviewContent) {
		this.reviewNum = reviewNum;
		this.score = score;
		this.reviewDate = reviewDate;
		this.reviewContent = reviewContent;
	}
	public void setReviewNum(String reviewNum) {
		this.reviewNum = reviewNum;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}


	public String getReviewNum( ) {
		return reviewNum;
	}
	public int getScore( ) {
		return score;
	}
	public String getReviewDate( ) {
		return reviewDate;
	}
	public String getReviewContent( ) {
		return reviewContent;
	}
	
}
