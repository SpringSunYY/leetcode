package medium;

/**
 * @Project: leetcode
 * @Package: medium
 * @Author: YY
 * @CreateTime: 2024-05-31  17:16
 * @Description: Solution6
 * 6. Z 字形变换
 * 中等
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * @Version: 1.0
 */
public class Solution6 {
    public static String convert(String s, int numRows) {
        // 如果行数为 1 或者行数大于等于字符串长度，直接返回原字符串
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        // 创建一个 StringBuilder 数组，每个 StringBuilder 代表一行
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;  // 当前行号
        boolean goingDown = false;  // 方向标志

        // 遍历字符串中的每个字符
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);  // 将字符添加到当前行

            // 在最顶行或者最底行时改变方向
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // 根据方向更新当前行号
            currentRow += goingDown ? 1 : -1;
        }

        // 将所有行的内容拼接成最终结果
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            System.out.println("row = " + row);
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(myConvert(s, numRows));  // 输出: "PAHNAPLSIIGYIR"
    }

    public static String myConvert(String s, int numRows) {
        // 如果行数为 1 或者行数大于等于字符串长度，直接返回原字符串
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        // 创建一个 StringBuilder 数组，每个 StringBuilder 代表一行
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;  // 当前行号
        boolean goingDown = false;  // 方向标志

        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            System.out.println("c = " + c);
            rows[currentRow].append(c);
        }

        // 将所有行的内容拼接成最终结果
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            System.out.println("row = " + row);
            result.append(row);

            //在最顶端或者最低端换行
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            //根据方向更新当前行号
            currentRow += goingDown ? 1 : -1;
        }

        return result.toString();
    }
}
