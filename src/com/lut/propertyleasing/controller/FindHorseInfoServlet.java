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
 * 查询所有房屋信息
 */
@WebServlet(name = "FindHorseInfoServlet", value = "/FindHorseInfoServlet")
public class FindHorseInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IHorseService service = new HorseServiceImpl();
        for (int i = 1; i <= 3; i++) {
            List<HorseEntity> horse = service.findHorseByCategoryId(i);
            request.setAttribute("horse" + i, horse);
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
