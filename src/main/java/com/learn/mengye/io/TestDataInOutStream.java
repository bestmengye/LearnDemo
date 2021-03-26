package com.learn.mengye.io;

import java.io.*;

/**
 * @author mengye
 * @desc 数据流：
 * 数据输入流：DataInputStream
 * 数据输出流：DataOutputStream
 * 先进先出 像队列一样
 * 写入的是 double boolean  读取的时候要按照 double boolean
 * @date 2021/3/26 16:20
 */
public class TestDataInOutStream {
    public static void main(String[] args) {

        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        try {

            dataOutputStream = new DataOutputStream(new FileOutputStream("D:\\study\\LearnDemo\\src\\main\\java\\com\\learn\\mengye\\io\\TestDataInOutStream.java"));
            dataInputStream = new DataInputStream(new FileInputStream("D:\\file\\test\\TestDataInOutStream.java"));

            dataOutputStream.writeDouble(Math.random());
            dataOutputStream.writeBoolean(true);

            double v = dataInputStream.readDouble();
            System.out.println(v);
            boolean b = dataInputStream.readBoolean();
            System.out.println(b);

            dataInputStream.close();
            dataOutputStream.close();
            System.out.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("");
            e.printStackTrace();
        }


    }
}
