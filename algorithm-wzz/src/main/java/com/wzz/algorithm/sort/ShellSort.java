package com.wzz.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = {4, 8, 5, 7, 3, 0, 1, 2};
//        System.out.println("          原本=:" + Arrays.toString(arr));

        int[] arr = new int[80000000];  //8亿  28s
        for (int i = 0; i < 80000000; i++) {
            arr[i] = (int) (Math.random() * 80000000); //生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

//        shellSort2(arr);
        shellSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);

//        System.out.println("        排序后=:" + Arrays.toString(arr));
    }

    /**
     * 交换法
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;

        for (int i = arr.length / 2; i > 0; i /= 2) {
            for (int j = i; j < arr.length; j++) {
                if (arr[j - i] > arr[j]) {
                    temp = arr[j - i];
                    arr[j - i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
//        // 根据前面的逐步分析，使用循环处理
//        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
//            for (int i = gap; i < arr.length; i++) {
//// 遍历各组中所有的元素(共 gap 组，每组有个元素), 步长 gap
//                for (int j = i - gap; j >= 0; j -= gap) {
//// 如果当前元素大于加上步长后的那个元素，说明交换
//                    if (arr[j] > arr[j  + gap]) {
//                        temp = arr[j];
//                        arr[j] = arr[j + gap];
//                        arr[j + gap] = temp;
//                    }
//                }
//            }
//////System.out.println("希尔排序第" + (++count) + "轮 =" + Arrays.toString(arr));
//        }

// 希尔排序的第 1 轮排序
// 因为第 1 轮排序，是将 10 个数据分成了 5 组
//        for (int i = 4; i < arr.length; i++) {
//// 遍历各组中所有的元素(共 5 组，每组有 2 个元素), 步长 5
//
//            if (arr[i - 4] > arr[i]) {
//                temp = arr[i - 4];
//                arr[i - 4] = arr[i];
//                arr[i] = temp;
//            }
//
////            for (int j = i - 4; j >= 0; j -= 4) {
////// 如果当前元素大于加上步长后的那个元素，说明交换
////                if (arr[j] > arr[j + 4]) {
////                    temp = arr[j];
////                    arr[j] = arr[j + 4];
////                    arr[j + 4] = temp;
////                }
////            }
//        }
//        System.out.println("希尔排序 1 轮后=" + Arrays.toString(arr));//
//
//// 希尔排序的第 2 轮排序
//// 因为第 2 轮排序，是将 10 个数据分成了 5/2 = 2 组
//        for (int i = 2; i < arr.length; i++) {
//// 遍历各组中所有的元素(共 5 组，每组有 2 个元素), 步长 5
//
//            if (arr[i - 2] > arr[i]) {
//                temp = arr[i - 2];
//                arr[i - 2] = arr[i];
//                arr[i] = temp;
//            }
//
////            for (int j = i - 2; j >= 0; j -= 2) {
////// 如果当前元素大于加上步长后的那个元素，说明交换
////                if (arr[j] > arr[j + 2]) {
////                    temp = arr[j];
////                    arr[j] = arr[j + 2];
////                    arr[j + 2] = temp;
////                }
////            }
//        }
//        System.out.println("希尔排序 2 轮后=" + Arrays.toString(arr));//

    }

    //对交换式的希尔排序进行优化->移位法
    public static void shellSort2(int[] arr) {
// 增量 gap, 并逐步的缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
// 从第 gap 个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
//移动
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
//当退出 while 后，就给 temp 找到插入的位置
                    arr[j] = temp;
                }
            }
        }
    }
}
