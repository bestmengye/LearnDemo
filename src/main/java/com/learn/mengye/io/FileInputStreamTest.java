package com.learn.mengye.io;

import java.io.*;

/**
 * @author MengYe
 * @desc 字节流读取一个文件
 * @date 2019/12/6 16:43
 */
public class FileInputStreamTest {
    public static void main(String[] args) {

        try {
            /**
             * 读取一个txt文件并放入一个String
             * 1.使用FileInputStream 读到一个bytes[]中 转成String的时候设置编码格式
             *
             * 2.使用BufferedReader 读到临时字符串中 在InputStreamReader中设置编码格式
             *
             */
            File file = new File("F:\\file.txt");
            FileInputStream in=new FileInputStream(file);

            byte[] bytes=new byte[(int) file.length()];
            in.read(bytes);


            String s =new String(bytes,"gbk");
            System.out.println(s);
            in.close();

            /*BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream(file),"gbk"));
            String str="";
            String s=new String();

            while ((s=bufferedReader.readLine())!=null ){
                str+=s+"\n";
            }
            System.out.println(str);
            bufferedReader.close();*/
            mengye:
            while (true){
                System.out.println(1);
                for (;;) {
                    System.out.println("for的死循环");
                    yes:
                    for (int i = 0 ;i<6;i++){
                        System.out.println(i);
                        if(i==5){
                            break mengye;
                        }
                    }
                    System.out.println("mengye");
                    break mengye;

                }
            }
            System.out.println("执行完毕");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
