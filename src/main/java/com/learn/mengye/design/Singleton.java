package com.learn.mengye.design;

/**
 * @author mengye
 * @desc
 * @date 2020/8/25 10:09
 */
public class Singleton {

    // 静态内部类方式实现
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton(){
    }

    public static final Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

    /*// 双重检验锁机制
    private static Singleton singleton;
    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }

        }
        return singleton;
    }*/
}
