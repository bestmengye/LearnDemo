package com.learn.mengye.excel;

import com.learn.mengye.domain.Student;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author MengYe
 * @desc desc
 * @date 2019/12/18 14:12
 */
public class TestExcel {
    public static void main(String[] args) {

        File file=new File("D:\\commodity.xlsx");
        List<Commodity> result = ExcelParseHelper.parse(file, Commodity.class, true, 0);
        // 0进价 1 售价 3 数量
        for (Commodity commodity : result) {
            System.out.println("进价:"+commodity.getJinPrice()+",售价:"+commodity.getShowPrice()+",数量:"+commodity.getNum()+
                    ",总利润:"+(commodity.getShowPrice()-commodity.getJinPrice())*commodity.getNum());
        }
        System.out.println("-----------------排序后---------------------------");
        Collections.sort(result);
                /*,new Comparator<Commodity>(){
            @Override
            public int compare(Commodity o1, Commodity o2) {
                return (o1.getShowPrice()-o1.getJinPrice())*o1.getNum().compareTo((o2.getShowPrice()-o2.getJinPrice())*o2.getNum());
            }
        });*/
        for (Commodity commodity : result) {
            System.out.println("进价:"+commodity.getJinPrice()+",售价:"+commodity.getShowPrice()+",数量:"+commodity.getNum()+
                    ",总利润:"+(commodity.getShowPrice()-commodity.getJinPrice())*commodity.getNum());
        }
    }
}
