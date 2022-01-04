package com.wzz.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
//                int[] arr = new int[80000];
        int[] arr = new int[]{3, 1, 4, 0, 8, 5, 9, 90, 57, 56, 8, 23, 67, 81, 12};
//        for (int i = 0; i < 80000; i++) {
//            arr[i] = (int) (Math.random() * 8000000); //生成一个[0, 8000000) 数
//        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();

        //测试冒泡排序
        insertSort(arr);

        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();


        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
    }

    private static void insertSort(int[] arr) {
        //记录当前数与下标
        int insertNum = 0;
        int insertIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            insertNum = arr[i];
            insertIndex = i - 1;

            //如果当前的值小于前面一位
            while (insertIndex >= 0 && insertNum < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                arr[insertIndex] = insertNum;
                insertIndex--;
//                if (insertIndex + 1 == i) {
//                    continue;
//                }
            }

        }

    }
}
