package com.lut.propertyleasing.controller;

import com.lut.propertyleasing.entity.UserEntity;
import com.lut.propertyleasing.service.IAgentService;
import com.lut.propertyleasing.service.impl.AgentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ApplyAgentServlet", value = "/ApplyAgentServlet")
public class ApplyAgentServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userid = ((UserEntity) request.getSession().getAttribute("USER")).getUserId();
        String phone = request.getParameter("phone");
        String name = request.getParameter("name");
        String workyears = request.getParameter("workyears");
        String certification = request.getParameter("certification");
        String describe = request.getParameter("describe");
        String showphone = request.getParameter("showphone");
        String communityid = request.getParameter("communityid");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String iDcard = request.getParameter("IDcard");
        String usernaem = request.getParameter("usernaem");
        String education = request.getParameter("education");
        String qq_number = request.getParameter("qq_number");
        IAgentService service = new AgentServiceImpl();
        boolean res = service.applyAgent(userid, phone, name, workyears, certification, describe, showphone, communityid, sex
                , age, iDcard, usernaem, education, qq_number);
        System.out.println(res);
        request.getRequestDispatcher("user_shenqing.jsp").forward(request, response);
    }
}
