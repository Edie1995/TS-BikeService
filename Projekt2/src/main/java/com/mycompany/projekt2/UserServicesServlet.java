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
@WebServlet(name = "UserServicesServlet", urlPatterns = {"/userServices"})
public class UserServicesServlet extends HttpServlet {

    @Inject
    private ServiceDao dao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String username = session.getAttribute("login").toString();        
        List<Service> all = dao.getAllForUser(username);
        System.out.println(all.size());
        request.setAttribute("services", all);
        request.getRequestDispatcher("userServices.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String username = session.getAttribute("login").toString();
        String name = request.getParameter("name");
        String data = request.getParameter("data");
        String button = request.getParameter("action");
        System.out.println(request.getParameter("action"));

        if (button.equals("dodaj")) {
            dao.save(new Service(username, name, data));
        } else if (button.equals("usun")) {
            dao.remove(username, data);
        } else if (button.equals("zmien")) {

            dao.modify(name, data);
        }
        doGet(request, response);
    }

}
