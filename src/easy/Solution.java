package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 1 第一两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那?两个?整数，并返回他们的数组下标。
 * @ClassName Solution
 * @Path easy
 * @Author YY
 * @Date 2024/4/13 21:53
 * @Version 1.0
 */
public class Solution {

   public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 17;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
