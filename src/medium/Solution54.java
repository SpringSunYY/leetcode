package medium;

import dataStructure.Main;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project: leetcode
 * @Package: medium
 * @Author: YY
 * @CreateTime: 2024-10-10  18:22
 * @Description: Solution54
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * @Version: 1.0
 */
public class Solution54 {
    public static void main(String[] args) {
        Solution54 solution54 = new Solution54();
        List<Integer> integers = solution54.spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
        });
        for (Integer integer : integers) {
            System.out.print(integer + "\t");
        }
        System.out.println("integers = " + integers.size());
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        //初始化list、list索引
        int initIndex = 0;
        List<Integer> resultList = new ArrayList<>();
        //定义数组的宽高 由四个边组成一个回
        int yLength = matrix.length;
        int xLength = matrix[0].length;
        int t = 0, r = xLength - 1, b = yLength - 1, l = 0;
        System.out.println("t = " + t);
        System.out.println("r = " + r);
        System.out.println("b = " + b);
        System.out.println("l = " + l);
        while (true) {
            //遍历顶层从左到右
            for (int i = l; i <= r; i++) resultList.add(initIndex++, matrix[t][i]);
            //顶层遍历完成
            if (++t > b) break;
            //遍历最右从上到下
            for (int i = t; i <= b; i++) resultList.add(initIndex++, matrix[i][r]);
            //右层遍历完成
            if (--r < l) break;
            //底层从右到左
            for (int i = r; i >= l; i--) resultList.add(initIndex++, matrix[b][i]);
            //底层遍历完成
            if (--b < t) break;
            //左层从下到上
            for (int i = b; i >= t; i--) resultList.add(initIndex++, matrix[i][l]);
            //左层遍历完成
            if (++l > r) break;
        }
        return resultList;
    }
}
