package com.learn.mengye.other;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author MengYe
 * @desc java保留小数 小数的处理
 * @date 2020/1/10 16:27
 */
public class SmallNumber {
    public static void main(String[] args) {
        float f=0.154F;

        /** 保留小数的几种方法 **/
        /** 1.使用DecimalFormat **/
        DecimalFormat df =new DecimalFormat("#.00");
        System.out.println(df.format(f));

        /** 2.使用Stringformat 四舍五入 **/
        String s =String.format("%.1f",f) ;
        System.out.println(s);

        /** 3.使用BigDecimal  四舍五入:BigDecimal.ROUND_CEILING 舍去BigDecimal.ROUND_DOWN **/
        BigDecimal bigDecimal=new BigDecimal(f);
        BigDecimal decimal = bigDecimal.setScale(1, BigDecimal.ROUND_DOWN);
        System.out.println(decimal.toString());


    }
}
