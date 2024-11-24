package springBootMVCAlbum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCAlbum.mapper.ModuleMapper;


@Service
public class AutoNumService {
	@Autowired
	ModuleMapper moduleMapper;
	public String execute(String sep, String columnName, Integer len, String tableName) {
		String autoNum = moduleMapper.autoNumSelect(sep,columnName,len,tableName);
		System.out.println(autoNum);
		return autoNum;
	}

}
