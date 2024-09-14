package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Project: leetcode
 * @Package: medium
 * @Author: YY
 * @CreateTime: 2024-09-14  20:10
 * @Description: Solution15
 * 15. ����֮��
 * ����һ���������� nums ���ж��Ƿ������Ԫ�� [nums[i], nums[j], nums[k]]
 * ���� i != j��i != k �� j != k ��ͬʱ������ nums[i] + nums[j] + nums[k] == 0 �����㷵�����к�Ϊ 0 �Ҳ��ظ�����Ԫ�顣
 * ע�⣺���в����԰����ظ�����Ԫ�顣
 * ʾ�� 1��
 * ���룺nums = [-1,0,1,2,-1,-4]
 * �����[[-1,-1,2],[-1,0,1]]
 * ���ͣ�
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 ��
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 ��
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 ��
 * ��ͬ����Ԫ���� [-1,0,1] �� [-1,-1,2] ��
 * ע�⣬�����˳�����Ԫ���˳�򲢲���Ҫ��
 * ʾ�� 2��
 * ���룺nums = [0,1,1]
 * �����[]
 * ���ͣ�Ψһ���ܵ���Ԫ��Ͳ�Ϊ 0 ��
 * ʾ�� 3��
 * ���룺nums = [0,0,0]
 * �����[[0,0,0]]
 * ���ͣ�Ψһ���ܵ���Ԫ���Ϊ 0 ��
 * ��ʾ��
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * @Version: 1.0
 */
public class Solution15 {
    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
        lists = threeSum(new int[]{0, 1, 1});
        System.out.println(lists);
        lists = threeSum(new int[]{0, 0, 0});
        System.out.println(lists);
        lists = threeSum(new int[]{-2, 0, 1, 1, 2});
        System.out.println(lists);
        lists = threeSum(new int[]{-2, 0, 0, 2, 2});
        System.out.println(lists);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        HashSet<Object> hashSet = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    if (!hashSet.contains(list)) {
                        lists.add(list);
                        hashSet.add(list);
                        continue;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return lists;
    }
}
