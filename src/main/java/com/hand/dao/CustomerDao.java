package com.hand.dao;

import com.hand.bean.Customer;
import com.hand.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ZhengShuang
 * @date 2018/8/13 11:43
 */

public class CustomerDao {

    public Customer getCustomer(String first_name) throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select customer_id,first_name from customer where first_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, first_name);
        ResultSet rs = preparedStatement.executeQuery();
        Customer c = new Customer();
        while (rs.next()) {
            c.setCustomer_id(rs.getInt("customer_id"));
            c.setFirst_name(rs.getString("first_name"));
        }
        return c;
    }
}
