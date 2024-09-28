package easy;

/**
 * @Project: leetcode
 * @Package: easy
 * @Author: YY
 * @CreateTime: 2024-09-28  19:36
 * @Description: Solution67
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 * 示例 1：
 * 输入:a = "11", b = "1"
 * 输出："100"
 * 示例 2：
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 * 提示
 * 1 <= a.length, b.length <= 104
 * a 和 b 仅由字符 '0' 或 '1' 组成
 * 字符串如果不是 "0" ，就不含前导零
 * @Version: 1.0
 */
public class Solution67 {
    public static void main(String[] args) {
        Solution67 solution67 = new Solution67();
        String s = solution67.addBinary("11", "11");
        System.out.println("s = " + s);
    }

    public String addBinary(String a, String b) {
        // 创建一个StringBuilder对象ans，用于存储计算结果
        StringBuilder ans = new StringBuilder();
        // 初始化一个整数变量ca，用于存储当前位上的进位
        int ca = 0;

        // 使用双指针i和j从字符串a和b的末尾开始遍历
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            // 计算当前位上的 sum，初始值为进位ca
            int sum = ca;
            // 如果i >= 0，将字符串a中第i位上的数字加到sum上
            if (i >= 0) {
                sum += a.charAt(i) - '0';
            }
            // 如果j >= 0，将字符串b中第j位上的数字加到sum上
            if (j >= 0) {
                sum += b.charAt(j) - '0';
            }
            // 将sum对2取余，并将结果添加到ans中
            ans.append(sum % 2);
            // 计算新的进位ca
            ca = sum / 2;
        }
        // 如果最后一位上的进位为1，将进位添加到ans中
        ans.append(ca == 1 ? ca : "");
        // 将ans反转，并转换为十进制字符串返回
        return ans.reverse().toString();

    }
}
