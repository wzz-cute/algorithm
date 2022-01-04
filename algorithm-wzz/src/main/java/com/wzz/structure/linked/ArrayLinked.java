package com.wzz.structure.linked;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * 使用数组实现链表
 */
public class ArrayLinked {
    public static void main(String[] args) {
        HeroController heroController = new HeroController();
        Hero hero = new Hero(1, "赵云");
        Hero hero2 = new Hero(2, "吕布");
        Hero hero3 = new Hero(3, "项羽");
        Hero hero4 = new Hero(4, "韩信");

        heroController.add(hero);
        heroController.add(hero2);
        heroController.add(hero3);
        heroController.add(hero4);

        heroController.showHero();


        Hero upHero = new Hero(1, "赵云1");
        heroController.upHero(upHero);
        heroController.showHero();

        heroController.delHero(1);
        heroController.showHero();

    }
}

class HeroController {
    Hero head = new Hero(0, "");

    public void add(Hero hero) {
        if (hero == null) {
            System.out.println("传入对象不能为空");
            return;
        }
        Hero next = head;
        while (true) {
            if (null == next.nextHero) {
                break;
            }
            next = next.nextHero;
        }
        next.nextHero = hero;
    }

    public void showHero() {
        Hero hero = head.nextHero;
        System.out.println(JSON.toJSONString(hero));
    }

    public void upHero(Hero upHero) {
        Hero next = head;
        while (true) {
            if (next != null && next.nextHero.no == upHero.no) {
                break;
            }
            next = next.nextHero;
        }
        next.nextHero.name = upHero.name;
    }

    public void delHero(Integer no) {
        Hero next = head;
        while (true) {
            if (next != null && next.nextHero.no == no) {
                break;
            }
            next = next.nextHero;
        }
        Hero nextHero = next.nextHero.nextHero;
        next.nextHero = nextHero;
    }

}

class Hero {
    public Integer no;
    public String name;
    public Hero nextHero;

    public Hero() {
    }

    public Hero(Integer no, String name) {
        this.no = no;
        this.name = name;
    }

}
