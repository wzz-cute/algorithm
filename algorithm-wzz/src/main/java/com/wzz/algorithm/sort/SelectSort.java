package com.wzz.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
//        int[] arr = new int[80000];
        int[] arr = new int[]{3, 1, 0, 9, 7, 10, 8, 45, -1, 90};
//        for (int i = 0; i < 80000; i++) {
//            arr[i] = (int) (Math.random() * 8000000); //生成一个[0, 8000000) 数
//        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();

        //测试冒泡排序
        selectSort(arr);

        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();


        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //定义数据，保存当前值
            int minNum = arr[i];
            int minIndex = i;

            //循环查找剩下最小值
            for (int j = i + 1; j < arr.length; j++) {
                //如果当前值小于当前保存的值
                if (arr[j] < minNum) {
                    minNum = arr[j];
                    minIndex = j;
                }
            }
            //判断  如果当前数组下标 不等于 开始保存的数组下标就交换值
            if (i == minIndex) {
                continue;
            }

            arr[minIndex] = arr[i];
            arr[i] = minNum;
        }
    }

}
