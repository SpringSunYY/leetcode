package greenhand;

import java.util.Arrays;

/*
    03. 数组中重复的数字
        找出数组中重复的数字。
        在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

 */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length-1; i++) {
//            if (nums[i]==nums[i+1]){
//                return nums[i];
//            }
//        }
//        return 1;
        int a=nums[0];
        int i=1;
        while (a<nums.length){
            if (nums[a]!=nums[i]){
                i++;
                a=nums[a];
            }
            else if (nums[a]==nums[i]){
                return nums[i];
            }
        }
        return -1;
    }
}
