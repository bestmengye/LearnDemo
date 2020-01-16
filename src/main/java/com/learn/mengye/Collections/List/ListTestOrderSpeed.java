package com.learn.mengye.collections.List;

import com.learn.mengye.domain.Student;
import com.learn.mengye.domain.StudentOrder;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author MengYe
 * @desc List排序几种方法比较
 * @date 2020/1/15 9:39
 */
public class ListTestOrderSpeed {
    public static void main(String[] args) {

        for (int k = 0; k < 20; k++) {
            /** 实现comparable接口排序 **/
            Random random = new Random();
            List<Student> list = new ArrayList();
            int count = 1300000;
            for (int i = 0; i < count; i++) {
                int age = random.nextInt(100);
                Student s = new Student();
                s.setAge(age);
                s.setName("孟野" + i);
                s.setStuNo(String.valueOf(i));
                list.add(s);
            }

            List<StudentOrder> list2 = new ArrayList();
            for (int i = 0; i < count; i++) {
                int age = random.nextInt(100) + 1;
                StudentOrder s = new StudentOrder(String.valueOf(i + 1), age, "孟野" + i);
                list2.add(s);
            }

//        System.out.println("1.实现comparable接口排序后");
            long start1 = System.currentTimeMillis();
            Collections.sort(list);
            long end1 = System.currentTimeMillis();
//        list.forEach((a)-> System.out.println(a));

//        System.out.println("2.实现comparator接口排序-------------");
            List<StudentOrder> list3 = new ArrayList();
            list3.addAll(list2);
            long start2 = System.currentTimeMillis();
            Collections.sort(list3, list3.get(0));
            long end2 = System.currentTimeMillis();
//        list3.forEach((a)-> System.out.println(a));


//        System.out.println("3.java8的新特性-------------");
            List<StudentOrder> list4 = new ArrayList();
            list4.addAll(list2);
            long start3 = System.currentTimeMillis();
//        list4.stream().sorted((a,b)-> b.getAge().compareTo(a.getAge())).forEach(System.out::println);
            list4.stream().sorted((a, b) -> b.getAge().compareTo(a.getAge()));
            long end3 = System.currentTimeMillis();

            System.out.println("1.实现comparable接口排序:" + (end1 - start1) + "ms、2.实现comparator接口排序:" + (end2 - start2) + "ms " +
                    "、3.java8的新特性排序:" + (end3 - start3) + "ms");
        }


        /**
         * 总结:
         * 1.13-14W的数据  38-46ms  comparator接口>comparable接口>java8新特性
         * 2.15W以后的数据 包括多次排序 java8新特性完胜 且java8的新特性 会有缓存流记录，后续则会有此类排序则不消耗时间
         **/
    }
}
