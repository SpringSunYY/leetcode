package medium;

/**
 * @Project: leetcode
 * @Package: medium
 * @Author: YY
 * @CreateTime: 2024-10-16  19:00
 * @Description: Solution50
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * 提示：
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * n 是一个整数
 * 要么 x 不为零，要么 n > 0 。
 * -104 <= xn <= 104
 * @Version: 1.0
 */
public class Solution50 {
    public static void main(String[] args) {
        Solution50 solution50 = new Solution50();
        double v = solution50.myPow(12, 12);
        System.out.println("v = " + v);
    }
    public double myPow(double x, int n) {
        // 如果 x 为 0，则任何次幂结果为 0
        if (x == 0.0f) return 0.0d;

        // 将 n 转换为 long 类型，防止溢出
        long b = n;
        double res = 1.0; // 初始化结果为 1

        // 如果 n 是负数，需要将 x 取倒数，并将 b 变为正数
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }

        // 使用快速幂算法来计算 x^b
        while (b > 0) {
            // 如果 b 的最低位是 1，则将当前的 x 乘到结果中
            if ((b & 1) == 1) res *= x;
            // 将 x 平方
            x *= x;
            // 右移 b，去掉最低位
            b >>= 1;
        }

        return res;
    }
}
