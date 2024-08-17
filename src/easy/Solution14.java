package easy;

/**
 * @Project: leetcode
 * @Package: easy
 * @Author: YY
 * @CreateTime: 2024-08-17  16:56
 * @Description: Solution14
 * 14. 最长公共前缀
 * 简单
 * 相关标签
 * 相关企业
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * 提示：
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * @Version: 1.0
 */
public class Solution14 {
    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        System.out.println(solution14.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println( solution14.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        //定义公共前缀
        String commonPre = strs[0];
        for (String str : strs) {
            //如果遍历的有空，则返回空
            if (str.length() == 0) {
                return "";
            }
            while (!str.startsWith(commonPre)) {
                commonPre = commonPre.substring(0, commonPre.length() - 1);
            }

        }
        return commonPre;
    }
}
