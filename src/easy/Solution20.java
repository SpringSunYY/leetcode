package easy;

import java.util.Stack;

/**
 * @Project: leetcode
 * @Package: easy
 * @Author: YY
 * @CreateTime: 2024-09-25  18:30
 * @Description: Solution20
 * ����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ��� s ���ж��ַ����Ƿ���Ч��
 * ��Ч�ַ��������㣺
 * �����ű�������ͬ���͵������űպϡ�
 * �����ű�������ȷ��˳��պϡ�
 * ÿ�������Ŷ���һ����Ӧ����ͬ���͵������š�
 * ʾ�� 1��
 * ���룺s = "()"
 * �����true
 * ʾ�� 2��
 * ���룺s = "()[]{}"
 * �����true
 * ʾ�� 3��
 * ���룺s = "(]"
 * �����false
 * ʾ�� 4��
 * ���룺s = "([])"
 * �����true
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
                //����ǿջ����ǲ����Ե�����ֱ�ӷ���
            else if (stack.empty() || c != stack.pop())
                return false;
        }
        //���stack����û�����ʾƥ��ɹ�
        if (stack.empty())
            return true;
        return false;
    }

}
