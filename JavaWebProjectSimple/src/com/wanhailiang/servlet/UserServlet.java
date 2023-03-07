package com.wanhailiang.servlet;

import com.wanhailiang.beans.User;
import com.wanhailiang.msg.Message;
import com.wanhailiang.msg.Status;
import com.wanhailiang.service.UserService;

import java.io.IOException;
import java.sql.SQLException;

public class UserServlet extends javax.servlet.http.HttpServlet {
    /**
     * 这个方法用来处理登录相关请求
     * @param request Http请求
     * @param response Http响应
     * @throws javax.servlet.ServletException
     * @throws IOException
     */
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        User user = new User();

        UserService userService = new UserService();
        String method = request.getParameter("method");

        switch (method){
            case "login":
                /*
                    去数据库中查询是否有这个user
                    如果有，则重定向到index.jsp，并在数据库中查到用户的age信息，保存到session中
                    如果没有，则重定向到login.jsp，并返回一个错误信息，显示在屏幕上
                */
                user.setUsername(request.getParameter("username"));
                user.setPwd(request.getParameter("pwd"));
                try {
                    int result = userService.userLogin(user);
                    if(result == Status.USER_FOUND_BUT_PWD_FAILED){
                        request.setAttribute("messagePassword", Message.USER_FOUND_BUT_PWD_FAILED);
                        request.getRequestDispatcher("/login.jsp").forward(request, response);
                    }else if(result == Status.USER_NOT_FOUND){
                        request.setAttribute("messageUsername", Message.USER_NOT_FOUND);
                        request.getRequestDispatcher("/login.jsp").forward(request, response);
                    }else{
                        user.setAge(result);
                        request.setAttribute("user", user);
                        request.getRequestDispatcher("/index.jsp").forward(request, response);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "register":
                String message = "";
                user.setUsername(request.getParameter("username"));
                user.setPwd(request.getParameter("pwd"));
                user.setAge(Integer.parseInt(request.getParameter("age")));
                try {
                    boolean result = userService.userRegister(user);
                    message = Message.INSERT_SUCCESS;
                } catch (SQLException e) {
                    message = Message.INSERT_FAILED;
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    message = Message.INSERT_FAILED;
                    e.printStackTrace();
                }finally {
                    request.setAttribute("message", message);
                    request.setAttribute("user", user);
                    request.getRequestDispatcher("/register.jsp").forward(request, response);
                }
                break;
            default:
                break;
        }



    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        throw new RuntimeException("这是UserServlet的doGet方法，现在没有声明");
    }
}
