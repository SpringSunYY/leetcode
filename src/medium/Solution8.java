package medium;

import easy.Solution;

/**
 * @Project: leetcode
 * @Package: medium
 * 8. �ַ���ת������ (atoi)
 * ������ʵ��һ�� myAtoi(string s) ������ʹ���ܽ��ַ���ת����һ�� 32 λ�з���������
 * ���� myAtoi(string s) ���㷨���£�
 *     �ո񣺶����ַ������������õ�ǰ���ո�" "��
 *     ���ţ������һ���ַ������軹δ���ַ�ĩβ��Ϊ '-' ���� '+'��������߶������ڣ���ٶ����Ϊ����
 *     ת����ͨ������ǰ��������ȡ��������ֱ�������������ַ��򵽴��ַ����Ľ�β�����û�ж�ȡ���֣�����Ϊ0��
 *     ���룺������������� 32 λ�з���������Χ [?231,  231 ? 1] ��
 *     ��Ҫ�ض����������ʹ�䱣���������Χ�ڡ�������˵��С�� ?231 ������Ӧ�ñ�����Ϊ ?231 ������ 231 ? 1 ������Ӧ�ñ�����Ϊ 231 ? 1 ��
 * ����������Ϊ���ս����
 * @Author: YY
 * @CreateTime: 2024-06-05  17:20
 * @Description: Solution8
 * @Version: 1.0
 */
public class Solution8 {
    public  int myAtoi(String s) {
        int i = 0, n = s.length();
        int sign = 1;
        int result = 0;
        int INT_MAX = Integer.MAX_VALUE;
        int INT_MIN = Integer.MIN_VALUE;

        // ����ǰ���ո�
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        // ������
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        // ת������
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // ����Ƿ񳬳���Χ
            if (result > (INT_MAX - digit) / 10) {
                return (sign == 1) ? INT_MAX : INT_MIN;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }

    public static void main(String[] args) {
        Solution8 solution = new Solution8();

        System.out.println(solution.myAtoi("+-4+2"));            // ���: 42
        System.out.println(solution.myAtoi("   -42"));        // ���: -42
        System.out.println(solution.myAtoi("4193 with words")); // ���: 4193
        System.out.println(solution.myAtoi("words and 987"));   // ���: 0
        System.out.println(solution.myAtoi("-912834723534534534534634534532"));  // ���: -2147483648
    }
}
