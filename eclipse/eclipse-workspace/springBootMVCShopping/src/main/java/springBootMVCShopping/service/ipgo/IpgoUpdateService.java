package springBootMVCShopping.service.ipgo;

import java.sql.Timestamp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCShopping.command.IpgoCommand;
import springBootMVCShopping.domain.IpgoDTO;
import springBootMVCShopping.mapper.IpgoMapper;

@Service
public class IpgoUpdateService {
   @Autowired
   IpgoMapper goodsIpgoMapper;
   public void execute(IpgoCommand ipgoCommand) {
      IpgoDTO dto = new IpgoDTO();
      BeanUtils.copyProperties(ipgoCommand, dto);
      dto.setMadeDate(Timestamp.valueOf(ipgoCommand.getMadeDate()));
      goodsIpgoMapper.ipgoUpdate(dto);
   }
   
}
