package com.hand.dao;

import com.hand.bean.Language;
import com.hand.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhengShuang
 * @date 2018/8/13 17:16
 */

public class LanguageDao {
    public List<Language> getLanguage() throws SQLException {
        List<Language> list = new ArrayList<Language>();
       Statement statement = JDBCUtil.getStatement();
       ResultSet rs = statement.executeQuery("select language_id,name from language");
       while (rs.next()) {
           Language language = new Language();
           language.setLanguage_id(rs.getInt("language_id"));
           language.setName(rs.getString("name"));
           list.add(language);
       }
       return list;
    }
}
