package springBootMVCShopping.service.help;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootMVCShopping.command.HelpCommand;
import springBootMVCShopping.domain.HelpDTO;
import springBootMVCShopping.mapper.HelpMapper;

@Service
public class FindIdService {
	@Autowired
	HelpMapper helpMapper;
	public void execute(HelpCommand helpCommand, Model model) {
		HelpDTO dto = new HelpDTO();
		dto.setUserPhone(helpCommand.getUserPhone());
		dto.setUserEmail(helpCommand.getUserEmail());
		dto = helpMapper.idSelect(dto);
		model.addAttribute("userId", dto.getUserId());
	}

}
