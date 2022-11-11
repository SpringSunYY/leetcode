package greenhand;

/*
    1. 两数之和
 */
public class TwoSum {
    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] num = new int[0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <i ; j++) {
                if (nums[i]+nums[j]==target){
                    num[0]=i;
                    num[1]=j;
                }
            }
        }

        return num;
    }
}
