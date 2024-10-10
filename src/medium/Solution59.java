package medium;

/**
 * @Project: leetcode
 * @Package: medium
 * @Author: YY
 * @CreateTime: 2024-10-09  18:48
 * 59. �������� II
 * ����һ�������� n ������һ������ 1 �� n2 ����Ԫ�أ���Ԫ�ذ�˳ʱ��˳���������е� n x n �����ξ��� matrix ��
 * @Description: Solution59
 * @Version: 1.0
 */
public class Solution59 {
    public static void main(String[] args) {
        Solution59 solution59 = new Solution59();
        int[][] ints = solution59.generateMatrix(5);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int value = 1;
        int l = 0, r = n - 1, t = 0, b = n - 1;
        while (value <= n * n) {
            //��ǰ���������
            for (int i = l; i <= r; i++) {
                result[t][i] = value++;
            }
            //��ǰ������ɣ�+1
            t++;
            //��ǰ���Ҳ���ϵ���
            for (int i = t; i <= b; i++) {
                result[i][r] = value++;
            }
            //��ǰ���Ҳ�-1
            r--;
            //��ǰ���²���ҵ���
            for (int i = r; i >= l; i--) {
                result[b][i] = value++;
            }
            //���²���ɣ�-1
            b--;
            //��ǰ�������µ���
            for (int i = b; i >= t; i--) {
                result[i][l] = value++;
            }
            //�����+1
            l++;
        }
        return result;
    }
}
