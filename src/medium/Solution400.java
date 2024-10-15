package medium;

import java.time.temporal.ValueRange;

/**
 * @Project: leetcode
 * @Package: medium
 * @Author: YY
 * @CreateTime: 2024-10-15  18:56
 * @Description: Solution400
 * 400. �� N λ����
 * ����һ������ n �����������޵��������� [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] ���ҳ������ص� n λ�ϵ����֡�
 * ʾ�� 1��
 * ���룺n = 3
 * �����3
 * ʾ�� 2��
 * ���룺n = 11
 * �����0
 * ���ͣ��� 11 λ���������� 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... ���� 0 ������ 10 ��һ���֡�
 * @Version: 1.0
 */
public class Solution400 {
    public static void main(String[] args) {
        Solution400 solution400 = new Solution400();
        int nthDigit = solution400.findNthDigit(13);
        System.out.println("nthDigit = " + nthDigit);
    }

    public int findNthDigit(int n) {
        int digit = 1; // ��ǰ���ֵ�λ������ʼֵΪ1����ʾ��һλ����ʼ��1-9��
        long start = 1; // ��ǰλ������ʼ���֣���ʼֵΪ1������1��ʼ��
        long count = 9; // ��ǰλ����Χ�ڵ��������ֵ���λ������ʼΪ9��1-9����9λ��

        // ѭ������ n ���ڵ����ַ�Χ
        while (n > count) {
            n -= count; // �� n �м�ȥ��ǰ��Χ�ڵ�λ���ܺ�
            start *= 10; // ���� start ����һ��λ����Χ����ʼֵ�����1��10���ٵ�100��
            digit += 1; // ����λ�������һλ������λ��
            count = digit * start * 9; // ���µ�ǰ��Χ�ڵ�λ���ܺͣ���λ��ʱ����90�����֣�ÿ��ռ2λ���ܼ�180λ��
        }

        // �ҵ� n ��Ӧ�ľ�������
        long num = start + (n - 1) / digit; // ȷ�� n ���ڵ����֣�����λ��ʱ��ȷ������10��99���ĸ�����

        // �ҵ��������ж�Ӧ�ľ���λ
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // ������ת��Ϊ�ַ�������ȡ�� (n-1) % digit λ�ַ�����ת��Ϊ����
    }
}
