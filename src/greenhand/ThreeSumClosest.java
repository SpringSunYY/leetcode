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
        int sum=nums[1]+nums[0]+nums[2];
        while (true)
        return sum;
    }
}

