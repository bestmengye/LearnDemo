package com.learn.mengye.collections.List;

import org.apache.poi.ss.formula.functions.T;

import java.util.*;

/**
 * @author MengYe
 * @desc List去重的几种方法
 * @date 2020/1/14 17:28
 */
public class ListDuplicateRemoval {
    public static void main(String[] args) {


        List<String> list = new ArrayList<>();
        for (int i = 0; i < 200000; i++) {
            Double random = Math.random() * 100;
            list.add(String.valueOf(random.intValue()));
        }
        System.out.println("list去重效率对比:");
        System.out.println("hashSet(有序、无序)>treeSet>listContains>双重for(超级慢)");
        for (int i = 0; i < 20; i++) {
            List<String> list1 = new ArrayList<>();
            list1.addAll(list);
//            System.out.println("1.两层for循环--------------");
            long start1 = System.currentTimeMillis();
//        secondFor(list1).forEach((a)-> System.out.println(a));
            secondFor(list1);
            long end1 = System.currentTimeMillis();

//            System.out.println("2.使用hashSet踢出(无序)--------------");
            List<String> list2 = new ArrayList<>();
            list2.addAll(list);
            long start2 = System.currentTimeMillis();
//        set(list2).forEach((a)-> System.out.println(a));
            set(list2);
            long end2 = System.currentTimeMillis();

//            System.out.println("3.使用hashSet踢出(有序)--------------");
            List<String> list3 = new ArrayList<>();
            list3.addAll(list);
            long start3 = System.currentTimeMillis();
//        setOrder(list3).forEach((a)-> System.out.println(a));
            setOrder(list3);
            long end3 = System.currentTimeMillis();

//            System.out.println("4.使用hashSet踢出(无序)--------------");
            List<String> list4 = new ArrayList<>();
            list4.addAll(list);
            long start4 = System.currentTimeMillis();
//        treeSetOrder(list4).forEach((a)-> System.out.println(a));
            treeSetOrder(list4);
            long end4 = System.currentTimeMillis();

//            System.out.println("5.使用list的contains方法循环去重--");
            List<String> list5 = new ArrayList<>();
            list5.addAll(list);
            long start5 = System.currentTimeMillis();
//        listContains(list5).forEach((a)-> System.out.println(a));
            listContains(list5);
            long end5 = System.currentTimeMillis();

            System.out.println("1.双重for:" + (end1 - start1) + "ms 、2.HashSet无序:" + (end2 - start2) + "ms 、3.HashSet有序:" + (end3 - start3) + "" +
                    "ms 、4.HashSet提出(无序):" + (end4 - start4) + "ms 、5.listContains:" + (end5 - start5));
        }
    }

    /* 1.两层for循环判断去重 */
    public static List<String> secondFor(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    list.remove(j);
                }
            }
        }
        return list;
    }

    /* 2.使用HashSet无序踢出*/
    public static List<String> set(List<String> list) {
        Set set = new HashSet(list);
        list.clear();
        list.addAll(set);
        return list;
    }

    /* 3.使用HashSet踢出 有序 */
    public static List<String> setOrder(List<String> list) {
        Set sortSet = new HashSet();
        List<String> listOrder = new ArrayList();
        for (String t : list) {
            if (sortSet.add(t)) {
                listOrder.add(t);
            }
        }
        return listOrder;
    }

    /* 4.使用HashSet踢出无序 */
    public static List<String> treeSetOrder(List<String> list) {
        Set<String> sortSet = new TreeSet(list);
        list.clear();
        list.addAll(sortSet);
        return list;
    }

    /* 5.使用list的contains方法循环去重 */
    public static List<String> listContains(List<String> list) {
        List<String> newList = new ArrayList();
        for (String t : list) {
            if (!newList.contains(t)) {
                newList.add(t);
            }
        }
        return newList;
    }
}
