package com.hand.servlet;

import com.hand.bean.Customer;
import com.hand.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author ZhengShuang
 * @date 2018/8/13 12:41
 */

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        if (name == null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        CustomerService customerService = new CustomerService();
        try {
            Customer customer = customerService.getCustomer(name);
            if (customer == null) {
                resp.sendRedirect("login.jsp");
            } else {
                req.getSession().setAttribute("customer", customer);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
