package com.learn.mengye.main;

import java.util.UUID;

/**
 * @author MengYe
 * @desc desc
 * @date 2020/1/14 17:29
 */
public class TestMain {
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
        UUID uuid = UUID.randomUUID();
        String replace = uuid.toString();
        System.out.println(replace);
    }
}
