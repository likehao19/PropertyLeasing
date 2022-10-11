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
 * 模糊查询
 */

@WebServlet(name = "FuzzyQueryServlet", value = "/FuzzyQueryServlet")
public class FuzzyQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String keyWord = request.getParameter("keyWord");
        IHorseService service = new HorseServiceImpl();
        List<HorseEntity> lists = service.findHorseByKeyWord(keyWord);
        System.out.println(lists);
        if (lists != null && lists.size() > 0) {
            request.setAttribute("lists", lists);
        } else {
            request.setAttribute("msg", "库中尚未检索到符合条件的信息！");
        }
        request.getRequestDispatcher("pro_all.jsp").forward(request, response);
    }
}
