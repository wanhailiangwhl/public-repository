package com.wanhailiang.service;

import com.wanhailiang.beans.User;
import com.wanhailiang.dao.dao.UserDao;
import com.wanhailiang.dao.daoimpl.UserDaoImpl;

import java.sql.SQLException;


public class UserService {
    private UserDao userDao = new UserDaoImpl();

    public int userLogin(User user) throws SQLException, ClassNotFoundException {
        return userDao.select(user);
    }

    public boolean userRegister(User user) throws SQLException, ClassNotFoundException {
        return userDao.insert(user);
    }
}
