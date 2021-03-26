package com.learn.mengye.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author mengye
 * @desc 字符流输入流：FileReader
 * @date 2021/3/25 15:57
 */
public class TestFileReader {
    public static void main(String[] args) {

        FileReader fileReader = null;
        int b;
        try {
            fileReader = new FileReader("D:\\study\\LearnDemo\\src\\main\\java\\com\\learn\\mengye\\io\\TestFileReader.java");
            int num = 0;
            while ((b = fileReader.read()) != -1) {
                System.out.print((char) b);
                num++;
            }
            System.out.println("读取文件成功!共读取了:" + num + "次");
        } catch (FileNotFoundException e) {
            System.out.println("文件没找到！");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("文件读取失败！");
            e.printStackTrace();
        }

    }
}
