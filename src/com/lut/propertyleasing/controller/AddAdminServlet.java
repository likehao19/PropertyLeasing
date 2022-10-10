package com.lut.propertyleasing.controller;

import com.lut.propertyleasing.service.IUserService;
import com.lut.propertyleasing.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddAdminServlet", value = "/AddAdminServlet")
public class AddAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user");
        String password = request.getParameter("password");
        IUserService service = new UserServiceImpl();
        boolean res = service.adminRegister(username, password);
        request.setAttribute("res", res);
        request.getRequestDispatcher("admin/admin_add.jsp").forward(request,response);
    }
}
