package medium;

/**
 * @Project: leetcode
 * @Package: medium
 * @Author: YY
 * @CreateTime: 2024-10-09  18:48
 * 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * @Description: Solution59
 * @Version: 1.0
 */
public class Solution59 {
    public static void main(String[] args) {
        Solution59 solution59 = new Solution59();
        int[][] ints = solution59.generateMatrix(5);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int value = 1;
        int l = 0, r = n - 1, t = 0, b = n - 1;
        while (value <= n * n) {
            //当前顶层从左到右
            for (int i = l; i <= r; i++) {
                result[t][i] = value++;
            }
            //当前顶层完成，+1
            t++;
            //当前最右层从上到下
            for (int i = t; i <= b; i++) {
                result[i][r] = value++;
            }
            //当前最右层-1
            r--;
            //当前最下层从右到左
            for (int i = r; i >= l; i--) {
                result[b][i] = value++;
            }
            //最下层完成，-1
            b--;
            //当前最左层从下到上
            for (int i = b; i >= t; i--) {
                result[i][l] = value++;
            }
            //最左层+1
            l++;
        }
        return result;
    }
}
