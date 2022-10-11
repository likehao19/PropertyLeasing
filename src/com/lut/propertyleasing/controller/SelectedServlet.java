package com.lut.propertyleasing.controller;

import com.alibaba.fastjson.JSONObject;
import com.lut.propertyleasing.entity.HorseEntity;
import com.lut.propertyleasing.service.IHorseService;
import com.lut.propertyleasing.service.impl.HorseServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 多条件筛选
 */
@WebServlet(name = "SelectedServlet", value = "/SelectedServlet")
public class SelectedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      /*  request.setCharacterEncoding("UTF-8");
        response.setContentType("html/text;charset=UTF-8");*/
        int categoryid = Integer.parseInt(request.getParameter("categoryid"));
        IHorseService service = new HorseServiceImpl();
        List<HorseEntity> lists = service.findAllHorse(categoryid);
        String qq = request.getParameter("qq");
        String ww = request.getParameter("ww");
        String rr = request.getParameter("rr");
        String tt = request.getParameter("tt");
        String[] w = ww.split(",");
        String[] r = rr.split(",");
        List<HorseEntity> horse = null;

        //均未选择 1234
        if (qq.startsWith("0") && w[0].startsWith("0") && r[0].startsWith("0") && tt.startsWith("0")) {
            horse = lists;
        }
        //区域未选择1
        if (qq.startsWith("0") && !w[0].startsWith("0") && !r[0].startsWith("0") && !tt.startsWith("0")) {
            horse = lists.stream().
                    filter(h -> h.getRent() >= Double.parseDouble(w[0])).filter(h -> h.getRent() < Double.parseDouble(w[1])).
                    filter(h -> h.getArea() >= Double.parseDouble(r[0])).filter(h -> h.getArea() < Double.parseDouble(r[1])).
                    filter(h -> h.getTypeid() == Integer.parseInt(tt)).
                    collect(Collectors.toList());
        }
        //租金未选择2
        if (!qq.startsWith("0") && w[0].startsWith("0") && !r[0].startsWith("0") && !tt.startsWith("0")) {
            horse = lists.stream().
                    filter(h -> h.getCommunityid() == Integer.parseInt(qq)).
                    filter(h -> h.getArea() >= Double.parseDouble(r[0])).filter(h -> h.getArea() < Double.parseDouble(r[1])).
                    filter(h -> h.getTypeid() == Integer.parseInt(tt)).
                    collect(Collectors.toList());
        }
        //面积未选择3
        if (!qq.startsWith("0") && !w[0].startsWith("0") && r[0].startsWith("0") && !tt.startsWith("0")) {
            horse = lists.stream().
                    filter(h -> h.getCommunityid() == Integer.parseInt(qq)).
                    filter(h -> h.getRent() >= Double.parseDouble(w[0])).filter(h -> h.getRent() < Double.parseDouble(w[1])).
                    filter(h -> h.getTypeid() == Integer.parseInt(tt)).
                    collect(Collectors.toList());
        }
        //房型未选择4
        if (!qq.startsWith("0") && !w[0].startsWith("0") && !r[0].startsWith("0") && tt.startsWith("0")) {
            horse = lists.stream().
                    filter(h -> h.getCommunityid() == Integer.parseInt(qq)).
                    filter(h -> h.getRent() >= Double.parseDouble(w[0])).filter(h -> h.getRent() < Double.parseDouble(w[1])).
                    filter(h -> h.getArea() >= Double.parseDouble(r[0])).filter(h -> h.getArea() < Double.parseDouble(r[1])).
                    collect(Collectors.toList());
        }
        //区域，租金未选择12
        if (qq.startsWith("0") && w[0].startsWith("0") && !r[0].startsWith("0") && !tt.startsWith("0")) {
            horse = lists.stream().
                    filter(h -> h.getArea() >= Double.parseDouble(r[0])).filter(h -> h.getArea() < Double.parseDouble(r[1])).
                    filter(h -> h.getTypeid() == Integer.parseInt(tt)).
                    collect(Collectors.toList());
        }
        //区域，面积未选择13
        if (qq.startsWith("0") && !w[0].startsWith("0") && r[0].startsWith("0") && !tt.startsWith("0")) {
            horse = lists.stream().
                    filter(h -> h.getRent() >= Double.parseDouble(w[0])).filter(h -> h.getRent() < Double.parseDouble(w[1])).
                    filter(h -> h.getTypeid() == Integer.parseInt(tt)).
                    collect(Collectors.toList());
        }
        //区域，房型未选择14
        if (qq.startsWith("0") && !w[0].startsWith("0") && !r[0].startsWith("0") && tt.startsWith("0")) {
            horse = lists.stream().
                    filter(h -> h.getRent() >= Double.parseDouble(w[0])).filter(h -> h.getRent() < Double.parseDouble(w[1])).
                    filter(h -> h.getArea() >= Double.parseDouble(r[0])).filter(h -> h.getArea() < Double.parseDouble(r[1])).
                    collect(Collectors.toList());
        }
        //区域，租金，面积未选择123
        if (qq.startsWith("0") && w[0].startsWith("0") && r[0].startsWith("0") && !tt.startsWith("0")) {
            horse = lists.stream().
                    filter(h -> h.getTypeid() == Integer.parseInt(tt)).
                    collect(Collectors.toList());
        }
        //区域，面积，房型未选择124
        if (qq.startsWith("0") && w[0].startsWith("0") && !r[0].startsWith("0") && tt.startsWith("0")) {
            horse = lists.stream().
                    filter(h -> h.getArea() >= Double.parseDouble(r[0])).filter(h -> h.getArea() < Double.parseDouble(r[1])).
                    collect(Collectors.toList());
        }
        //区域，租金，房型未选择134
        if (qq.startsWith("0") && !w[0].startsWith("0") && r[0].startsWith("0") && tt.startsWith("0")) {
            horse = lists.stream().
                    filter(h -> h.getRent() >= Double.parseDouble(w[0])).filter(h -> h.getRent() < Double.parseDouble(w[1])).
                    collect(Collectors.toList());
        }

        //租金，面积未选择23
        if (!qq.startsWith("0") && w[0].startsWith("0") && r[0].startsWith("0") && !tt.startsWith("0")) {
            horse = lists.stream().
                    filter(h -> h.getCommunityid() == Integer.parseInt(qq)).
                    filter(h -> h.getTypeid() == Integer.parseInt(tt)).
                    collect(Collectors.toList());
        }
        //租金，房型未选择24
        if (!qq.startsWith("0") && w[0].startsWith("0") && !r[0].startsWith("0") && tt.startsWith("0")) {
            horse = lists.stream().
                    filter(h -> h.getCommunityid() == Integer.parseInt(qq)).
                    filter(h -> h.getArea() >= Double.parseDouble(r[0])).filter(h -> h.getArea() < Double.parseDouble(r[1])).
                    collect(Collectors.toList());
        }
        //面积，房型未选择34
        if (!qq.startsWith("0") && !w[0].startsWith("0") && r[0].startsWith("0") && tt.startsWith("0") && !"".equals(qq) && !"".equals(ww) && !"".equals(rr) && !"".equals(tt)) {
            horse = lists.stream().
                    filter(h -> h.getCommunityid() == Integer.parseInt(qq)).
                    filter(h -> h.getRent() >= Double.parseDouble(w[0])).filter(h -> h.getRent() < Double.parseDouble(w[1])).
                    collect(Collectors.toList());
        }

        //租金，房型，面积未选择234
        if (!qq.startsWith("0") && w[0].startsWith("0") && r[0].startsWith("0") && tt.startsWith("0")) {
            horse = lists.stream().
                    filter(h -> h.getCommunityid() == Integer.parseInt(qq)).
                    collect(Collectors.toList());
        }
        //均选择0000
        if (!qq.startsWith("0") && !w[0].startsWith("0") && !r[0].startsWith("0") && !tt.startsWith("0") && !"".equals(qq) && !"".equals(ww) && !"".equals(rr) && !"".equals(tt)) {
            horse = lists.stream().
                    filter(h -> h.getCommunityid() == Integer.parseInt(qq)).
                    filter(h -> h.getRent() >= Double.parseDouble(w[0])).filter(h -> h.getRent() < Double.parseDouble(w[1])).
                    filter(h -> h.getArea() >= Double.parseDouble(r[0])).filter(h -> h.getArea() < Double.parseDouble(r[1])).
                    filter(h -> h.getTypeid() == Integer.parseInt(tt)).
                    collect(Collectors.toList());
        }
        JSONObject obj = new JSONObject();
        obj.put("horse", horse);
        response.getWriter().println(obj);
    }
}
