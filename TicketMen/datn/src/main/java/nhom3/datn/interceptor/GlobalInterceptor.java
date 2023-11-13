package nhom3.datn.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import nhom3.datn.service.CategoryService;
import nhom3.datn.service.MovieService;
import nhom3.datn.service.TicketService;

@Component
public class GlobalInterceptor implements HandlerInterceptor{
    @Autowired
    CategoryService categoryService;

    @Autowired
    MovieService movieService;

    @Autowired
    TicketService ticketService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        request.setAttribute("cates", categoryService.fillAll());
        request.setAttribute("movis", movieService.findAll());
        request.setAttribute("tickets", ticketService.findAll());
    } 
}
