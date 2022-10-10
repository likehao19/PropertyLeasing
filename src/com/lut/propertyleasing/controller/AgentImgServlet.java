package com.lut.propertyleasing.controller;

import com.alibaba.fastjson.JSONObject;
import com.lut.propertyleasing.entity.UserEntity;
import com.lut.propertyleasing.service.IAgentService;
import com.lut.propertyleasing.service.impl.AgentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "AgentImgServlet", value = "/AgentImgServlet")
public class AgentImgServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(123456789);
        request.setCharacterEncoding("utf-8"); //请求的编码
        response.setContentType("text/html; charset=utf-8"); //响应编码
        int userid = ((UserEntity) request.getSession().getAttribute("USER")).getUserId();
        Part file = request.getPart("file");
        //String p=request.
        String path = "E:\\File\\ideafiles\\PropertyLeasing\\web\\agent\\";
        /*String path = request.getServletContext().getRealPath("/upload/");*/
        System.out.println(file.getName());
        //创建File对象
        File f = new File(path);

        //返回的是上传的文件名称
        String fn = file.getSubmittedFileName();

        //判断上传是否为图片(拓展名是.jpg或者.png)
        if (fn.toLowerCase().endsWith(".jpg") || fn.toLowerCase().endsWith(".png")) {

            String nfn = userid + fn;

            file.write(path + "/" + nfn); //将文件写到物理磁盘

            String aimg = "agent/" + nfn;

            IAgentService service = new AgentServiceImpl();
            boolean res = service.imgUpload(userid, aimg);
            if (res) {
                JSONObject obj = new JSONObject();
                obj.put("file", aimg);
                response.getWriter().println(obj);
            }
        }

    }
}
