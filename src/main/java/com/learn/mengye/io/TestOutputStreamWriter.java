package com.learn.mengye.io;

import java.io.*;

/**
 * @author mengye
 * @desc 转换流： 转换输出流 OutputStreamWriter 将字节输出流转换成字符输出流
 * @date 2021/3/26 15:37
 */
public class TestOutputStreamWriter {
    public static void main(String[] args) {

        OutputStreamWriter outputStreamWriter = null;
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream("D:\\study\\LearnDemo\\src\\main\\java\\com\\learn\\mengye\\io\\TestOutputStreamWriter.java"));
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream("D:\\file\\test\\TestOutputStreamWriter.java",true));

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);


            String s;
            int num = 0;
            while ((s = bufferedReader.readLine()) != null) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
                num++;
            }

            System.out.println("复制成功！一共读写:" + num + "次");
            inputStreamReader.close();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("文件没有找到！");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("文件读取失败！");
            e.printStackTrace();
        }

    }
}
