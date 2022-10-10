package com.lut.propertyleasing.controller;

import com.lut.propertyleasing.entity.UserEntity;
import com.lut.propertyleasing.service.IFollowService;
import com.lut.propertyleasing.service.impl.FollowServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 添加关注
 */
@WebServlet(name = "FollowHorseServlet", value = "/FollowHorseServlet")
public class FollowHorseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserEntity user = (UserEntity) request.getSession().getAttribute("USER");
        int userid = user.getUserId();
        int horseid = Integer.parseInt(request.getParameter("horseid"));
        System.out.println("userid" + userid);
        System.out.println("horseid" + horseid);
        IFollowService service = new FollowServiceImpl();
        boolean res = service.addFollowHorse(horseid, userid);
        request.setAttribute("res", res);
        response.getWriter().println(res);
        /* request.getRequestDispatcher("proinfo.jsp").forward(request, response);*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
