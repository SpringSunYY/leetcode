package medium;

/**
 * Project: leetcode
 * Package: medium
 * Author: YY
 * CreateTime: 2024-12-10  19:06
 * Description: Solution63
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * Version: 1.0
 */
public class Solution62 {
    public static void main(String[] args) {
        Solution62 solution63 = new Solution62();
        int uniquePaths = solution63.uniquePaths(3, 7);
        System.err.println(uniquePaths);
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //第一行都赋予 1
        for(int i = 0; i < m; ++i) {
            dp[i][0] = 1;
        }
        //第一列都赋予 1
        for(int j = 0; j < n; ++j) {
            dp[0][j] = 1;
        }
        //两个for循环推导，对于(i,j)来说，只能由上方或者左方转移过来
        for(int i = 1; i < m; ++i) {
            for(int j = 1; j < n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
