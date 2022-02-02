package com.wzz.algorithm.sort;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort3 {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70, -1, 900, 4561};
//测试快排的执行速度
// 创建要给 80000 个的随机的数组
//        int[] arr = new int[80000000];
//        for (int i = 0; i < 9; i++) {
//            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
//        }

        System.out.println("arr=" + Arrays.toString(arr));
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        quickSort(arr, 0, arr.length - 1);
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
        System.out.println("arr=" + Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
        int pivot, p_pos, i, t;

        if (low < high) {
            p_pos = low;
            pivot = arr[p_pos];
            for (i = low + 1; i <= high; i++) {
                if (arr[i] > pivot) {
                    p_pos++;
                    t = arr[p_pos];
                    arr[p_pos] = arr[i];
                    arr[i] = t;
                }

                t = arr[low];
                arr[low] = arr[p_pos];
                arr[p_pos] = t;

                quickSort(arr, low, p_pos - 1);
                quickSort(arr, p_pos + 1, high);
            }
        }
    }
}
