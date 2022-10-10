package com.lut.propertyleasing.entity;

/**
 * @Auther: Lkh
 * @Description:
 * @Date: 2022/10/04 20:44
 */
public class CountEntity {
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CountEntity{" +
                "count=" + count +
                '}';
    }
}
