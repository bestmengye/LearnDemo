package com.learn.mengye.io;

import java.io.*;
import java.nio.ByteBuffer;

/**
 * @author MengYe
 * @desc 字符流读取文件
 * @date 2019/12/10 15:10
 */
public class FileInputReader {
    public static void main(String[] args) throws IOException {
        File file=new File("F:\\test.txt");
        InputStreamReader reader=new InputStreamReader(new FileInputStream("F:\\test.txt"));
        System.out.println(reader.getEncoding());
        //System.out.println(file.length());,
        char[] chars=new char[1024];

        int read = reader.read();
        System.out.println(read);

        //FileInputStream in=new FileInputStream("F:\\test.txt");
//        int read1 = in.read();
        //in.read();

        BufferedReader bufferedReader=new BufferedReader(new FileReader("F:\\test.txt"));
        String s ;
        String content="";
        while ((s=bufferedReader.readLine())!=null){
            content+=s+"\n";
            bufferedReader.lines();
        }
        System.out.println(content);

       /* String string ="";
        int i ;
        while ((i=reader.read(chars,0,chars.length))!= -1 ){
            System.out.println(i);
            String s =new String(chars);
            string+=s;
        }
        System.out.println(string);*/

    }
}
