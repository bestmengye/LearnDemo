package com.learn.mengye.io;

/**
 * @author MengYe
 * @desc 编码相关
 * @date 2019/12/3 18:16
 */
public class Encode {
    public static void main(String[] args) throws Exception{
        String m="孟野ABC";

        byte[] bytes = m.getBytes();
        //项目编码默认 utf-8 中文占3个字符 英文占1个
        for (byte aByte : bytes) {
            System.out.print(Integer.toHexString(aByte&0xff)+"  ");
        }
        System.out.println();
        byte[] bytes1 = m.getBytes("gbk");
        //gbk 中文占2个字符 英文占1个字符
        for (byte b : bytes1) {
            System.out.print(Integer.toHexString(b&0xff)+"  ");
        }
        System.out.println();
        //java 是双字节编码 utf-16be
        byte[] bytes2 = m.getBytes("utf-16be");
        //utf-16be 中文占2个字符  英文占2个字符
        for (byte b : bytes2) {
            System.out.print(Integer.toHexString(b&0xff)+"  ");
        }
        System.out.println();
        /**
         * 当你的字节数组是某种编码，转换成字符串也需要对应的编码格式
         */
        //默认项目编码 utf-8
        String s =new String(bytes);
        System.out.println(s);
        //bytes1是gbk编码 项目默认是使用utf-8 所以乱码
        String s1 =new String(bytes1);
        System.out.println(s1);






    }
}
