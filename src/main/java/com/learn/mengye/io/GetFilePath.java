package com.learn.mengye.io;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.net.URL;
import java.util.Random;

/**
 * @author MengYe
 * @desc 文件类、获取当前项目路径
 * @date 2019/12/5 9:40
 */
public class GetFilePath {

    /**
     * 获取当前项目路径的几种方式
     */
    public void getDemoPath()throws IOException {
        String path = getClass().getResource("").getPath();
        System.out.println("第一种:"+path);

        URL xmlpath = getClass().getClassLoader().getResource("text.txt");
        System.out.println("第二种:"+xmlpath);

        String property = System.getProperty("java.class.path");
        System.out.println("第三种:"+property);

        File file=new File("");
        File canonicalFile = file.getCanonicalFile();
        System.out.println("第四种:"+canonicalFile);

        String property1 = System.getProperty("user.dir");
        System.out.println("第五种:"+property1);
    }

    public static void main(String[] args) throws Exception {
        GetFilePath getFilePath=new GetFilePath();
        getFilePath.getDemoPath();

        /*
        使用buffreader读取文件
        String str = "";
        String s;
        BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/main/resources/text.txt"));
        while ((s=reader.readLine()) != null) {
            str += s+"\n";
        }
        System.out.println(str);*/

    }
}
