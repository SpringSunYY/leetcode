package greenhand;

/**
 * @Project: leetcode
 * @Package: greenhand
 * @Author: YY
 * @CreateTime: 2024-08-16  14:28
 * @Description: Solution42
 * 42. ����ˮ
 * ����
 * ��ر�ǩ
 * �����ҵ
 * ���� n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��
 * ʾ�� 1��
 * ���룺height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * �����6
 * ���ͣ������������� [0,1,0,2,1,0,1,3,2,1,2,1] ��ʾ�ĸ߶�ͼ������������£����Խ� 6 ����λ����ˮ����ɫ���ֱ�ʾ��ˮ����
 * ʾ�� 2��
 * ���룺height = [4,2,0,3,2,5]
 * �����9
 * @Version: 1.0
 */
public class Solution42 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int waterTrapped = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                waterTrapped += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                waterTrapped += rightMax - height[right];
            }
        }

        return waterTrapped;
    }

    public static void main(String[] args) {
        Solution42 solution = new Solution42();

        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result1 = solution.trap(height1);
        System.out.println("ʾ�� 1 �������" + result1);  // �����6

        int[] height2 = {4,2,0,3,2,5};
        int result2 = solution.trap(height2);
        System.out.println("ʾ�� 2 �������" + result2);  // �����9
    }
}
