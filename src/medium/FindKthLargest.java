package medium;

import dataStructure.sort.Shell;

import java.util.Arrays;

/*
    剑指 Offer II 076. 数组中的第 k 大的数字
        54

        给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
        请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class FindKthLargest {
    public static void main(String[] args) {
        int[] a = {9, 1, 2, 5, 7, 4, 8, 6, 3, 5};
        sort(a);
        System.out.println("a = " + Arrays.toString(a));
    }
    public int findKthLargest(int[] nums, int k) {
        sort(nums);
        return nums[nums.length-k-1];
    }

    public static void sort(int[] a){
        int h=1;
        while (h<a.length/2){
            h=2*h+1;
        }

        while (h>=1){
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >=h ; j--) {
                    if (a[j-h]>a[j]){
                        int temp=a[j-h];
                        a[j-h]=a[j];
                        a[j]=temp;
                    }else {
                        break;
                    }
                }
            }
            h/=2;
        }
    }
}
