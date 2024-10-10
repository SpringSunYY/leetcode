package medium;

import java.util.ArrayList;

/**
 * @Project: leetcode
 * @Package: medium
 * @Author: YY
 * @CreateTime: 2024-10-07  19:19
 * @Description: Solution48
 * 48. ��תͼ��
 * ����һ�� n �� n �Ķ�ά���� matrix ��ʾһ��ͼ�����㽫ͼ��˳ʱ����ת 90 �ȡ�
 * ������� ԭ�� ��תͼ������ζ������Ҫֱ���޸�����Ķ�ά�����벻Ҫ ʹ����һ����������תͼ��
 * @Version: 1.0
 */
public class Solution48 {
    public static void main(String[] args) {
        Solution48 solution48 = new Solution48();
        solution48.rotate(new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}});
    }

    // ����һ����ת����������Ϊһ����ά����matrix
    public void rotate(int[][] matrix) {
        // ����һ��ArrayList<Integer>��������ʱ�洢��ת���Ԫ��
        ArrayList<Integer> tempList = new ArrayList<>();

        // �Ӷ�ά��������½ǿ�ʼ��������Ԫ����ӵ�tempList��
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int i1 = 0; i1 <= matrix[i].length - 1; i1++) {
                tempList.add(matrix[i][i1]);
            }
        }

        // ��ʼ����ǰҪ���õ�Ԫ���ڶ�ά�����е��кź��к�
        int currentIndex = 0;
        int numLength = matrix[0].length;
        int current = 0;

        // ��tempList��ȡ��Ԫ�أ�����˳ʱ����ת90�ȵ�˳����õ���ά������
        for (int i = 0; i < tempList.size(); i++) {
            matrix[current][currentIndex] = tempList.get(i);
            current++;
            // �����ǰҪ���õ�Ԫ���Ѿ������ά��������һ�У���ô��current����Ϊ0������currentIndex��1
            if (current >= numLength) {
                current = 0;
                currentIndex++;
            }
        }
    }




    public void rotate2(int[][] matrix) {
        int add = 0; // ���ڼ�¼ÿ����ת��Ԫ�ظ���
        int temp = 0; // �����ݴ���ת�����е�Ԫ��
        int pos1 = 0; // ��¼��ת��������ʼ��
        int pos2 = matrix[0].length - 1; // ��¼��ת��������ʼ��

        while (pos1 < pos2) { // ����ʼ��С����ʼ��ʱ��ִ����ת����
            add = 0; // ��add��Ϊ0
            while (add < pos2 - pos1) { // ��add�ӵ�pos2 - pos1ʱ��ֹͣ��ת
                temp = matrix[pos1][pos1 + add]; // �ݴ�matrix[pos1][pos1 + add]��ֵ��temp
                matrix[pos1][pos1 + add] = matrix[pos2 - add][pos1]; // ��matrix[pos1][pos1 + add]��ֵ��ֵΪmatrix[pos2 - add][pos1]
                matrix[pos2 - add][pos1] = matrix[pos2][pos2 - add]; // ��matrix[pos2 - add][pos1]��ֵ��ֵΪmatrix[pos2][pos2 -add]
                matrix[pos2][pos2 - add] = matrix[pos1 + add][pos2]; // ��matrix[pos2][pos2 -add]��ֵ��ֵΪmatrix[pos1 + add][pos2]
                matrix[pos1 + add][pos2] = temp; // ��matrix[pos1 + add][pos2]��ֵ��ֵΪtemp
                add++; // add��1
            }
            pos1++; // ��pos1��1
            pos2--; // ��pos2��1
        }
    }

}
