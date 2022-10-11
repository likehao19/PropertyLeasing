package com.lut.propertyleasing.controller;

import com.alibaba.fastjson.JSONObject;
import com.lut.propertyleasing.entity.UserEntity;
import com.lut.propertyleasing.service.IUserService;
import com.lut.propertyleasing.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

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
        String path = "E:\\File\\ideafiles\\PropertyLeasing\\web\\upload\\";
        File f = new File(path);

        String fn = file.getSubmittedFileName();

        if (fn.toLowerCase().endsWith(".jpg") || fn.toLowerCase().endsWith(".png")) {
            String nfn = userid + fn;
            file.write(path + "/" + nfn);
            System.out.println("nfn" + nfn);

            String fileName = "upload/" + nfn;

            IUserService service = new UserServiceImpl();
            boolean res = service.uploadImg(fileName, userid);
            if (res) {
                JSONObject obj = new JSONObject();
                obj.put("file", fileName);
                response.getWriter().println(obj);

            }
        } else {
            JSONObject obj = new JSONObject();
            obj.put("file", "文件上传失败，必须为jpg或png图像文件");
            response.getWriter().println(obj);
        }
    }
}
