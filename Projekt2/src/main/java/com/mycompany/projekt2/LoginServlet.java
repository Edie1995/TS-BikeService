/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projekt2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kruko
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Inject
    private UserDao dao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> all = dao.getAll();
        request.setAttribute("users", all);
        request.getRequestDispatcher("loginPage.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = dao.checkPassword(login, password);
        System.out.println(user.toString());
        System.out.println(user.getPosition());
        if (user.getPosition().equals("klient")) {
           session.setAttribute("user", user);
           session.setAttribute("login", login);
            request.getRequestDispatcher("userServices.jsp").forward(request, response);
        } else if (user.getPosition().equals("admin")) {
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        }

        //doGet(request, response);
    }

}
