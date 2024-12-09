package easy;

/**
 * Project: leetcode
 * Package: easy
 * Author: YY
 * CreateTime: 2024-12-09  18:55
 * Description: Solution69
 * 69. x 的平方根
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * 示例 1：
 * 输入：x = 4
 * 输出：2
 * 示例 2：
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 * 提示：
 * 0 <= x <= 231 - 1
 * Version: 1.0
 */
public class Solution69 {

    public static void main(String[] args) {
        Solution69 solution69 = new Solution69();
        int i = solution69.mySqrt(2147395599);
        System.out.println(i);
    }
    // 计算非负整数 x 的算术平方根（返回整数部分）
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid; // 使用 long 类型存储 mid 的平方以防止溢出

            if (square == x) {
                return mid;
            } else if (square < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right; // 返回整数部分
    }
}
