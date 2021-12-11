package com.wzz.algorithm.recursion;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 计算从独身数开始到十全十美数
 * 独身数  没有自幂数  水仙花数  四叶玫瑰数  五角星数  六合数  北斗七星数  八仙数  九九重阳数  十全十美数
 * <p>
 * 递归规则 ：
 * 1.确定他们的结束点  比如循环list  判断当前的count 是否达到当前list.size()  如果达到了就跳出
 * 2.如果他们没有结束 那么做什么
 * 3.注意条件增加，如果本次循环结束，count记得自增或者。。。 否则会死循环
 * 4.递归不能递归过多，每一次递归都是调用一次方法，都会压入栈中，会造成内存溢出
 */
public class SelfIdempotent {
    public static void main(String[] args) {
        Integer minDigit = 1;//最小位数
        Integer maxDigit = 10;//最大位数

        //当前最小位数
        Integer currMinNum = 1;

        //当前最大位数
        StringBuilder sb = new StringBuilder("");

        //list存放 位数 数组  数组存放具体自幂数
        List<List<Integer>> nums = new ArrayList<>();

        SelfIdempotent selfIdempotent = new SelfIdempotent();

        selfIdempotent.calculation(nums, minDigit, maxDigit, currMinNum, sb);

        System.out.println("nums:" + JSON.toJSONString(nums));
    }

    public List<List<Integer>> calculation(List<List<Integer>> nums, Integer minDigit, //当前容器，存储数据   |  最小位数
                                           Integer maxDigit, //最大位数
                                           Integer currMinNum,   // 当前最小数（如果最大数，本次循环完毕  当前最大数是99 那么让他+1  为下一次的最小数）
                                           StringBuilder sb) {//当前最大数  每个位数的最大数都是（9,99,999,9999...）每次循环进来都append（9）进行循环
//        System.out.println("当前位数:" + minDigit);

        //确认结束条件  当位数达到10就结束
        if (minDigit > maxDigit) {
            return nums;
        }

        //每次循环进来append(9) 为最大数
        sb.append(9);

        //当前最大值  转换为值
        long num = Long.parseLong(sb.toString()) ;

        //先创建存放当前自幂数list
        List<Integer> listNum = new ArrayList<>();

        //开始计算
        //从当前最小值 到最大值循环 1  9
        for (int i = currMinNum; i <= num; i++) {
            //将当前的数分割出来 比如9999  分成{9,9,9,9}
            String[] split = String.valueOf(i).split("");
//            System.out.println("目前数:" + i);

            //目前总数 当前各个自幂数相加的总和
            Long currTotal = 0l;

            //当前位数的长度
            int length = split.length;

            //根据当前位数长度 自幂数乘积 进行相加
            for (int j = 0; j < length; j++) {
                //开始计算当前数的位数 自幂数总和
                currTotal += calculationSelfIdempotent(split[j], length);
            }

            //如果目前自幂数总和为当前数那就加入listNum
            if (currTotal == i) {
//                System.out.println("位数:" + minDigit + "   值:" + i);
                listNum.add(i);
            }
        }
        //计算完毕加入当前总容积中
        nums.add(listNum);

        //打印
        print(minDigit, listNum);

        //记得条件增加 否则造成死循环
        minDigit++;

        //如果没达到条件就进入下一次递归
        return calculation(nums, minDigit,
                maxDigit, Integer.parseInt(sb.toString()) + 1,
                sb);
    }

    public Long calculationSelfIdempotent(String num, Integer length) {
        Long numm = Long.parseLong(num);

        //当前计算好 放入其中
        Long zimushu = numm;

        //如果位数为1  循环不好计算 直接返回
        if (length == 1) {
            return numm;
        }

        for (Integer i = 0; i < length - 1; i++) {
            zimushu = zimushu * numm;
        }
        return zimushu;
    }


    //打印当前数
    private void print(Integer minDigit, List<Integer> listNum) {
        if (minDigit == 1) {
            System.out.println("独身数:" + listNum);
        }
        if (minDigit == 2) {
            System.out.println("没有自幂数:" + listNum);
        }
        if (minDigit == 3) {
            System.out.println("水仙花数:" + listNum);
        }
        if (minDigit == 4) {
            System.out.println("四叶玫瑰数:" + listNum);
        }
        if (minDigit == 5) {
            System.out.println("五角星数:" + listNum);
        }
        if (minDigit == 6) {
            System.out.println("六合数:" + listNum);
        }
        if (minDigit == 7) {
            System.out.println("北斗七星数:" + listNum);
        }
        if (minDigit == 8) {
            System.out.println("八仙数:" + listNum);
        }
        if (minDigit == 9) {
            System.out.println("九九重阳数:" + listNum);
        }
        if (minDigit == 10) {
            System.out.println("十全十美数:" + listNum);
        }
    }


}
