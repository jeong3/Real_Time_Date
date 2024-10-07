package InquireService;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import Service.MemberAuthService;
import model.InquireDAO;
import model.InquireDTO;

public class InquireWriteProService extends MemberAuthService{

	public InquireWriteProService(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

	

	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String goodsNum = request.getParameter("goodsNum");
		String queryType = request.getParameter("queryType");
		String inquireSubject = request.getParameter("inquireSubject");
		String inquireContent = request.getParameter("inquireContent");
		
		InquireDTO dto = new InquireDTO();
		dto.setGoodsNum(goodsNum);
		dto.setInquireContent(inquireContent);
		dto.setInquireKind(queryType);
		dto.setInquireSubject(inquireSubject);
		dto.setMemberNum(memberNum);
		
		InquireDAO dao = new InquireDAO();
		
		dao.inquireInsert(dto);
		
	}

}
