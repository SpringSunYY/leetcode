package easy;

import java.util.Arrays;

public class SingleNumber {
    public static void main(String[] args) {
        int a[]={10,10,8,7,7,6,6,4,4,2,2,0,0};
        System.out.println("singleNumber(a) = " + singleNumber(a));
        System.out.println("Arrays.stream(a).sum() = " + Arrays.stream(a).sum());
    }
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int num=(1+nums.length-1)*nums.length/2;
        System.out.println("num = " + num);

        return num-Arrays.stream(nums).sum()/2;
    }
}
