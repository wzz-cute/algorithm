package com.wzz.algorithm.my;

/**
 * 计算 1+2+3+4...+99+100 的和
 * <p>
 * 1+100=101
 * 2+99=101
 * 3+98=101
 */
public class A {
    public static void main(String[] args) {
        calculation(105);
    }

    /**
     * 计算 1+2+3+4...+99+100 的和
     * 1.将当前 传入最大的值减半
     * 2.算出他们 最小值 + 最大值 的和是什么
     * 3.循环 他们的减半值 累计第二步的总和
     *
     * @param i
     */
    private static void calculation(int i) {
        if (i % 2 == 0) {//偶数
            int num = i / 2;// 50
            int curr = 1 + i;// 101 101 101
            int total = 0;
            for (int j = 0; j < num; j++) {
                total += curr;
            }
            System.out.println(total);
            return;
        }

        /**
         * 1+2+...+100+101
         *
         * 1+2+...+104+105
         */
        int num = (i - 1) / 2;//101-1 = 100
        int curr = 1 + (i - 1);//1=100 = 101  2+99= 101  3+98 = 101
        int total = 0;
        for (int j = 0; j < num; j++) {
            total += curr;
        }
        total += i;
        System.out.println(total);

    }
}
