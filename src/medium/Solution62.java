package medium;

/**
 * Project: leetcode
 * Package: medium
 * Author: YY
 * CreateTime: 2024-12-10  19:06
 * Description: Solution63
 * 62. ��ͬ·��
 * һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ ��Start�� ����
 * ������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ ��Finish�� ����
 * ���ܹ��ж�������ͬ��·����
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
        //��һ�ж����� 1
        for(int i = 0; i < m; ++i) {
            dp[i][0] = 1;
        }
        //��һ�ж����� 1
        for(int j = 0; j < n; ++j) {
            dp[0][j] = 1;
        }
        //����forѭ���Ƶ�������(i,j)��˵��ֻ�����Ϸ�������ת�ƹ���
        for(int i = 1; i < m; ++i) {
            for(int j = 1; j < n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
