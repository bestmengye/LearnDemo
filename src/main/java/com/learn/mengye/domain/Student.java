package com.learn.mengye.domain;

import com.learn.mengye.excel.ExcelProperty;
import lombok.Data;

/**
 * @author MengYe
 * @desc 学生类
 * @date 2019/11/20
 */
@Data
public class Student {

    @ExcelProperty(index = 0)
    private String stuNo;
    @ExcelProperty(index = 1)
    private Integer age;
    @ExcelProperty(index = 2)
    private String name;
}
