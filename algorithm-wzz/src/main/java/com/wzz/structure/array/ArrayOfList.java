package com.wzz.structure.array;

import java.util.Scanner;

/**
 * 使用数组实现一个列表
 */
public class ArrayOfList {
    public static void main(String[] args) {
        ArrayController ac = new ArrayController(8);
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("请操作数组");
            System.out.println("a(添加数组)");
            System.out.println("g(获取数组一个值)");
            System.out.println("s(查看当前数组)");
            System.out.println("e(退出程序)");
            System.out.println("请输入:");

            String next = scanner.next();
            switch (next) {
                case "a":
                    System.out.println("请输入一个值");
                    int insertNum = scanner.nextInt();
                    ac.add(insertNum);
                    break;
                case "g":
                    ac.get();
                    break;
                case "s":
                    ac.showArr();
                    break;
                case "sort":
                    ac.insertSort();
                    break;
                case "e":
                    System.exit(1);
                    break;
                default:
                    System.out.println("操作有误");
            }

        } while (true);

    }

    /**
     * 数组控制台
     */
    static class ArrayController {
        int[] arr; //存储数据
        int maxSize; //最大长度
        int fromIndex;//开始下标
        int toIndex;//尾坐标

        public ArrayController(int maxSize) {
            this.maxSize = maxSize;
            arr = new int[maxSize];
            fromIndex = -1;
            toIndex = -1;
        }

        public boolean isEmpty() {
//            return toIndex == -1 || fromIndex == maxSize - 1;
            return toIndex == -1;
        }

        public boolean isFull() {
            return toIndex == arr.length - 1 || fromIndex == arr.length - 1;
        }

        public void showArr() {
            for (int i = fromIndex; i < toIndex; i++) {
                System.out.print(arr[i + 1] + ",");
            }
            System.out.println();
        }

        public void add(int insertNum) {
            if (isFull()) {
                System.out.println("数组已满");
                return;
            }
            toIndex++;
            arr[toIndex] = insertNum;
        }

        public void get() {
            if (isEmpty()) {
                System.out.println("当前数组是空的");
                return;
            }
            if (fromIndex + 1 == maxSize) {
                fromIndex = -1;
            }
            fromIndex++;
            System.out.println(arr[fromIndex]);
        }

        public void insertSort() {
            int arrVal;
            int insertIndex;
            for (int i = 1; i <= toIndex; i++) {
                arrVal = arr[i];
                insertIndex = i - 1;

                while (insertIndex >= 0 && arrVal < arr[insertIndex]) {
                    arr[insertIndex + 1] = arr[insertIndex];
                    arr[insertIndex] = arrVal;

                    insertIndex--;
                }
            }
        }

    }

}




