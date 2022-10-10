package com.lut.propertyleasing.controller;

import com.lut.propertyleasing.entity.HorseEntity;
import com.lut.propertyleasing.service.IHorseService;
import com.lut.propertyleasing.service.impl.HorseServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * 查看更多
 */
@WebServlet(name = "FindAllHorseServlet", value = "/FindAllHorseServlet")
public class FindAllHorseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int categoryid = Integer.parseInt(request.getParameter("categoryid"));
        IHorseService service = new HorseServiceImpl();
        List<HorseEntity> lists = null;
        if (categoryid == 1) {
            lists = service.findAllByCategoryId(1);
            request.setAttribute("lists", lists);
            request.getRequestDispatcher("pro_zu.jsp").forward(request, response);
        } else if (categoryid == 2) {
            lists = service.findAllByCategoryId(2);
            request.setAttribute("lists", lists);
            request.getRequestDispatcher("pro_xin.jsp").forward(request, response);
        } else if (categoryid == 3) {
            lists = service.findAllByCategoryId(3);
            request.setAttribute("lists", lists);
            request.getRequestDispatcher("pro_er.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
