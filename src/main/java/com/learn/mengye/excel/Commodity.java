package com.learn.mengye.excel;

import java.util.Comparator;
import java.util.Objects;

/**
 * @author MengYe
 * @desc desc
 * @date 2019/12/18 14:27
 */
//商品表
public class Commodity implements Comparable<Commodity>{

    @ExcelProperty(index = 0)
    private Integer jinPrice;
    @ExcelProperty(index = 1)
    private Integer showPrice;
    @ExcelProperty(index = 2)
    private Integer num;

    public Integer getJinPrice() {
        return jinPrice;
    }

    public void setJinPrice(Integer jinPrice) {
        this.jinPrice = jinPrice;
    }

    public Integer getShowPrice() {
        return showPrice;
    }

    public void setShowPrice(Integer showPrice) {
        this.showPrice = showPrice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commodity commodity = (Commodity) o;
        return Objects.equals(jinPrice, commodity.jinPrice) &&
                Objects.equals(showPrice, commodity.showPrice) &&
                Objects.equals(num, commodity.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jinPrice, showPrice, num);
    }

    @Override
    public int compareTo(Commodity o) {
        return (this.showPrice-this.jinPrice)*num.compareTo((o.getShowPrice()-o.getJinPrice())*o.getNum());
    }
}
