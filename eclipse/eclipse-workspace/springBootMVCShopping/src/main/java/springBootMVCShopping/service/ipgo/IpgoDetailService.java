package springBootMVCShopping.service.ipgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.domain.GoodsIpgoGoodsNameDTO;
import springBootMVCShopping.mapper.IpgoMapper;

@Service
public class IpgoDetailService {
	@Autowired
	IpgoMapper ipgoMapper;

	public GoodsIpgoGoodsNameDTO execute(Model model, String ipgoNum, String goodsNum) {
		System.out.println(ipgoNum+goodsNum+"asdasdasdasd");
		GoodsIpgoGoodsNameDTO dto = ipgoMapper.ipgoSelectOne(ipgoNum, goodsNum);
		model.addAttribute("dto", dto);
		return dto;
	}
	
}
