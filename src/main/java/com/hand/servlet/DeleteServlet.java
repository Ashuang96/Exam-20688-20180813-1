package com.hand.servlet;

import com.hand.service.FilmService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author ZhengShuang
 * @date 2018/8/13 15:14
 */

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id == null) {
            resp.sendRedirect("filmlist.jsp");
            return;
        }
        FilmService filmService = new FilmService();
        try {
            filmService.deleteFilm(id);
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().write("<html><body><h3>删除成功！</h3><body></html>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
