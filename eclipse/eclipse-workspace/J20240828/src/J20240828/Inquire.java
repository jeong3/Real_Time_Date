package J20240828;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor //기본생성자
@AllArgsConstructor //생성자
@Data //세터,게터

public class Inquire {
	int inqNum;
	String inqSubject;
	String inqKind;
	String inqAnswer;
}
