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
 * @date 2018/8/13 14:41
 */

public class AddFilm extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String title = req.getParameter("title");
       String description = req.getParameter("description");
       String language = req.getParameter("language");
       System.out.println(title +"---"+description+"----"+language);
       if (title == null || description == null || language == null) {
           resp.sendRedirect("index.jsp");
           return;
       }
       FilmService filmService = new FilmService();
        try {
            filmService.insertFilm(title, description, language);
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().write("<html><body><h3>添加成功！</h3><body></html>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
