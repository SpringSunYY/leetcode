package medium;

import java.util.Arrays;

/**
 * @Project: leetcode
 * @Package: medium
 * @Author: YY
 * @CreateTime: 2024-09-14  19:48
 * @Description: Solution16
 * 16. ��ӽ�������֮��
 * ����һ������Ϊ n ���������� nums �� һ��Ŀ��ֵ target������� nums ��ѡ������������ʹ���ǵĺ��� target ��ӽ���
 * �������������ĺ͡�
 * �ٶ�ÿ������ֻ����ǡ��һ���⡣
 * ʾ�� 1��
 * ���룺nums = [-1,2,1,-4], target = 1
 * �����2
 * ���ͣ��� target ��ӽ��ĺ��� 2 (-1 + 2 + 1 = 2)��
 * ʾ�� 2��
 * ���룺nums = [0,0,0], target = 1
 * �����0
 * ���ͣ��� target ��ӽ��ĺ��� 0��0 + 0 + 0 = 0����
 * ��ʾ��
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 * @Version: 1.0
 */
public class Solution16 {
    public static void main(String[] args) {
        int i = threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println("i = " + i);
    }

    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                } else if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }
}
