package difficult;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

/**
 * @Description 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * @ClassName Solution4
 * @Path difficult
 * @Author YY
 * @Date 2024/4/24 16:36
 * @Version 1.0
 */
public class Solution4 {
    public static void main(String[] args) {
        int nums1[] = {1, 2}, nums2[] = {3, 4};
//        int nums1[] = {1, 2}, nums2[] = {-1, 3};
//        int nums1[] = {2, 2, 4, 4}, nums2[] = {2, 2, 4, 4};

        double result = findMedianSortedArrays(nums1, nums2);
        System.err.println("result = " + result);
        double i = 5d / 2d;
        System.out.println("5 / 2 = " + i);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //新建一个数组
        int[] totals = new int[nums1.length + nums2.length];
        int length = nums1.length;
        Arrays.sort(totals);

        //添加第一个数组
        for (int i = 0; i < nums1.length; i++) {
            totals[i] = nums1[i];
        }
        for (int i = length; i < totals.length; i++) {
            totals[i] = nums2[i - length];
        }
        Arrays.sort(totals);
        //判断是否为全部是一个数
        if (totals[0] == totals[totals.length - 1]) {
            return totals[0];
        }
        //如果为偶数，这是中间两个相加再除
        if (totals.length % 2 == 0) {
            //得到中间1，大的那个
            int number1 = totals.length / 2;
            //得到中间2 小的那个
            int number2 = totals.length / 2 - 1;

            if (totals[number1] == totals[number2]) {
                return totals[number1];
            }
            int result = (totals[number1] + totals[number2]) / 2;
            //判断能否求整数 这里判断的是 如果都是奇数则相加为偶，可以直接初二，反之为奇数，要加0.5
            if (totals[number1] % 2 == 0 && totals[number2] % 2 == 0 && result <= 2) {
                return result;
            }
            //是奇数
            return result + 0.5;

        } else {//奇数就是中间
            return totals[totals.length / 2];
        }
    }
}
