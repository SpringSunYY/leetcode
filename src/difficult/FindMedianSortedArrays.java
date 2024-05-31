package difficult;

import java.util.Arrays;

/*
    4. 寻找两个正序数组的中位数
        给定两个大小分别为 m 和 n 的正序（从小到大）数组?nums1 和?nums2。请你找出并返回这两个正序数组的 中位数 。
        算法的时间复杂度应该为 O(log (m+n)) 。
 */

/*
    题解
        把两个数组合并成一个数组
        给新数组排序
        长度偶数中将两个相加
        奇数返回中间值
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println("medianSortedArrays = " + medianSortedArrays);
        System.out.println(1 % 2);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        TreeSet<Object> objects = new TreeSet<>();
//        for (int i = 0; i < nums1.length; i++) {
//            objects.add(nums1[i]);
//        }for (int i = 0; i < nums2.length; i++) {
//            objects.add(nums2[i]);
//        }
//        List list=new ArrayList<>();
//        list.addAll(objects);
//
//        if (list.size()%2!=0){
//            double x= (int) list.get(list.size()/2-1)+0.0;
//            double y= (int) list.get(list.size()/2-1)+0.0;
//
//            if(x%2==0&&y%2==0){
//                return ((x+y)/2);
//            }
//            return ((x+y)/2)+0.5;
//        }else {
//            int x=(int) list.get(list.size()/2-1);
//            return x;
//        }


        int[] a = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            a[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            a[i + nums1.length] = nums2[i];
        }

        Arrays.sort(a);
        if (a.length % 2 == 0) {
            double x = a[a.length / 2];
            double y = a[a.length / 2 - 1];

            if (x % 2 == 0 && y % 2 == 0) {
                return ((x + y) / 2);
            }
            return ((x + y) / 2) + 0.5;
        } else {
            return a[a.length / 2];
        }
    }
}
