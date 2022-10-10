package com.lut.propertyleasing.controller;

import com.alibaba.fastjson.JSONObject;
import com.lut.propertyleasing.entity.HorseEntity;
import com.lut.propertyleasing.service.IHorseService;
import com.lut.propertyleasing.service.impl.HorseServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "SortHorseServlet", value = "/SortHorseServlet")
public class SortHorseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        int categoryid = Integer.parseInt(request.getParameter("categoryid"));
        IHorseService service = new HorseServiceImpl();
        List<HorseEntity> lists = service.findAllHorse(categoryid);
        List<HorseEntity> horse = null;
        //按价格排序
        if ("1".equals(method)) {
            horse = lists.stream().sorted(Comparator.comparingDouble(HorseEntity::getRent).reversed()).collect(Collectors.toList());
        }
        if ("2".equals(method)) {
            horse = lists.stream().sorted(Comparator.comparing(HorseEntity::getCreatetime).reversed()).collect(Collectors.toList());
        }
        JSONObject obj = new JSONObject();
        obj.put("horse", horse);
        response.getWriter().println(obj);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
