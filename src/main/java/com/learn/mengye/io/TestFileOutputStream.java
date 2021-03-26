package com.learn.mengye.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author mengye
 * @desc
 *      字节输入流：FileInputStream
 *      字节输出流：FileOutputStream
 * @date 2021/3/25 15:48
 */
public class TestFileOutputStream {

    public static void main(String[] args) {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        int b;
        try {
            fileInputStream = new FileInputStream("D:\\study\\LearnDemo\\src\\main\\java\\com\\learn\\mengye\\io\\TestFileOutputStream.java");
            fileOutputStream = new FileOutputStream("D:\\file\\test\\TestFileOutputStream.java");

            int num = 0;
            while ((b = fileInputStream.read()) != -1) {
                fileOutputStream.write(b);
                num++;
            }
            System.out.println("拷贝成功!");
            System.out.println("一共读写了:" + num+"次");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("没有找到文件");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
