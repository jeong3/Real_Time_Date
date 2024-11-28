package springBootMVCAlbum.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("fileDTO")
public class FileDTO {
	String orgFile;
	String storeFile;
}
