package com.lut.propertyleasing.controller;

import com.alibaba.fastjson.JSONObject;
import com.lut.propertyleasing.entity.UserEntity;
import com.lut.propertyleasing.service.IUserService;
import com.lut.propertyleasing.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 上传头像
 */
@WebServlet(name = "UploadImgServlet", value = "/UploadImgServlet")
@MultipartConfig(maxFileSize = 1024 * 1024 * 2)
public class UploadImgServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");  //请求的编码
        response.setContentType("text/html; charset=utf-8");  //响应编码
        int userid = ((UserEntity) request.getSession().getAttribute("USER")).getUserId();
        Part file = request.getPart("file");
        //String p=request.
        String path = "E:\\File\\ideafiles\\PropertyLeasing\\web\\upload\\";
        /*String path = request.getServletContext().getRealPath("/upload/");*/
        System.out.println(file.getName());
        //创建File对象
        File f = new File(path);

        //返回的是上传的文件名称
        String fn = file.getSubmittedFileName();

        //判断上传是否为图片(拓展名是.jpg或者.png)
        if (fn.toLowerCase().endsWith(".jpg") || fn.toLowerCase().endsWith(".png")) {
            //生成文件新名字  年月日时分秒+源文件名字
            String nfn = userid + fn;
            //  String nfn = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()) + fn;
            file.write(path + "/" + nfn); //将文件写到物理磁盘
            System.out.println("nfn" + nfn);

            String fileName = "upload/" + nfn;
            System.out.println("文件名" + fileName);

            IUserService service = new UserServiceImpl();
            boolean res = service.uploadImg(fileName, userid);
            System.out.println("res" + res);
            if (res) {
                JSONObject obj = new JSONObject();
                obj.put("file", fileName);
                response.getWriter().println(obj);
                /* request.setAttribute("file", fileName);*/
                /*request.setAttribute("file",fileName );*/ //将文件名保存到请求属性中
            }
        } else {
            JSONObject obj = new JSONObject();
            obj.put("file", "文件上传失败，必须为jpg或png图像文件");
            response.getWriter().println(obj);
            /* request.setAttribute("file", "文件上传失败，必须为jpg或png图像文件")*/
            ;
        }
    }
}
