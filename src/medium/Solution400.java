package medium;

import java.time.temporal.ValueRange;

/**
 * @Project: leetcode
 * @Package: medium
 * @Author: YY
 * @CreateTime: 2024-10-15  18:56
 * @Description: Solution400
 * 400. 第 N 位数字
 * 给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字。
 * 示例 1：
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 * 输入：n = 11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 * @Version: 1.0
 */
public class Solution400 {
    public static void main(String[] args) {
        Solution400 solution400 = new Solution400();
        int nthDigit = solution400.findNthDigit(13);
        System.out.println("nthDigit = " + nthDigit);
    }

    public int findNthDigit(int n) {
        int digit = 1; // 当前数字的位数，初始值为1，表示从一位数开始（1-9）
        long start = 1; // 当前位数的起始数字，初始值为1（即从1开始）
        long count = 9; // 当前位数范围内的所有数字的总位数，初始为9（1-9共有9位）

        // 循环查找 n 所在的数字范围
        while (n > count) {
            n -= count; // 从 n 中减去当前范围内的位数总和
            start *= 10; // 更新 start 到下一个位数范围的起始值（如从1到10，再到100）
            digit += 1; // 增加位数，如从一位数到两位数
            count = digit * start * 9; // 更新当前范围内的位数总和（两位数时，共90个数字，每个占2位，总计180位）
        }

        // 找到 n 对应的具体数字
        long num = start + (n - 1) / digit; // 确定 n 所在的数字，如两位数时，确定是在10到99的哪个数字

        // 找到该数字中对应的具体位
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 将数字转换为字符串，获取第 (n-1) % digit 位字符，并转换为数字
    }
}
