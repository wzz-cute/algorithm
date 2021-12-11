package com.wzz.algorithm.recursion;

/**
 * 计算1-100总和
 * <p>
 * 1.条件： 1-100总和
 * 1.1 最终值
 * <p>
 * 2.条件没有达到做什么
 * <p>
 * 3.如果达到做什么
 * <p>
 * 4.递归会造成内存溢出，注意循环穿次数
 */
public class SumOfOneToOneHundred {

    public static void main(String[] args) {
        SumOfOneToOneHundred s = new SumOfOneToOneHundred();
        System.out.println("1-100总和:" + s.calculation(0, 0));
    }

    public int calculation(int num, int count) {
        if (count == 10) {
            return num;
        }
        count++;
        return calculation(num + count, count);
    }

}
