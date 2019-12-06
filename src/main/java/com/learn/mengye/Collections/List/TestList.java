package com.learn.mengye.Collections.List;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MengYe
 * @desc List操作
 * @date 2019/12/5 10:33
 */
public class TestList {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        boolean contains = list.contains(3);
        System.out.println(contains);


    }
}
