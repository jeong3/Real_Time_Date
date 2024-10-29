package springBootMVCShopping.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("FileDTO")
public class FileDTO {
	String orgFile;
	String storeFile;
	
	
}
