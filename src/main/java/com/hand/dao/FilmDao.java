package com.hand.dao;

import com.hand.bean.Film;
import com.hand.utils.JDBCUtil;
import jdk.nashorn.internal.scripts.JD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhengShuang
 * @date 2018/8/13 10:57
 */

public class FilmDao {

    public List<Film> getFilmList() throws SQLException {
        List<Film> filmList = new ArrayList<Film>();
        Statement statement = JDBCUtil.getStatement();
        String sql = "Select film_id,f.title,f.description,l.name\n" +
                "from film f,language l\n" +
                "where  f.language_id = l.language_id";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            Film film = new Film();
            film.setFilm_id(rs.getInt("film_id"));
            film.setTitle(rs.getString("title"));
            film.setDescription(rs.getString("description"));
            film.setLanguage(rs.getString("name"));
            filmList.add(film);
        }
        statement.close();
        return filmList;
    }

    public Film getFilm(String Id) throws SQLException {
        System.out.println(Id);
        Integer id = Integer.valueOf(Id);
        String sql = "Select film_id,f.title,f.description,l.name\n" +
                "               from film f,language l\n" +
                "                where  f.language_id = l.language_id and film_id = ?";
        PreparedStatement p = JDBCUtil.getConnection().prepareStatement(sql);
        p.setInt(1, id);
        ResultSet resultSet = p.executeQuery();
        Film film = new Film();
        while (resultSet.next()) {
            film.setFilm_id(resultSet.getInt("film_id"));
            film.setTitle(resultSet.getString("title"));
            film.setDescription(resultSet.getString("description"));
            film.setLanguage(resultSet.getString("name"));
        }
        return film;
    }

    public void deleteFilm(Integer film_id) throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        String sql = "delete from film where film_id = ?";
        System.out.println(film_id);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,film_id);
        preparedStatement.executeUpdate();
    }

    public void insertFilm(Film film) throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        String title = film.getTitle();
        String description = film.getDescription();
        String language = film.getLanguage();
        Integer language_id = Integer.valueOf(language);
        String sql = "insert into Film(title,description,language_id) values (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,title);
        preparedStatement.setString(2,description);
        preparedStatement.setInt(3,language_id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    public void updateFilm(Film film) throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        String title = film.getTitle();
        String description = film.getDescription();
        String language = film.getLanguage();
        Integer language_id = Integer.valueOf(language);
        Integer film_id = film.getFilm_id();
        String sql = "update Film set title=?,description=?,language_id=? where film_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,title);
        preparedStatement.setString(2,description);
        preparedStatement.setInt(3,language_id);
        preparedStatement.setInt(4,film_id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }
}
