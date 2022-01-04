package com.wzz.structure.linked;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack();
// 入栈
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");
// 出栈
// smith, tom , jack
        while (stack.size() > 0) {
            System.out.println(stack.pop());//pop 就是将栈顶的数据取出
        }
    }

    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;//空链表，不能打印
        }
//创建要给一个栈，将各个节点压入栈
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
//将链表的所有节点压入栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next; //cur 后移，这样就可以压入下一个节点
        }
//将栈中的节点进行打印,pop 出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop()); //stack 的特点是先进后出
        }
    }

}

