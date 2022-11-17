package greenhand;
/*
268. 丢失的数字
给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 */

import java.util.Arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] + 1 != nums[i + 1]) {
//                return nums[i] + 1;
//            }
//        }
//
//        if (nums[0]==0){
//            return 1;
//        }
////判断数组长度是否等于1 如果等于1，判断nums0是否等于1，如果等于返回0 如果不等于判断nums0是否大于0，如果大于返回num0-1如果不是返回最后一位+1 有问题
        return nums.length == 1 ? nums[nums.length - 1] == 1 ? nums[0] - 1 : nums[nums.length - 1]:nums[0]>0?nums[0]-1:nums[nums.length-1]+1;

        int a=nums.length-1;
        for (int i = nums.length-1; i >0; i--) {
            if (nums[i]==a){
                a--;
            }if (a==0&&nums[i]==0){
                return nums[nums.length-1]+1;
            }
            if (a!=nums[i]){
                return a;
            }
        }

        return nums[0]==0?1:nums[nums.length-1]+1;
    }
}
