package springBootMVCShopping.service.ipgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCShopping.command.IpgoCommand;
import springBootMVCShopping.domain.IpgoDTO;
import springBootMVCShopping.mapper.IpgoMapper;

@Service
public class IpgoUpdateService {
	@Autowired
	IpgoMapper ipgoMapper;

	public void execute(IpgoCommand ipgoCommand) {
		IpgoDTO dto = new IpgoDTO();
		dto.setEmpNum(ipgoCommand.getEmpNum());
		dto.setGoodsNum(ipgoCommand.getGoodsNum());
		dto.setIpgoDate(ipgoCommand.getIpgoDate());
		dto.setIpgoNum(ipgoCommand.getIpgoNum());
		dto.setIpgoPrice(ipgoCommand.getIpgoPrice());
		dto.setIpgoQty(ipgoCommand.getIpgoQty());
		dto.setMadeDate(ipgoCommand.getMadeDate());
		ipgoMapper.ipgoUpdate(dto);
	}
	
	
}
