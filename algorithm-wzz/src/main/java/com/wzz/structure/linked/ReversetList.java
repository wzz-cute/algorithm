package com.wzz.structure.linked;

public class ReversetList {
    //将单链表反转
    public static void reversetList(HeroNode head) {
//如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
//定义一个辅助的指针(变量)，帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;// 指向当前节点[cur]的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
//遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表 reverseHead 的最前端
//动脑筋
        while (cur != null) {
            next = cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next;//将 cur 的下一个节点指向新的链表的最前端
            reverseHead.next = cur; //将 cur 连接到新的链表上
            cur = next;//让 cur 后移
        }
//将 head.next 指向 reverseHead.next , 实现单链表的反转
        head.next = reverseHead.next;
    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方法，我们重新 toString
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }
}
