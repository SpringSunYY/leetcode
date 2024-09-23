package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project: leetcode
 * @Package: medium
 * @Author: YY
 * @CreateTime: 2024-09-23  22:39
 * @Description: Solution17
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * @Version: 1.0
 */
public class Solution17 {
    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        // 调用 letterCombinations 方法，传入 "23"，生成所有可能的字母组合
        List<String> strings = solution17.letterCombinations("23");
//        // 遍历并打印所有的组合结果
//        for (String string : strings) {
//            System.out.println(string);
//        }
//        List<String> strings1 = solution17.letterCombinations("233");
//        System.out.println("==================");
//        // 遍历并打印所有的组合结果
//        for (String string : strings1) {
//            System.out.println(string);
//        }
//        System.out.println("==================");
//        List<String> strings2 = solution17.letterCombinations("234");
//        // 遍历并打印所有的组合结果
//        for (String string : strings2) {
//            System.out.println(string);
//        }
    }

    // 用于存储结果的列表
    ArrayList<String> res = new ArrayList<>();
    // 数字与字母的映射表，0 和 1 不对应任何字母，所以放空字符串
    String[] letterMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    // 主函数，生成数字字符串对应的所有字母组合
    public List<String> letterCombinations(String digits) {
        // 如果输入的字符串为空，直接返回空结果
        if (digits.isEmpty()) {
            return res;
        }
        // 调用递归函数，从第 0 个数字开始处理
        findCombination(digits, 0, new StringBuilder());
        // 返回结果列表
        return res;
    }

    // 递归函数，用于生成字母组合
    private void findCombination(String digits, int index, StringBuilder sb) {
        // 递归终止条件：如果当前处理的索引已经等于输入字符串的长度，说明组合完成
        if (index == digits.length()) {
            // 将当前组合添加到结果列表中
            res.add(sb.toString());
            return;
        }

        // 获取当前索引对应的数字字符
        char c = digits.charAt(index);
        // 根据数字字符从映射表中取出对应的字母
        // c 是 digits.charAt(index) 获取的一个字符，比如字符 '2'。
        // 但是由于 letterMap 是一个数组，索引必须是整数，因此需要将字符 '2' 转换为对应的整数 2。
        String letters = letterMap[c - '0'];
        // 遍历该数字对应的所有字母
        for (int i = 0; i < letters.length(); i++) {
            // 将当前字母添加到 StringBuilder 中，并递归处理下一个数字
            findCombination(digits, index + 1, sb.append(letters.charAt(i)));
            // 递归返回后，删除最后添加的字符，回溯到之前的状态
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

