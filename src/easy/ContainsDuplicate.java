package easy;

import java.util.HashMap;
import java.util.HashSet;

/*
    217. 存在重复元素
    给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
//        sort(nums);
//        for (int i = 0; i < nums.length-1; i++) {
//            if (nums[i]==nums[i+1]){
//                return true;
//            }
//        }
//        return false;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)){
                return true;
            }
        }

        return false;
    }

    public static void sort(int[] a){
        int h=1;
        while (h<a.length/2){
            h=2*h+1;
        }
        int temp;
        //希尔排序
        while (h>=1){
            for (int i = h; i <a.length ; i++) {
                for (int j = i; j>=h ; j--) {
                    if (a[j-h]>a[j]){
                        temp=a[j-h];
                        a[j-h]=a[j];
                        a[j]=temp;
                    }
                    else {
                        break;
                    }
                }
            }
            h/=2;
        }
    }
}
