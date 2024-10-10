package medium;

import dataStructure.Main;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project: leetcode
 * @Package: medium
 * @Author: YY
 * @CreateTime: 2024-10-10  18:22
 * @Description: Solution54
 * 54. ��������
 * ����һ�� m �� n �еľ��� matrix ���밴�� ˳ʱ������˳�� �����ؾ����е�����Ԫ�ء�
 * @Version: 1.0
 */
public class Solution54 {
    public static void main(String[] args) {
        Solution54 solution54 = new Solution54();
        List<Integer> integers = solution54.spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
        });
        for (Integer integer : integers) {
            System.out.print(integer + "\t");
        }
        System.out.println("integers = " + integers.size());
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        //��ʼ��list��list����
        int initIndex = 0;
        List<Integer> resultList = new ArrayList<>();
        //��������Ŀ�� ���ĸ������һ����
        int yLength = matrix.length;
        int xLength = matrix[0].length;
        int t = 0, r = xLength - 1, b = yLength - 1, l = 0;
        System.out.println("t = " + t);
        System.out.println("r = " + r);
        System.out.println("b = " + b);
        System.out.println("l = " + l);
        while (true) {
            //�������������
            for (int i = l; i <= r; i++) resultList.add(initIndex++, matrix[t][i]);
            //����������
            if (++t > b) break;
            //�������Ҵ��ϵ���
            for (int i = t; i <= b; i++) resultList.add(initIndex++, matrix[i][r]);
            //�Ҳ�������
            if (--r < l) break;
            //�ײ���ҵ���
            for (int i = r; i >= l; i--) resultList.add(initIndex++, matrix[b][i]);
            //�ײ�������
            if (--b < t) break;
            //�����µ���
            for (int i = b; i >= t; i--) resultList.add(initIndex++, matrix[i][l]);
            //���������
            if (++l > r) break;
        }
        return resultList;
    }
}
