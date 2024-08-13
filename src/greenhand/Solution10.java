package greenhand;

/**
 * @Project: leetcode
 * @Package: greenhand
 * @Author: YY
 * @CreateTime: 2024-08-13  14:29
 * @Description: Solution10
 * 10. 正则表达式匹配
 * 困难
 * 相关标签
 * 相关企业
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s 的，而不是部分字符串。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入：s = "aa", p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3：
 * <p>
 * 输入：s = "ab", p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）
 * @Version: 1.0
 */
public class Solution10 {
    public boolean isMatch(String s, String p) {
        int m = s.length();  // s 的长度
        int n = p.length();  // p 的长度

        // 创建 DP 表，其中 dp[i][j] 表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配
        boolean[][] dp = new boolean[m + 1][n + 1];

        // 空字符串与空模式是匹配的
        dp[0][0] = true;

        // 处理空字符串与模式 p 匹配的情况
        // 如果模式的某个位置是 '*'，它可以匹配零个前面的字符，所以 dp[0][j] 取决于 dp[0][j-2]
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2]; // '*' 可以使前一个字符消失
            }
        }

        // 填充 DP 表
        for (int i = 1; i <= m; i++) { // 遍历字符串 s 的每个字符
            for (int j = 1; j <= n; j++) { // 遍历模式 p 的每个字符
                char sc = s.charAt(i - 1); // 当前字符串 s 的字符
                char pc = p.charAt(j - 1); // 当前模式 p 的字符

                if (pc == '.' || pc == sc) { // 如果 p 的当前字符是 '.' 或者与 s 的当前字符相同
                    dp[i][j] = dp[i - 1][j - 1]; // 继承 dp[i-1][j-1] 的匹配状态
                } else if (pc == '*') { // 如果 p 的当前字符是 '*'
                    // '*' 匹配 0 次前一个字符的情况：dp[i][j-2]
                    // '*' 匹配 1 次或多次前一个字符的情况：dp[i-1][j]，且 p[j-2] 必须与 s[i-1] 匹配或 p[j-2] 为 '.'
                    dp[i][j] = dp[i][j - 2] ||
                            (dp[i - 1][j] && (p.charAt(j - 2) == sc || p.charAt(j - 2) == '.'));
                }
            }
        }

        // 返回 dp[m][n]，即字符串 s 和模式 p 是否完全匹配
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution10 solution = new Solution10();

        // 测试示例
        System.out.println(solution.isMatch("aabb", "a"));     // 输出: false
        System.out.println(solution.isMatch("aaaa", "a*"));    // 输出: true
        System.out.println(solution.isMatch("ab", ".*"));    // 输出: true
    }
}
