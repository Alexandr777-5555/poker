package shop.web;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PDFInterceptor extends HandlerInterceptorAdapter {


    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        String report=null;
        String reportDate = request.
                getQueryString()
                .replace("date=", "")
                .replace("-", "_");

        if (request.getServletPath().endsWith(".pdf")) {
            report = "report" + reportDate + ".pdf";
        }
        if (request.getServletPath().endsWith(".pdf")) {
            report = "reports" + reportDate + ".pdf";
        }
        if (report != null) {
            response.setHeader("Content-Disposition", "attachment; filename=" + report);
        }
    }
}
