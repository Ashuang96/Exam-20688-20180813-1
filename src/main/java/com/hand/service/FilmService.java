package com.hand.service;

import com.hand.bean.Film;
import com.hand.dao.FilmDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ZhengShuang
 * @date 2018/8/13 10:25
 */

public class FilmService {

    public List<Film> getFilmList() throws SQLException {
        return new FilmDao().getFilmList();
    }

    public void deleteFilm(String film_id) throws SQLException {
        Integer id = Integer.valueOf(film_id);
        FilmDao dao = new FilmDao();
        dao.deleteFilm(id);
    }

    public void insertFilm(String title, String description, String languege) throws SQLException {
        Film film = new Film();
        film.setTitle(title);
        film.setDescription(description);
        film.setLanguage(languege);
        FilmDao filmDao = new FilmDao();
        filmDao.insertFilm(film);
    }

    public void updateFilm(String id, String title, String description, String languege) throws SQLException {
        Film film = new Film();
        film.setFilm_id(Integer.valueOf(id));
        film.setTitle(title);
        film.setDescription(description);
        film.setLanguage(languege);
        FilmDao filmDao = new FilmDao();
        filmDao.updateFilm(film);
    }
}
