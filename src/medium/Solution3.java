package medium;

import java.util.LinkedHashSet;

/**
 * @Description 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @ClassName Solution3
 * @Path medium
 * @Author YY
 * @Date 2024/4/15 21:12
 * @Version 1.0
 */
public class Solution3 {
    public static void main(String[] args) {
//        System.out.println("lengthOfLongestSubstring(\"abcddcabcbbwafsgzsgdqwertyuiopasdfghj\") = "
//                + lengthOfLongestSubstring("abcddcabcbbwafsgzsgdqwertyuiopasdfghj"));
        System.out.println("dvdf "
                + lengthOfLongestSubstring("dvdf"));
        System.out.println("abcabcbb "
                + lengthOfLongestSubstring("abcabcbb"));

    }

    public static int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        LinkedHashSet<Character> hashSet = new LinkedHashSet<>();
        int max = 0;
        int result = 0;
        int index = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (hashSet.add(charArray[i])) {    // add成功说明没有重复字符，可以继续扩展
                max += 1;
            } else {// add失败说明有重复字符，需要回退到上一个不重复的位置
                hashSet = new LinkedHashSet<>(); // 重新开始计数
                hashSet.add(charArray[index]); // 回退到上一个不重复的位置
                result = Math.max(result, max); // 记录当前最大长度
                max = 1;    // 重新开始计数
                i = index; // 回退到上一个不重复的位置
                index += 1; // 继续扩展
            }
        }
        result = Math.max(max, result);
        return result;
    }
}
