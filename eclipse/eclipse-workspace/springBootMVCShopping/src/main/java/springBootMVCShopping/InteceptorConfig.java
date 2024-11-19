package springBootMVCShopping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import springBootMVCShopping.domain.AuthInfoDTO;

@Component
public class InteceptorConfig implements HandlerInterceptor {
	@Override //컨트롤러에 들어가기 전에 차단 (컨트롤러에 들어오기전에 캐치하는 함수)
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		if(ObjectUtils.isEmpty(auth)) {
			response.sendRedirect("/");
			return false;
		}
		return true;
	}
	@Override // 컨트롤러 들어왔을 때 차단
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override // html페이지가 열렸을 때 차단
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
