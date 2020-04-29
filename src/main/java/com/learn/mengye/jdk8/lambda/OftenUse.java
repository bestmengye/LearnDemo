package com.learn.mengye.jdk8.lambda;

import com.learn.mengye.domain.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author mengye
 * @Desc java8常用方法
 * @date 2020/4/29 10:09
 */
public class OftenUse {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("4", 17, "小恒"));
        list.add(new Student("7", 20, "xtf"));
        list.add(new Student("3", 16, "程峰"));
        list.add(new Student("6", 22, "zrn"));
        list.add(new Student("1", 16, "孟野"));
        list.add(new Student("5", 17, "教授"));
        list.add(new Student("2", 16, "耿祥"));

        // 按照实体类中某个属性分组
        Map<Integer, List<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getAge));
        map.forEach((k, v) -> {
            System.out.println("分组" + k);
            v.forEach(e -> {
                System.out.println(e.toString());
            });
            System.out.println("================================");
        });

        System.out.println("-----------------排序------------------");
        List<Student> collect = list.stream().sorted(Comparator.comparing(Student::getAge,
                Comparator.nullsLast(Comparator.naturalOrder())).thenComparing(Student::getName)).collect(Collectors.toList());

        //循环
        collect.forEach(e->{
            System.out.println(e.toString());
        });

        //先按科目排序，科目相等的情况下再按照学生姓名排序，最后分组 要用LinkHashMap 作为容器存放
        /*List<Student> students1 = new ArrayList<>();
        Map<String, List<Student>> collect = students.stream().sorted(Comparator.comparing(Student::getSubject,
            Comparator.nullsLast(Comparator.naturalOrder())).thenComparing(Student::getName))
            .collect(Collectors.groupingBy(Student::getName,LinkedHashMap::new, Collectors.toList()));
        collect.values().forEach((List<Student> s)->students1.addAll(s));
        System.out.print(students1);*/


    }
}
