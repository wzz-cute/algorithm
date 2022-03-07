package com.wzz.algorithm.tree;


public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        setHero(tree);

//        tree.preOrder();
//        tree.infixOrder();
//        tree.postOrder();

//        tree.delNode(4);
//        tree.delNode(13);
//        tree.preOrder();

//        tree.preOrderSearch(11);
//        tree.infixOrderSearch(15);
        tree.postOrderSearch(11);

    }

    private static void setHero(BinaryTree tree) {
        HeroNode root_赵子龙 = new HeroNode(1, "常山--赵子龙");
        HeroNode 令狐冲 = new HeroNode(2, "华山--令狐冲");
        HeroNode 陈真 = new HeroNode(3, "精武门--陈真");
        HeroNode 叶问 = new HeroNode(4, "永春--叶问");
        HeroNode 吕布 = new HeroNode(5, "无双--吕布");
        HeroNode 地狱领主 = new HeroNode(6, "地狱领主");
        HeroNode 德古拉 = new HeroNode(7, "德古拉");
        HeroNode 血腥女王 = new HeroNode(8, "血腥女王");
        HeroNode 护珠灵兽 = new HeroNode(9, "护珠灵兽");
        HeroNode 阿瑞斯 = new HeroNode(10, "阿瑞斯");
        HeroNode 宙斯 = new HeroNode(11, "宙斯");
        HeroNode 奥丁 = new HeroNode(12, "奥丁");
        HeroNode 女武神 = new HeroNode(13, "女武神");
        HeroNode 战斗女神 = new HeroNode(14, "战斗女神");
        HeroNode 李探花 = new HeroNode(15, "李探花");

        tree.setRoot(root_赵子龙);
        root_赵子龙.setRight(陈真);
        root_赵子龙.setLeft(令狐冲);

        令狐冲.setRight(吕布);
        令狐冲.setLeft(叶问);

        叶问.setLeft(地狱领主);
        叶问.setRight(德古拉);

        吕布.setLeft(血腥女王);

        陈真.setLeft(护珠灵兽);
        陈真.setRight(阿瑞斯);

        护珠灵兽.setLeft(宙斯);
        护珠灵兽.setRight(奥丁);

        阿瑞斯.setLeft(女武神);
        阿瑞斯.setRight(战斗女神);

        女武神.setLeft(李探花);
    }
}

class BinaryTree {
    private HeroNode root;

    //前序遍历
    public void preOrder() {
        if (root != null) {
            root.preOrder();
            return;
        }
        System.out.println("二叉树为空，无法遍历");
    }

    //中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
            return;
        }
        System.out.println("二叉树为空，无法遍历");
    }

    //后序遍历
    public void postOrder() {
        if (root != null) {
            root.postOrder();
            return;
        }
        System.out.println("二叉树为空，无法遍历");
    }

    public void delNode(int no) {
        if (root != null) {
            root.delNode(no);
            return;
        }
        System.out.println("二叉树为空，无法删除");
    }

    public void preOrderSearch(int no) {
        if (root != null) {
            HeroNode heroNode = root.preOrderSearch(no);
            System.out.println("找到结果" + heroNode.toString());
            return;
        }
        System.out.println("二叉树为空，无法查找");
    }


    public void infixOrderSearch(int no) {
        if (root != null) {
            HeroNode heroNode = root.infixOrderSearch(no);
            System.out.println("找到结果" + heroNode.toString());
            return;
        }
        System.out.println("二叉树为空，无法查找");
    }

    public void postOrderSearch(int no) {
        if (root != null) {
            HeroNode heroNode = root.postOrderSearch(no);
            System.out.println("找到结果" + heroNode.toString());
            return;
        }
        System.out.println("二叉树为空，无法查找");
    }


    public void setRoot(HeroNode root) {
        this.root = root;
    }
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode right;
    private HeroNode left;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    //删除节点
    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }

        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }

        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }
    }

    //前序遍历
    public void preOrder() {
        //先输出父节点
        System.out.println(this);
        //递归左边
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归右边
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        //先遍历左边
        if (this.left != null) {
            this.left.infixOrder();
        }
        //在输出父节点
        System.out.println(this);
        //后遍历右边
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        //先遍历左边
        if (this.left != null) {
            this.left.postOrder();
        }
        //在遍历右边
        if (this.right != null) {
            this.right.postOrder();
        }
        //在输出父节点
        System.out.println(this);
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no) {
        System.out.println(this);
        //先比较当前节点是否相等
        if (this.no == no) {
            return this;
        }
        //左边递归查找
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.preOrderSearch(no);
        }

        if (heroNode != null) {
            return heroNode;
        }

        //右边递归查找
        if (this.right != null) {
            heroNode = this.right.preOrderSearch(no);
        }
        return heroNode;

    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no) {
        HeroNode heroNode = null;
        //先向左边查找
        if (this.left != null) {
            heroNode = this.left.infixOrderSearch(no);
        }

        //找到了就返回
        if (heroNode != null) {
            return heroNode;
        }

        System.out.println(this);
        //如果no相等返回
        if (this.no == no) {
            return this;
        }

        //向右边查找
        if (this.right != null) {
            heroNode = this.right.infixOrderSearch(no);
        }
        return heroNode;

    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no) {

        //判断当前结点的左子节点是否为空，如果不为空，则递归后序查找
        HeroNode resNode = null;
        if(this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if(resNode != null) {//说明在左子树找到
            return resNode;
        }

        //如果左子树没有找到，则向右子树递归进行后序遍历查找
        if(this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if(resNode != null) {
            return resNode;
        }

        //如果左右子树都没有找到，就比较当前结点是不是
        System.out.println(this);
        if(this.no == no) {
            return this;
        }
        return resNode;
    }


    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    @Override
    public String toString() {
        return "HeroNode[" +
                "no=" + no +
                ", name='" + name + '\'' +
                ']';
    }
}
