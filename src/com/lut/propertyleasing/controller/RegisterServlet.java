package com.lut.propertyleasing.controller;

import com.lut.propertyleasing.entity.UserEntity;
import com.lut.propertyleasing.service.IUserService;
import com.lut.propertyleasing.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        IUserService service = new UserServiceImpl();
        UserEntity user = new UserEntity(username, password);
        boolean res = service.register(user);
        if (res) {
            response.sendRedirect("login.jsp");
        } else {
            response.sendRedirect("reg.jsp");
        }
    }
}
