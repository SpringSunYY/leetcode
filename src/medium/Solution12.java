package medium;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Project: leetcode
 * @Package: medium
 * @Author: YY
 * @CreateTime: 2024-08-15  15:53
 * @Description: Solution12
 * 七个不同的符号代表罗马数字，其值如下：
 * <p>
 * 符号	值
 * I	1
 * V	5
 * X	10
 * L	50
 * C	100
 * D	500
 * M	1000
 * 罗马数字是通过添加从最高到最低的小数位值的转换而形成的。将小数位值转换为罗马数字有以下规则：
 * <p>
 * 如果该值不是以 4 或 9 开头，请选择可以从输入中减去的最大值的符号，将该符号附加到结果，减去其值，然后将其余部分转换为罗马数字。
 * 如果该值以 4 或 9 开头，使用 减法形式，表示从以下符号中减去一个符号，例如 4 是 5 (V) 减 1 (I): IV ，9 是 10 (X) 减 1 (I)：IX。仅使用以下减法形式：4 (IV)，9 (IX)，40 (XL)，90 (XC)，400 (CD) 和 900 (CM)。
 * 只有 10 的次方（I, X, C, M）最多可以连续附加 3 次以代表 10 的倍数。你不能多次附加 5 (V)，50 (L) 或 500 (D)。如果需要将符号附加4次，请使用 减法形式。
 * 给定一个整数，将其转换为罗马数字。
 * 示例 1：
 * 输入：num = 3749
 * 输出： "MMMDCCXLIX"
 * 解释：
 * 3000 = MMM 由于 1000 (M) + 1000 (M) + 1000 (M)
 * 700 = DCC 由于 500 (D) + 100 (C) + 100 (C)
 * 40 = XL 由于 50 (L) 减 10 (X)
 * 9 = IX 由于 10 (X) 减 1 (I)
 * 注意：49 不是 50 (L) 减 1 (I) 因为转换是基于小数位
 * 示例 2：
 * 输入：num = 58
 * 输出："LVIII"
 * 解释：
 * 50 = L
 * 8 = VIII
 * 示例 3：
 * 输入：num = 1994
 * 输出："MCMXCIV"
 * 解释：
 * 1000 = M
 * 900 = CM
 * 90 = XC
 * 4 = IV
 * @Version: 1.0
 */
public class Solution12 {
    public static void main(String[] args) {
        romanToString(3749);  // 输出: MMMDCCXLIX
        romanToString(1994);  // 输出: MCMXCIV
        romanToString(58);    // 输出: LVIII
        romanToString(10);    // 输出: LVIII
    }

    public static String romanToString(int num) {
        System.out.println("num = " + num);
        String numberStr = Integer.toString(num);
        StringBuffer stringBuffer = new StringBuffer();
        int length = numberStr.length();

        for (int i = 0; i < length; i++) {
            // 获取当前数字位的值
            int digit = Character.getNumericValue(numberStr.charAt(i));
            // 计算当前数字位对应的权值（如千位、百位、十位、个位）
            int position = (int) Math.pow(10, length - 1 - i);
            // 获取当前数字位的具体值
            int positionNum = position * digit;

            // 将当前数字位转换为罗马数字并追加到结果中
            stringBuffer.append(convertToRoman(positionNum, position));
        }

        System.out.println("Roman Numeral: " + stringBuffer.toString());
        return stringBuffer.toString();
    }

    // 根据当前位数值，返回对应的罗马数字
    private static String convertToRoman(int num, int position) {
        StringBuffer result = new StringBuffer();
        ArrayList<String> strings = new ArrayList<>();
        while (num > 0) {
            String value = getValue(num);
            if (!value.isEmpty()) {
                strings.add(value);
                break;
            } else {
                // 找不到完整匹配时，将 num 拆分为较小部分
                num -= position;
                strings.add(getValue(position));
            }
        }
        System.out.println("strings.size() = " + strings.size());
        if (!strings.isEmpty() && getValue(strings.get(0)) < getValue(strings.get(strings.size() - 1))) {
            // 反转列表中的所有元素
            Collections.reverse(strings);
        }
        System.out.println("strings = " + strings.toString());
        for (String string : strings) {
            result.append(string);
            System.out.println("string = " + string);
        }
        return result.toString();
    }

    private static int getValue(String c) {
        switch (c) {
            case "I":
                return 1;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "IX":
                return 9;
            case "X":
                return 10;
            case "XL":
                return 40;
            case "L":
                return 50;
            case "XC":
                return 90;
            case "C":
                return 100;
            case "CD":
                return 400;
            case "D":
                return 500;
            case "CM":
                return 900;
            case "M":
                return 1000;
            default:
                return 0;
        }
    }

    // 获取单个数值对应的罗马数字
    private static String getValue(int c) {
        switch (c) {
            case 1:
                return "I";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 9:
                return "IX";
            case 10:
                return "X";
            case 40:
                return "XL";
            case 50:
                return "L";
            case 90:
                return "XC";
            case 100:
                return "C";
            case 400:
                return "CD";
            case 500:
                return "D";
            case 900:
                return "CM";
            case 1000:
                return "M";
            default:
                return "";
        }
    }
}
