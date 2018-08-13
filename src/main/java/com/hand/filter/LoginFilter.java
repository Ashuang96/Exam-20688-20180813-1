package com.hand.filter;

import com.hand.bean.Customer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author ZhengShuang
 * @date 2018/8/13 17:29
 */

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp =(HttpServletResponse) response;
        HttpSession session = req.getSession();
        // 获得用户请求的URI
        String path = req.getRequestURI();

        Customer customer = (Customer) session.getAttribute("customer");
        // login.jsp页面无需过滤
        if (path.contains("login") || path.equals("/") ||path.contains("index")) {
            filterChain.doFilter(req, resp);
            return;
        } else {
            if (customer != null) {
                filterChain.doFilter(request, response);
                return;
            } else {
                resp.sendRedirect("login.jsp");
            }

        }
    }

    @Override
    public void destroy() {

    }
}
