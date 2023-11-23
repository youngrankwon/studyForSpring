package backup.dsrouting;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class DataSourceInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
		Exception {

		String branch = request.getHeader("branch");
		if (BranchEnum.KOREA.toString().equalsIgnoreCase(branch)) {
			BranchContextHolder.setBranchContext(BranchEnum.KOREA);
		} else {
			BranchContextHolder.setBranchContext(BranchEnum.JAPAN);
		}
		return true;
	}
}