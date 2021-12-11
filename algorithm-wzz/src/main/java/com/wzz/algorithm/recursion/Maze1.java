package com.wzz.algorithm.recursion;

/**
 * 迷宫问题
 * (递归回溯算法)
 */
public class Maze1 {
    public static void main(String[] args) {
        Maze1 maze = new Maze1();

        String noRoad = "@";
        String yesRoad = "U";

        String rowWall = "—";
        String colWall = "|";

        String me = "* ";
        String door = "R ";

        Integer count = 0;

        //创建一个二维数组 为 地图
        String[][] maps = new String[10][10];

        //设置没走过的路为@  走过的为U
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                maps[i][j] = noRoad;
            }
        }

        //做墙  上下为————  左右为|
        for (int i = 0; i < maps[0].length; i++) {
            maps[0][i] = rowWall;
            maps[maps[0].length - 1][i] = rowWall;

            maps[i][0] = colWall;
            maps[i][maps[0].length - 1] = colWall;
        }
        maps[1][3] = colWall;
        maps[2][3] = colWall;
        maps[3][3] = colWall;
        maps[4][3] = colWall;

        //设置自己 *
        maps[2][2] = me;

        //设置门  R
        maps[8][8] = door;

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                System.out.print(maps[i][j] + "       ");
            }
            System.out.println("\n");
        }

        //指定规则  开始走迷宫
        maze.mapRule1(maps, 2, 2, me, yesRoad, colWall, count);


//        打印地图
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                System.out.print(maps[i][j] + "       ");
            }
            System.out.println("\n");
        }
    }

    /**
     * 指定第一个规则  先右厚下
     *
     * @param maps  地图
     * @param row   行
     * @param col   列
     * @param me    我
     * @param road  路
     * @param wall  墙
     * @param count 计数
     * @return
     */
    public boolean mapRule1(String[][] maps, int row, int col, String me, String road, String wall, Integer count) {
        if (row == 8 && col == 8) {
            maps[row][col] = "(＾－＾)V";
            System.out.println(count);
            return true;
        } else if (maps[row][col].equals(wall)) {
            return false;
        } else {
            count++;
            if (mapRule1(maps, row, col + 1, me, road, wall, count)) {
                maps[row][col] = road;
                maps[row][col] = me;
                return true;
            } else if (mapRule1(maps, row + 1, col, me, road, wall, count)) {
                maps[row][col] = road;
                maps[row][col] = me;
                return true;
            }
        }
        return false;
    }

//    public boolean isWall(String[][] maps, int row, int col, String wall) {
//        String result = maps[row][col];
//        if (wall.equals(result)) {
//            return true;
//        }
//
//        return false;
//    }


}
