package easy;

/**
 * @Project: leetcode
 * @Package: easy
 * @Author: YY
 * @CreateTime: 2024-10-21  22:25
 * @Description: Solution169
 * 169. 多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ? n/2 ? 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1：
 * 输入：nums = [3,2,3]
 * 示例 2：
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * @Version: 1.0
 */
public class Solution169 {
    public static void main(String[] args) {
        Solution169 solution169 = new Solution169();
        int i = solution169.majorityElement(new int[]{1, 1, 2, 4, 5, 5, 5, 6, 4});
        System.out.println("i = " + i);
    }

    public int majorityElement(int[] nums) {
        //出现次数
        int x = 0;
        //返回结果
        int res = 0;
        for (int num : nums) {
            //如果x=0重新计算众数
             if (num == res) {    //如果等于当前众数，出现次数++
                x++;
            } else {    //反之--
                x--;
                 if (x == 0) {
                     x = 1;
                     res = num;
                 }
            }
        }
        return res;
    }
}
