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

/**
 *
 * @author kruko
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/users"})
public class UserServlet extends HttpServlet {

    @Inject
    private UserDao dao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> all = dao.getAll();
        request.setAttribute("users", all);
        request.getRequestDispatcher("users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String position = request.getParameter("position");
        String button = request.getParameter("action");
        System.out.println(request.getParameter("action"));
        if (button.equals("dodaj")) {
            dao.save(new User(login, password, position));
        } else if (button.equals("usun")) {
            dao.remove(login, position);
        } else if (button.equals("zmien")) {

            dao.modify(login, password, position);
        }

        doGet(request, response);
    }
}
