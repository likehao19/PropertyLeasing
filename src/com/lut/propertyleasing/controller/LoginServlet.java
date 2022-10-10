package com.lut.propertyleasing.controller;

import com.lut.propertyleasing.entity.UserEntity;
import com.lut.propertyleasing.service.IUserService;
import com.lut.propertyleasing.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        IUserService service = new UserServiceImpl();
        UserEntity user = service.login(username, password);
        if (user != null) {

            HttpSession session = request.getSession();

            ServletContext application = this.getServletContext();
            Integer count = (Integer) application.getAttribute("count");
            if (count == null) {
                application.setAttribute("count", 1);
            } else {
                application.setAttribute("count", count + 1);
            }
            session.setAttribute("USER", user);
            response.sendRedirect("welcome.jsp");
        } else {
            request.setAttribute("msg", "用户名或密码错误!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
