package com.learn.mengye.tests;

/**
 * @author MengYe
 * @desc main方法测试类
 * @date 2019/12/2 11:19
 */
public final class Vehcile {


    public void meth1()throws Exception{
        throw new RuntimeException();
    }
    public void meth2(){

        try {
            meth1();
        }catch (RuntimeException e){
            System.out.println("RuntimeException");
        }catch (Exception e){
            System.out.println("Exception");
        }
    }
    public static void main(String[] args) {
        Vehcile v=new Vehcile();
        v.meth2();




    }
}
