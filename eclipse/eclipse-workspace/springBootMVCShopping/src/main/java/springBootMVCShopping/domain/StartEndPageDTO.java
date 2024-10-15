package springBootMVCShopping.domain;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;

@Alias("StartEndPageDTO")
@Data
@AllArgsConstructor
public class StartEndPageDTO {
	int startRow;
	int endRow;
	String searchWord;

}
