package com.wanhailiang.utils;

import java.sql.*;

public class DBConnection {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/db_user?" +
                "useUnicode=true&" +
                "characterEncoding=UTF-8&" +
                "useJDBCCompliantTimezoneShift=true&" +
                "useLegacyDatetimeCode=false&" +
                "serverTimezone=UTC";
        String username = "root";
        String password = "wan19990730";
        return DriverManager.getConnection(url, username, password);
    }

    public static void closeConnection(Connection connection) throws SQLException {
        if(connection != null) connection.close();
    }

    public static void closeResultSet(ResultSet resultSet) throws SQLException {
        if(resultSet != null) resultSet.close();
    }

    public static void closeStatement(Statement statement) throws SQLException {
        if(statement != null) statement.close();
    }
}
