package com.lut.propertyleasing.controller;

import com.alibaba.fastjson.JSONObject;
import com.lut.propertyleasing.entity.UserEntity;
import com.lut.propertyleasing.service.IUserService;
import com.lut.propertyleasing.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "UpdateUserInfoServlet", value = "/UpdateUserInfoServlet")
public class UpdateUserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserEntity user1 = (UserEntity)request.getSession().getAttribute("USER");
        int userid = user1.getUserId();
        IUserService service = new UserServiceImpl();
        UserEntity user = service.findUserById(userid);
        request.setAttribute("user", user);
        request.getRequestDispatcher("user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String[]> maps = request.getParameterMap();
        IUserService service = new UserServiceImpl();
        boolean res = service.updateUserInfo(maps);
        JSONObject obj = new JSONObject();
        obj.put("res", res);
        response.getWriter().println(obj);
    }
}
