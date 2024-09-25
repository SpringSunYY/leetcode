package easy;

import java.util.Stack;

/**
 * @Project: leetcode
 * @Package: easy
 * @Author: YY
 * @CreateTime: 2024-09-25  18:30
 * @Description: Solution20
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 * 输入：s = "([])"
 * 输出：true
 * @Version: 1.0
 */
public class Solution20 {
    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        System.out.println(solution20.isValid("{){}()"));
    }

    public boolean isValid(String s) {
        if (s.isEmpty())
            return true;
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
                //如果是空或者是不可以弹出则直接返回
            else if (stack.empty() || c != stack.pop())
                return false;
        }
        //如果stack里面没有则表示匹配成功
        if (stack.empty())
            return true;
        return false;
    }

}
