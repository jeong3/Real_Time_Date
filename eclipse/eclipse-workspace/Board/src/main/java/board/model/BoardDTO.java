package board.model;

public class BoardDTO {
	int boardNum;
	String boardWriter;
	String boardSubject;
	String boardContent;
	
	
	public BoardDTO() {
	}


	public BoardDTO(int boardNum, String boardWriter, String boardSubject, String boardContent) {
		this.boardNum = boardNum;
		this.boardWriter = boardWriter;
		this.boardSubject = boardSubject;
		this.boardContent = boardContent;
	}


	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}


	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}


	public void setBoardSubject(String boardSubject) {
		this.boardSubject = boardSubject;
	}


	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}


	public int getBoardNum() {
		return boardNum;
	}


	public String getBoardWriter() {
		return boardWriter;
	}


	public String getBoardSubject() {
		return boardSubject;
	}


	public String getBoardContent() {
		return boardContent;
	}
	
	
	
}
