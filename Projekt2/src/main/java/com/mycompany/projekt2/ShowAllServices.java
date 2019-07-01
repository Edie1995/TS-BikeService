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
import org.hibernate.sql.Template;

/**
 *
 * @author kruko
 */
@WebServlet(name = "ShowAllServices", urlPatterns = {"/allServices"})
public class ShowAllServices extends HttpServlet {

    @Inject
    private ServiceDao dao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Service> all = dao.getAll();
        System.out.println(all.size());
        request.setAttribute("services", all);
        request.getRequestDispatcher("allServices.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
