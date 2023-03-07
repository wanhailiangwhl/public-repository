package com.wanhailiang.dao.dao;

import com.wanhailiang.beans.User;

import java.sql.SQLException;

public interface UserDao {
    /**
     * 和User对象相关的insert操作
     * @param user 要操作的User对象
     * @return 大于0则成功操作
     */
    boolean insert(User user) throws SQLException, ClassNotFoundException;


    /**
     * select相关操作
     * @param user 要操作的User对象
     * @return 返回的是一个数字，如果找到用户名和密码对应的数据则返回age，没找到用户名或者密码不匹配的情况返回不一样的值
     */
    int select(User user) throws SQLException, ClassNotFoundException;
}
