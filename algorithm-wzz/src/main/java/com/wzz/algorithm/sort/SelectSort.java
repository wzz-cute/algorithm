package com.wzz.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 选择排序
 * 第一次循环将整个数组的最小值换到下标0
 * 第二次循环将整个数组的最小值换到下标1
 * 第二次循环将整个数组的最小值换到下标2
 * 以此类推
 * 每次的循环都会减少一个元素，时间复杂度会减低
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[80000000];
        for (int i = 0; i < 80000000; i++) {
            arr[i] = (int) (Math.random() * 80000000); //生成一个[0, 8000000) 数
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);


        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) { // 说明假定的最小值，并不是最小
                    min = arr[j]; // 重置 min
                    minIndex = j; // 重置 minIndex
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

}
