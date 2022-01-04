package com.wzz.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ls
 * @date 2021/2/22 11:49
 * 快速排序
 *
 * 基本概念：
 *  会把数组中的一个作为基准数，一般会把数组中最左边的数当作基准数。
 *  然后从两边进行检索，先从右边开始检索比基准数小的，再从左边开始检索比基准数大的，如果检索到了就停下，交换这两个元素，然后
 *      再继续检索。
 *
 * 1、问题：
 *      （1）为什么要先从右边（基准数的对面）开始检索呢？
 *          如果从左边开始检索的话，那么i所停留的那个位置肯定是大于基准数的，因为左边是检索比基准数大的
 *          正确的是，从右边（基准数的对面）开始检索，那么j所停留的位置肯定是小于基准数的，因为右边是检索比基准数小的
 *          关键在于：i < j
 *
 *
 */
public class QuickSort2 {

    public static void main(String[] args) {
//        int[] arr = {3,2,10,9,7,22,8};
        int[] arr = new int[800000000];  //8亿  28s
        for (int i = 0; i < 800000000; i++) {
            arr[i] = (int) (Math.random() * 80000000); //生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        quickSort(arr,0,arr.length-1);


        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
    }

    /**
     * @param arr   排序的数组
     * @param left  左边开始比较的数
     * @param right 右边开始比较的数
     */
    public static void quickSort(int[] arr, int left, int right) {
        //如果开始的数大于结束的数，肯定不合法，直接结束方法
        if (left > right) {
            return;
        }
        //定义变量保存基准数
        int base = arr[left];
        //定义变量i，指向最左边
        int i = left;
        //定义变量j，指向最右边
        int j = right;

        //当i和j不相遇的时候，在循环中进行检索
        while (i != j) {
            //由j从右往左检索比基准数小的，如果检索到比基准数小的就停下。
            //如果检索到比基准数大的或者等于基准数的，就继续检索
            while (arr[j] >= base && i < j) {
                j--;
            }
            //由i从左往右边开始检索，找比基准数大的，如果比基准数小的就继续检索
            while (arr[i] <= base && i < j) {
                i++;
            }
            //代码走到这里，i停下了，j停下了，都找到对应的数字l，然后进行替换，小的给i，大的给j
            int temp = arr[i];  //把大的数给到临时变量
            arr[i] = arr[j];    //把小的数给到最左边
            arr[j] = temp;      //把临时变量的数给到最右边
        }

        //如果上面while循环的条件不成立，会跳出这个循环，往下执行
        //这个条件不成立就代表i和j相遇了
        //如果i和j相遇了，就交换基准数和元素相遇位置的元素
        //把相遇位置的元素赋值给基准数这个元素
        arr[left] = arr[i];
        //把基准数赋值给相遇的元素
        arr[i] = base;

        //基准数在这里就归位了，左边的数字都比他小，右边的数字都比他大
        //使用递归调用，排基准数的左边
        quickSort(arr,left,i-1);  //从数组中的第一个元素，到基准数前面的一个元素
        //排基准数的右边
        quickSort(arr,i+1,right);  //从基准数的后面一个元素，到数组的最后的一个元素

    }
}