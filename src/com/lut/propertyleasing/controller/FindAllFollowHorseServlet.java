package com.lut.propertyleasing.controller;

import com.lut.propertyleasing.entity.FollowEntity;
import com.lut.propertyleasing.entity.HorseEntity;
import com.lut.propertyleasing.entity.UserEntity;
import com.lut.propertyleasing.service.IFollowService;
import com.lut.propertyleasing.service.impl.FollowServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindAllFollowHorseServlet", value = "/FindAllFollowHorseServlet")
public class FindAllFollowHorseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserEntity user = (UserEntity) request.getSession().getAttribute("USER");
        int userid = user.getUserId();
        IFollowService service = new FollowServiceImpl();
        for (int i = 1; i <= 3; i++) {
            List<FollowEntity> lists = service.findAllFollowHorse(userid, i);
            request.setAttribute("follow" + i, lists);
        }
        request.getRequestDispatcher("user_guanzhu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        System.out.println(id);
        IFollowService service = new FollowServiceImpl();
        boolean res = service.delFollowById(id);
        response.getWriter().println(res);


    }
}
