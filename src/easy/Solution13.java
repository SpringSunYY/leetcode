package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Project: leetcode
 * @Package: easy
 * @Author: YY
 * @CreateTime: 2024-08-14  15:12
 * @Description: Solution13
 * 13. 罗马数字转整数
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 * 示例 1:
 * 输入: s = "III"
 * 输出: 3
 * 示例 2:
 * 输入: s = "IV"
 * 输出: 4
 * 示例 3:
 * 输入: s = "IX"
 * 输出: 9
 * 示例 4:
 * 输入: s = "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 * 输入: s = "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * @Version: 1.0
 */
public class Solution13 {
    public int romanToInt(String s) {
        int total = 0; // 最终结果
        int prevValue = 0; // 记录前一个字符的数值

        // 从左到右遍历字符串
        for (int i = 0; i < s.length(); i++) {
            int currentValue = getValue(s.charAt(i));
            // 如果当前字符的数值大于前一个字符的数值，则减去前一个字符的数值
            if (currentValue > prevValue) {
                total += currentValue - 2 * prevValue;
            } else {
                total += currentValue;
            }
            // 更新前一个字符的数值
            prevValue = currentValue;
        }

        return total;
    }

    private int getValue(char c){
        switch(c){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default:return 0;
        }
    }
    public static void main(String[] args) {
        Solution13 converter = new Solution13();
        // 示例测试
        System.out.println(converter.romanToInt("III"));    // 输出: 3
        System.out.println(converter.romanToInt("IV"));     // 输出: 4
        System.out.println(converter.romanToInt("IX"));     // 输出: 9
        System.out.println(converter.romanToInt("LVIII"));  // 输出: 58
        System.out.println(converter.romanToInt("MCMXCIV"));// 输出: 1994
        System.out.println(converter.romanToInt("MCMXCIIV"));// 输出: 1994
        System.out.println(converter.romanToInt("MCMXCIXV"));// 输出: 1994
        System.out.println(converter.romanToInt("MCMXCIVA"));// 输出: 1994
    }
}
