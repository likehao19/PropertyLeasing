package com.lut.propertyleasing.controller;

import com.lut.propertyleasing.entity.HorseEntity;
import com.lut.propertyleasing.service.IHorseService;
import com.lut.propertyleasing.service.impl.HorseServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 查看详情
 */
@WebServlet(name = "FindHorseDetailServlet", value = "/FindHorseDetailServlet")
public class FindHorseDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int horseid = Integer.parseInt(request.getParameter("horseid"));
        IHorseService service = new HorseServiceImpl();
        HorseEntity horse = service.findHorseDetailById(horseid);
        request.setAttribute("horse", horse);
        request.getRequestDispatcher("proinfo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
