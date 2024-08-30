package D20240719_Collection;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
	String bookName;
	String author;
	
	public void print() {
		System.out.println("책이름은 " + bookName + "이고 저자는 "+ author+"입니다");
	}
	
	
}
