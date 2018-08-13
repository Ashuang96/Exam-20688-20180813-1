package com.hand.service;

import com.hand.bean.Customer;
import com.hand.dao.CustomerDao;

import java.sql.SQLException;

/**
 * @author ZhengShuang
 * @date 2018/8/13 13:06
 */

public class CustomerService {
    public Customer getCustomer(String name) throws SQLException {
        CustomerDao customerDao = new CustomerDao();
        Customer customer = customerDao.getCustomer(name);
        return customer;
    }
}
