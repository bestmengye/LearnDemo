package com.learn.mengye.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author MengYe
 * @desc 学生类
 * @date 2019/11/20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Comparable<Student>, Serializable {

    private String stuNo;
    private Integer age;
    private String name;


    @Override
    public int compareTo(Student o) {
        //升序
        //return age.compareTo(o.getAge());
        return o.getAge().compareTo(age);
    }
}
