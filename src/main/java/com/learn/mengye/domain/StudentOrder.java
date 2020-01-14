package com.learn.mengye.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;

/**
 * @author MengYe
 * @desc 学生类
 * @date 2019/11/20
 */
@Data
@AllArgsConstructor
public class StudentOrder implements Comparator<StudentOrder> {

    private String stuNo;
    private Integer age;
    private String name;

    @Override
    public int compare(StudentOrder o1, StudentOrder o2) {
        return o1.getAge().compareTo(o2.getAge());
    }
}
