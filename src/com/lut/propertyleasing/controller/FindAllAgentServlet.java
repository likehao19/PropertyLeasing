package com.lut.propertyleasing.controller;

import com.lut.propertyleasing.entity.AgentEntity;
import com.lut.propertyleasing.service.IAgentService;
import com.lut.propertyleasing.service.impl.AgentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindAllAgentServlet", value = "/FindAllAgentServlet")
public class FindAllAgentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IAgentService service = new AgentServiceImpl();
        List<AgentEntity> agents = service.findAllAgents();
        request.setAttribute("agents", agents);
        request.getRequestDispatcher("user_jingji.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
