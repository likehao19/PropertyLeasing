/*
package com.lut.propertyleasing.uitls;

*/
/**
 * @Auther: Lkh
 * @Description:
 * @Date: 2022/10/07 22:14
 *//*


package com.example.newhp.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;


import org.apache.tomcat.util.http.fileupload.FileItem;
import org.springframework.web.multipart.MultipartFile;

public class UploadFileUtils {


    //  保存文件
    public synchronized static HashMap uploadFile(MultipartFile fileItem, String path, String secondPath) throws IOException {
        InputStream is = null;
        FileOutputStream fos = null;
        HashMap mp = new HashMap();
        try {
            //上传的是文件，获得文件上传字段中的文件名
            //注意IE或FireFox中获取的文件名是不一样的，IE中是绝对路径，FireFox中只是文件名。
            String fileName = fileItem.getName();
            System.out.println(fileName);
            // 文件类型
	       */
/*   String type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length())
	                    : null;*//*


            // 文件将保存路径
            String filePath = secondPath + getDateDir();
            String newPath = path + filePath;
            //文件名使用UUID和原文件名组成的
            // 为避免原文件名存在中文，新文件名只使用UUID作为新名称
            String newFileName = UUID.randomUUID().toString().replaceAll("-", "") + ".pdf";

            // 判断路径是否存在，如果不存在就创建一个
            File filepath = new File(newPath, newFileName);
            if (!filepath.getParentFile().exists())
                filepath.getParentFile().mkdirs();

            is = fileItem.getInputStream();
            fos = new FileOutputStream(newPath + newFileName);
            byte[] buff = new byte[1024];
            int len = 0;
            while ((len = is.read(buff)) > 0) {
                fos.write(buff);
            }

            mp.put("fileName", newFileName);
            mp.put("filePath", filePath);
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            is.close();
            fos.close();
        }
        return mp;
    }

    */
/**
     * 生成以时间作为文件夹路径
     *
     * @return
     *//*

    public static String getDateDir() {
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyyMM/dd/");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        return sdf.format(date);
    }


    */
/**
     * 更换pdf报告
     *
     * @return
     * @zpath=（更换文件，路径，盘符+文件夹+文件名）
     *//*

    public static Integer ghFile(MultipartFile file, String zpath) {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        System.err.println(zpath);
        try {
            File fileold = new File(zpath);
            if (fileold.exists()) {
                fileold.delete();
            }

            in = new BufferedInputStream(file.getInputStream());
            // 获取输出流
            out = new BufferedOutputStream(new FileOutputStream(zpath));

            // 读数据
            byte[] bb = new byte[1024];// 用来存储每次读取到的字节数组
            int n;// 每次读取到的字节数组的长度
            while ((n = in.read(bb)) != -1) {
                out.write(bb, 0, n);// 写入到输出流
            }
            out.flush();
            out.close();// 关闭流
            in.close();
            return 1;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return 0;
        }
    }

}

*/
