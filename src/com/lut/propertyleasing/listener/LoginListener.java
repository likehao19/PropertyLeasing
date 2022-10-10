package com.lut.propertyleasing.listener;

import com.lut.propertyleasing.service.ICountService;
import com.lut.propertyleasing.service.IUserService;
import com.lut.propertyleasing.service.impl.CountServiceImpl;
import com.lut.propertyleasing.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class LoginListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    //默认在线人数
    private Integer onlineNum;

    public LoginListener() {
    }

    ICountService service = new CountServiceImpl();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        //启动服务初始化人次
        ServletContext application = sce.getServletContext();
        int count = service.countUsers();
        application.setAttribute("count", count);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
        ServletContext application = sce.getServletContext();
        Integer count = (Integer) application.getAttribute("count");
        service.updateCount(count);

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }
}
