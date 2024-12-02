package springBootMVCAlbum.service.ipgo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import springBootMVCAlbum.command.IpgoCommand;
import springBootMVCAlbum.domain.AuthInfoDTO;
import springBootMVCAlbum.domain.IpgoDTO;
import springBootMVCAlbum.mapper.IpgoMapper;

@Service
public class IpgoRegistService {
	@Autowired
	IpgoMapper ipgoMapper;
	public void execute(IpgoCommand ipgoCommand) {
		IpgoDTO dto = new IpgoDTO();
		BeanUtils.copyProperties(ipgoCommand, dto);
		ipgoMapper.ipgoInsert(dto);
		
		
	}
	
}
