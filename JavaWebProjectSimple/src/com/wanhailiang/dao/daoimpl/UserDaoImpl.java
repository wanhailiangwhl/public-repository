package com.wanhailiang.dao.daoimpl;

import com.wanhailiang.beans.User;
import com.wanhailiang.dao.dao.UserDao;
import com.wanhailiang.msg.Status;
import com.wanhailiang.utils.DBConnection;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    /**
     *
     * @param user 要插入到数据库表中的user对象
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public boolean insert(User user) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO userinfo (username, pwd, age) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPwd());
        preparedStatement.setInt(3, user.getAge());
        int result = preparedStatement.executeUpdate();
        return result>0 ? true : false;
    }


    /**
     * 在数据库中判断是否拥有用户信息，如果
     *      1. username存在
     *          1.1 pwd对应上：返回age
     *          1.2 pwd对应不上：返回“密码错误”对应的状态码
     *      2. username不存在：返回“用户名不存在”对应的状态码
     * @param user 要操作的对象
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public int select(User user) throws SQLException, ClassNotFoundException {
        /*
            1. username存在
                1.1 pwd对应上：返回age
                1.2 pwd对应不上：返回“密码错误”
            2. username不存在：返回“用户名不存在”
         */
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM userinfo WHERE username=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUsername());
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            if(resultSet.getString("pwd").equals(user.getPwd())){
                return resultSet.getInt("age");
            }
            else{
                return Status.USER_FOUND_BUT_PWD_FAILED;
            }
        }
        else{
            return Status.USER_NOT_FOUND;
        }
    }

}
