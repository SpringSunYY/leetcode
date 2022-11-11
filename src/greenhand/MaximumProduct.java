package greenhand;

import java.util.Arrays;

/*
623
 */
public class MaximumProduct {
    public static void main(String[] args) {
        int max = max(new int[]{1,5, 2, 3, 4});
        System.out.println(max);
    }
    public static int max(int[] nums){
        int temp;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length-i; j++) {
                if (nums[j]>nums[j+1]){
                    temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        int n=nums.length;
        return Math.max(nums[n-1]*nums[n-2]*nums[n-3],nums[0]*nums[1]*nums[2]) ;
    }
}
