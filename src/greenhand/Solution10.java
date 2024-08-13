package greenhand;

/**
 * @Project: leetcode
 * @Package: greenhand
 * @Author: YY
 * @CreateTime: 2024-08-13  14:29
 * @Description: Solution10
 * 10. ������ʽƥ��
 * ����
 * ��ر�ǩ
 * �����ҵ
 * ����һ���ַ��� s ��һ���ַ����� p��������ʵ��һ��֧�� '.' �� '*' ��������ʽƥ�䡣
 * <p>
 * '.' ƥ�����ⵥ���ַ�
 * '*' ƥ���������ǰ�����һ��Ԫ��
 * ��νƥ�䣬��Ҫ���� ���� �ַ��� s �ģ������ǲ����ַ�����
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "aa", p = "a"
 * �����false
 * ���ͣ�"a" �޷�ƥ�� "aa" �����ַ�����
 * ʾ�� 2:
 * <p>
 * ���룺s = "aa", p = "a*"
 * �����true
 * ���ͣ���Ϊ '*' �������ƥ���������ǰ�����һ��Ԫ��, ������ǰ���Ԫ�ؾ��� 'a'����ˣ��ַ��� "aa" �ɱ���Ϊ 'a' �ظ���һ�Ρ�
 * ʾ�� 3��
 * <p>
 * ���룺s = "ab", p = ".*"
 * �����true
 * ���ͣ�".*" ��ʾ��ƥ�����������'*'�������ַ���'.'��
 * @Version: 1.0
 */
public class Solution10 {
    public boolean isMatch(String s, String p) {
        int m = s.length();  // s �ĳ���
        int n = p.length();  // p �ĳ���

        // ���� DP ������ dp[i][j] ��ʾ s ��ǰ i ���ַ��� p ��ǰ j ���ַ��Ƿ�ƥ��
        boolean[][] dp = new boolean[m + 1][n + 1];

        // ���ַ������ģʽ��ƥ���
        dp[0][0] = true;

        // ������ַ�����ģʽ p ƥ������
        // ���ģʽ��ĳ��λ���� '*'��������ƥ�����ǰ����ַ������� dp[0][j] ȡ���� dp[0][j-2]
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2]; // '*' ����ʹǰһ���ַ���ʧ
            }
        }

        // ��� DP ��
        for (int i = 1; i <= m; i++) { // �����ַ��� s ��ÿ���ַ�
            for (int j = 1; j <= n; j++) { // ����ģʽ p ��ÿ���ַ�
                char sc = s.charAt(i - 1); // ��ǰ�ַ��� s ���ַ�
                char pc = p.charAt(j - 1); // ��ǰģʽ p ���ַ�

                if (pc == '.' || pc == sc) { // ��� p �ĵ�ǰ�ַ��� '.' ������ s �ĵ�ǰ�ַ���ͬ
                    dp[i][j] = dp[i - 1][j - 1]; // �̳� dp[i-1][j-1] ��ƥ��״̬
                } else if (pc == '*') { // ��� p �ĵ�ǰ�ַ��� '*'
                    // '*' ƥ�� 0 ��ǰһ���ַ��������dp[i][j-2]
                    // '*' ƥ�� 1 �λ���ǰһ���ַ��������dp[i-1][j]���� p[j-2] ������ s[i-1] ƥ��� p[j-2] Ϊ '.'
                    dp[i][j] = dp[i][j - 2] ||
                            (dp[i - 1][j] && (p.charAt(j - 2) == sc || p.charAt(j - 2) == '.'));
                }
            }
        }

        // ���� dp[m][n]�����ַ��� s ��ģʽ p �Ƿ���ȫƥ��
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution10 solution = new Solution10();

        // ����ʾ��
        System.out.println(solution.isMatch("aabb", "a"));     // ���: false
        System.out.println(solution.isMatch("aaaa", "a*"));    // ���: true
        System.out.println(solution.isMatch("ab", ".*"));    // ���: true
    }
}
