package easy;

/**
 * Project: leetcode
 * Package: easy
 * Author: YY
 * CreateTime: 2024-12-09  18:55
 * Description: Solution69
 * 69. x ��ƽ����
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ���Ǹ����� x �����㲢���� x �� ����ƽ���� ��
 * ���ڷ������������������ֻ���� �������� ��С�����ֽ��� ��ȥ ��
 * ע�⣺������ʹ���κ�����ָ����������������� pow(x, 0.5) ���� x ** 0.5 ��
 * ʾ�� 1��
 * ���룺x = 4
 * �����2
 * ʾ�� 2��
 * ���룺x = 8
 * �����2
 * ���ͣ�8 ������ƽ������ 2.82842..., ���ڷ���������������С�����ֽ�����ȥ��
 * ��ʾ��
 * 0 <= x <= 231 - 1
 * Version: 1.0
 */
public class Solution69 {

    public static void main(String[] args) {
        Solution69 solution69 = new Solution69();
        int i = solution69.mySqrt(2147395599);
        System.out.println(i);
    }
    // ����Ǹ����� x ������ƽ�����������������֣�
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid; // ʹ�� long ���ʹ洢 mid ��ƽ���Է�ֹ���

            if (square == x) {
                return mid;
            } else if (square < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right; // ������������
    }
}
