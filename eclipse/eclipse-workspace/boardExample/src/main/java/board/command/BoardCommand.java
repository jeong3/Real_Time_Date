package board.command;

public class BoardCommand {
	// dto === table의 컬럼
	// request.getParameter("input의 name")
	// request === command의 멤버변수
	String boardWriter;
	String boardSubject;
	String boardContent;
	
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardSubject() {
		return boardSubject;
	}
	public void setBoardSubject(String boardSubject) {
		this.boardSubject = boardSubject;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
}
