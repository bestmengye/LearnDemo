package com.learn.mengye.io;

import java.io.*;

/**
 * @author mengye
 * @desc 转换流： 转换输入流:InputStreamReader  将字节输入流转换成字符输入流
 * @date 2021/3/26 15:02
 */
public class TestInputStreamReader {
    public static void main(String[] args) {
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;

        try {
            inputStreamReader = new InputStreamReader(new FileInputStream("D:\\study\\LearnDemo\\src\\main\\java\\com\\learn\\mengye\\io\\TestInputStreamReader.java"));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String s;
            int num = 0;
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
                bufferedReader.lines();
                num++;
            }
            System.out.println("读取成功！共读取：" + num + "次");
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("文件找不到!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("文件读取失败！");
            e.printStackTrace();
        }


    }
}
