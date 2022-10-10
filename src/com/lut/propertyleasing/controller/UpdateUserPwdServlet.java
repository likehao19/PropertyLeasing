package com.lut.propertyleasing.controller;

import com.alibaba.fastjson.JSONObject;
import com.lut.propertyleasing.entity.UserEntity;
import com.lut.propertyleasing.service.IUserService;
import com.lut.propertyleasing.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateUserPwdServlet", value = "/UpdateUserPwdServlet")
public class UpdateUserPwdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserEntity user1 = (UserEntity) request.getSession().getAttribute("USER");
        int userid = user1.getUserId();
        IUserService service = new UserServiceImpl();
        UserEntity user = service.findUserById(userid);
        request.setAttribute("user", user);
        request.getRequestDispatcher("user_pwd.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        IUserService service = new UserServiceImpl();
        boolean res = service.updatePwd(username, password);
        JSONObject obj = new JSONObject();
        obj.put("res", res);
        response.getWriter().println(obj);
    }
}
