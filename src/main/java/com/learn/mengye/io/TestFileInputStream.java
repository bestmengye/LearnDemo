package com.learn.mengye.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author mengye
 * @desc 字节输入流 : FileInputStream
 * @date 2021/3/25 15:23
 */
public class TestFileInputStream {

    public static void main(String[] args) {

        InputStream inputStream;
        try {
            inputStream = new FileInputStream("D:\\study\\LearnDemo\\src\\main\\java\\com\\learn\\mengye\\io\\TestFileInputStream.java");
            int b;

            int num = 0;
            while ((b = inputStream.read()) != -1) {
                System.out.print((char) b);
                num++;
            }
            System.out.println("读取成功！共读了" + num +"次");
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在！");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO异常！");
            e.printStackTrace();
        }


    }
}
