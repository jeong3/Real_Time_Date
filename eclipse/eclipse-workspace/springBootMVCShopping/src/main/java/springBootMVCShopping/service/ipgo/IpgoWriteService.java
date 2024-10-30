package springBootMVCShopping.service.ipgo;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCShopping.command.IpgoCommand;
import springBootMVCShopping.domain.IpgoDTO;
import springBootMVCShopping.mapper.IpgoMapper;

@Service
public class IpgoWriteService {
	@Autowired
	IpgoMapper ipgoMapper;
	public void execute(IpgoCommand ipgoCommand) {
		IpgoDTO dto = new IpgoDTO();
		dto.setEmpNum(ipgoCommand.getEmpNum());
		//dto.setGoodsName(ipgoCommand.getGoodsName());
		dto.setGoodsNum(ipgoCommand.getGoodsNum());
		
		dto.setIpgoNum(ipgoCommand.getIpgoNum());
		dto.setIpgoPrice(ipgoCommand.getIpgoPrice());
		dto.setIpgoQty(ipgoCommand.getIpgoQty());
		dto.setMadeDate(Timestamp.valueOf(ipgoCommand.getMadeDate()));
		ipgoMapper.ipgoInsert(dto);
	}

}
