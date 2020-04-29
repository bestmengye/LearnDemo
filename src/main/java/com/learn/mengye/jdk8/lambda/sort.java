package com.learn.mengye.jdk8.lambda;

import com.learn.mengye.domain.StudentOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author mengye
 * @Desc java8排序
 * @date 2020/4/29 11:09
 */
public class sort {
    public static void main(String[] args) {
        // main方法测试java8新特性
        Random random =new Random();
        List<StudentOrder> list2 = new ArrayList();
        for (int i = 0; i < 1000000; i++) {
            int age = random.nextInt(100) + 1;
            StudentOrder s = new StudentOrder(String.valueOf(i + 1), age, "孟野" + i);
            list2.add(s);
        }

        List<StudentOrder> list4 = new ArrayList();
        list4.addAll(list2);
        long start3 = System.currentTimeMillis();
        list4.stream().sorted((a, b) -> b.getAge().compareTo(a.getAge()));
        long end3 = System.currentTimeMillis();

        List<StudentOrder> list5 = new ArrayList();
        list5.addAll(list2);
        long start4 = System.currentTimeMillis();
        list5.stream().sorted((a, b) -> b.getAge().compareTo(a.getAge()));
        long end4 = System.currentTimeMillis();

        List<StudentOrder> list6 = new ArrayList();
        list6.addAll(list2);
        long start6 = System.currentTimeMillis();
        list6.stream().sorted((a, b) -> b.getAge().compareTo(a.getAge()));
        long end6 = System.currentTimeMillis();

        System.out.println((end3-start3));
        System.out.println((end4-start4));
        System.out.println((end6-start6));
    }
}
