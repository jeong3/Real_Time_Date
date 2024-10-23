package springBootMVCShopping.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import springBootMVCShopping.command.GoodsCommand;
import springBootMVCShopping.domain.AuthInfoDTO;
import springBootMVCShopping.mapper.GoodsMapper;

@Service
public class EmpNumSelectService {
	@Autowired
	GoodsMapper goodsMapper;
	public String execute(HttpSession session,  Model model) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String empId = auth.getUserId();
		String empNum = goodsMapper.empNumSelect(empId);
		System.out.println(empId+"유저아이디");
		System.out.println(empNum+"유저번호");
		
		return empNum;
		
	}
	
}
