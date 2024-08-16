package medium;

/**
 * @Project: leetcode
 * @Package: medium
 * @Author: YY
 * @CreateTime: 2024-08-16  14:13
 * @Description: Solution11
 * 11. ʢ���ˮ������
 * ���Թ�
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ������Ϊ n ���������� height ���� n �����ߣ��� i ���ߵ������˵��� (i, 0) �� (i, height[i]) ��
 * �ҳ����е������ߣ�ʹ�������� x �Ṳͬ���ɵ�����������������ˮ��
 * �����������Դ�������ˮ����
 * @Version: 1.0
 */
public class Solution11 {
    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int i1 = solution11.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println("i = " + i1);
        int i2 = solution11.maxArea(new int[]{1, 1, 12, 12, 12});
        System.out.println("i = " + i2);
    }

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                max = Math.max(max, (right - left) * height[left]);
                left++;
            } else {
                max = Math.max(max, (right - left) * height[right]);
                right--;
            }
        }
        return max;
    }
}
