package greenhand;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 260. 只出现一次的数字 III
 * 给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。
 * 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        int[] ints = singleNumber(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] singleNumber(int[] nums) {
        //如果nums长度为2，则直接返回
        if (nums.length<=2){
            return nums;
        }

        //用hashSet存所需数字
        HashSet<Integer> set = new HashSet<>();
        for (int n:nums){
            //将nums存入set，如果set中有这个元素，则直接删除这个元素
            if (set.contains(n)){
                set.remove(n);
            }else {     //如果没有这个元素，则直接存入set
                set.add(n);
            }
        }

        int[] result = new int[2];
        int i=0;
        for (Integer integer : set) {
            result[i]=integer;
            i++;
        }

        return result;
    }
}
