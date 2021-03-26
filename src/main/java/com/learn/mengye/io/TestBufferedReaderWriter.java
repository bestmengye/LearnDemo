package com.learn.mengye.io;

import java.io.*;

/**
 * @author mengye
 * @desc 缓存流:
 *  *          输入流：BufferedReader
 *  *          输出流：BufferedWriter
 * @date 2021/3/26 10:29
 */
public class TestBufferedReaderWriter {
    public static void main(String[] args) {

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            bufferedReader = new BufferedReader(new FileReader("D:\\study\\LearnDemo\\src\\main\\java\\com\\learn\\mengye\\io\\TestBufferedReaderWriter.java"));
            bufferedWriter = new BufferedWriter(new FileWriter("d:\\file\\test\\TestBufferedReaderWriter.java"));

            String s;
            int num = 0;
            while ((s = bufferedReader.readLine()) != null) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
                num++;
            }

            bufferedWriter.flush();
            bufferedWriter.close();


            bufferedReader.close();
            System.out.println("读取成功！一共读取了" + num + "次。");
        } catch (FileNotFoundException e) {
            System.out.println("文件找不到!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("读取文件异常!");
            e.printStackTrace();
        }

    }
}
