package greenhand;

import java.util.Arrays;

public class MissingNumber2 {

    public static void main(String[] args) {
        int a[]={3,0,1};
        int i = missingNumber(a);
        System.out.println("i = " + i);
    }

    public static int missingNumber(int[] nums) {
        // return (1+nums.length)*nums.length/2-Arrays.stream(nums).sum(); ·½·¨Ò»
        int sum=(1+nums.length)*nums.length/2;
        //    int sum1=0;
        int i=0;
        while (i<nums.length){
            sum-=nums[i];
            i++;
        }

        // return sum-sum1;
        return sum;
    }
}
