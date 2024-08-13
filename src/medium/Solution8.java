package medium;

import easy.Solution;

/**
 * @Project: leetcode
 * @Package: medium
 * 8. 字符串转换整数 (atoi)
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数。
 * 函数 myAtoi(string s) 的算法如下：
 *     空格：读入字符串并丢弃无用的前导空格（" "）
 *     符号：检查下一个字符（假设还未到字符末尾）为 '-' 还是 '+'。如果两者都不存在，则假定结果为正。
 *     转换：通过跳过前置零来读取该整数，直到遇到非数字字符或到达字符串的结尾。如果没有读取数字，则结果为0。
 *     舍入：如果整数数超过 32 位有符号整数范围 [?231,  231 ? 1] ，
 *     需要截断这个整数，使其保持在这个范围内。具体来说，小于 ?231 的整数应该被舍入为 ?231 ，大于 231 ? 1 的整数应该被舍入为 231 ? 1 。
 * 返回整数作为最终结果。
 * @Author: YY
 * @CreateTime: 2024-06-05  17:20
 * @Description: Solution8
 * @Version: 1.0
 */
public class Solution8 {
    public  int myAtoi(String s) {
        int i = 0, n = s.length();
        int sign = 1;
        int result = 0;
        int INT_MAX = Integer.MAX_VALUE;
        int INT_MIN = Integer.MIN_VALUE;

        // 丢弃前导空格
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        // 检查符号
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        // 转换数字
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // 检查是否超出范围
            if (result > (INT_MAX - digit) / 10) {
                return (sign == 1) ? INT_MAX : INT_MIN;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }

    public static void main(String[] args) {
        Solution8 solution = new Solution8();

        System.out.println(solution.myAtoi("+-4+2"));            // 输出: 42
        System.out.println(solution.myAtoi("   -42"));        // 输出: -42
        System.out.println(solution.myAtoi("4193 with words")); // 输出: 4193
        System.out.println(solution.myAtoi("words and 987"));   // 输出: 0
        System.out.println(solution.myAtoi("-912834723534534534534634534532"));  // 输出: -2147483648
    }
}
