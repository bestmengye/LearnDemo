package com.learn.mengye.collections.List;

import com.learn.mengye.domain.Student;
import com.learn.mengye.domain.StudentOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author MengYe
 * @desc List排序、对象排序
 * @date 2019/11/20
 */
public class ListOrder {
    public static void main(String[] args) {

        List<Student> studentList=new ArrayList<>();
        studentList.add(new Student("001",23,"耿祥"));
        studentList.add(new Student("002",16,"孟野"));
        studentList.add(new Student("003",79,"程峰"));
        studentList.add(new Student("004",18,"肖恒"));
        studentList.add(new Student("005",15,"小明"));

        /** list 排序的几种方法 **/
        /* 1.使用Collections.sort方法  需要实现Comparable接口  */
        System.out.println("实现Comparable接口排序前----------------------");
        studentList.forEach((student)-> System.out.println(student.toString()));
        System.out.println("实现Comparable接口排序后----------------------");
        studentList.forEach((student)-> System.out.println(student.toString()));


        /* 2.使用Collections.sort方法  需要实现Comparable接口 */
        List<StudentOrder> list2=new ArrayList<>();
        list2.add(new StudentOrder("001",23,"耿祥"));
        list2.add(new StudentOrder("002",16,"孟野"));
        list2.add(new StudentOrder("003",79,"程峰"));
        list2.add(new StudentOrder("004",18,"肖恒"));
        list2.add(new StudentOrder("005",15,"小明"));
        System.out.println("Collections.sort:排序前----------------------");
        list2.forEach((studentOrder)-> System.out.println(studentOrder.toString()));
        System.out.println("Collections.sort:排序后----------------------");
        Collections.sort(list2,new StudentOrder("001",23,"耿祥"));
        list2.forEach((studentOrder)-> System.out.println(studentOrder.toString()));

        /* 3.使用java8新特性排序 */
        List<StudentOrder> list3=new ArrayList<>();
        list3.add(new StudentOrder("00345",23,"耿祥"));
        list3.add(new StudentOrder("00455",16,"孟野"));
        list3.add(new StudentOrder("00656",79,"程峰"));
        list3.add(new StudentOrder("00656",18,"肖恒"));
        list3.add(new StudentOrder("00655",15,"小明"));
        System.out.println("新特性排序前:------b---------------");
        list3.forEach((a)-> System.out.println(a.toString()));
        System.out.println("新特性排序后------b---------------");
        list3.stream().sorted((a,b)-> b.getAge().compareTo(a.getAge())).forEach(System.out::println);
    }
}
