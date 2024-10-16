package medium;

/**
 * @Project: leetcode
 * @Package: medium
 * @Author: YY
 * @CreateTime: 2024-10-16  19:00
 * @Description: Solution50
 * 50. Pow(x, n)
 * ʵ�� pow(x, n) �������� x ������ n ���ݺ���������xn ����
 * ʾ�� 1��
 * ���룺x = 2.00000, n = 10
 * �����1024.00000
 * ʾ�� 2��
 * ���룺x = 2.10000, n = 3
 * �����9.26100
 * ʾ�� 3��
 * ���룺x = 2.00000, n = -2
 * �����0.25000
 * ���ͣ�2-2 = 1/22 = 1/4 = 0.25
 * ��ʾ��
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * n ��һ������
 * Ҫô x ��Ϊ�㣬Ҫô n > 0 ��
 * -104 <= xn <= 104
 * @Version: 1.0
 */
public class Solution50 {
    public static void main(String[] args) {
        Solution50 solution50 = new Solution50();
        double v = solution50.myPow(12, 12);
        System.out.println("v = " + v);
    }
    public double myPow(double x, int n) {
        // ��� x Ϊ 0�����κδ��ݽ��Ϊ 0
        if (x == 0.0f) return 0.0d;

        // �� n ת��Ϊ long ���ͣ���ֹ���
        long b = n;
        double res = 1.0; // ��ʼ�����Ϊ 1

        // ��� n �Ǹ�������Ҫ�� x ȡ���������� b ��Ϊ����
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }

        // ʹ�ÿ������㷨������ x^b
        while (b > 0) {
            // ��� b �����λ�� 1���򽫵�ǰ�� x �˵������
            if ((b & 1) == 1) res *= x;
            // �� x ƽ��
            x *= x;
            // ���� b��ȥ�����λ
            b >>= 1;
        }

        return res;
    }
}
