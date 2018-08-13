package com.hand.servlet;

import com.hand.bean.Film;
import com.hand.service.FilmService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author ZhengShuang
 * @date 2018/8/13 13:34
 */

public class FilmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FilmService filmService = new FilmService();
        try {
            List<Film> list = filmService.getFilmList();
            req.setAttribute("list", list);
            req.getRequestDispatcher("filmlist.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
