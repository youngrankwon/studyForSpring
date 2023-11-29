package spring.data.abstractrouting;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class DataSourceInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        String branch = request.getHeader("branch");
        if (BranchEnum.JAPAN.toString().equalsIgnoreCase(branch)) {
            BranchContextHolder.setBranchContext(BranchEnum.JAPAN);
        } else if(BranchEnum.KOREA.toString().equalsIgnoreCase(branch)) {
            BranchContextHolder.setBranchContext(BranchEnum.KOREA);
        }
        return true;
    }
}