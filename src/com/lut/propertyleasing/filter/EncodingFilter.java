package com.lut.propertyleasing.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter", urlPatterns = "/*")
public class EncodingFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;  //请求对象
        HttpServletResponse rep = (HttpServletResponse) response; //响应对象
        req.setCharacterEncoding("utf-8"); //请求编码
        rep.setContentType("text/html;charset=utf-8"); //响应编码
        chain.doFilter(request, response); //放行
    }
}
