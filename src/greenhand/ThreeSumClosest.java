package greenhand;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int a[] = {4, 0, 5, -5, 3, 3, 0, -4, -5};
        int b = -2;
        int i = threeSumClosest(a, b);
        System.out.println("i = " + i);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int re=0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length-1; j++) {
                for (int k = 2; k < nums.length-2; k++) {
                    if (nums[i]+nums[j]+nums[k]==target+i||nums[i]+nums[j]+nums[k]==target-i){
                       re= nums[i]+nums[j]+nums[k];
                    }
                }
            }
        }
        return re;
    }
}

