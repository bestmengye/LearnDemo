package com.learn.mengye.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author mengye
 * @desc 字符输出流：FileWriter
 * @date 2021/3/25 16:04
 */
public class TestFileWriter {
    public static void main(String[] args) {
        FileWriter fileWriter = null;

        FileReader fileReader = null;
        int b;
        try {
            fileReader = new FileReader("D:\\file\\test\\FileCopy.txt");
            fileWriter = new FileWriter("D:\\file\\test\\testChineseNum.java");

            int num = 0;

            while ((b = fileReader.read()) != -1) {
                fileWriter.write(b);
                num++;
            }
            /*//写入从阿拉伯数字到...
            for (int i = 0; i < 20000; i++) {
                fileWriter.write(i);
            }*/


            fileWriter.flush();
            fileReader.close();
            fileWriter.close();
            System.out.println("拷贝成功！一共写入:" + num + "次");


            //  UTF-8类型: 一次读3个字节
            //       实验:
            //             1. 156个字节 无换行 52次  52*3 = 156
            //             2.(加入两个换行\n) 160个字节 56次 而56*3 =168个字节
            //       原因: 文字需要读52次  因为txt里面加入了两个换行符\n\n 多了四次 这里查阅资料分析后得到
            //       英文FileReader只读一个字节 保证字符的完整性文本的完整性
        } catch (IOException e) {
            System.out.println("文件写入失败！");
            e.printStackTrace();
        }


    }
}
