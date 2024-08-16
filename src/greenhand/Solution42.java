package greenhand;

/**
 * @Project: leetcode
 * @Package: greenhand
 * @Author: YY
 * @CreateTime: 2024-08-16  14:28
 * @Description: Solution42
 * 42. 接雨水
 * 困难
 * 相关标签
 * 相关企业
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * @Version: 1.0
 */
public class Solution42 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int waterTrapped = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                waterTrapped += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                waterTrapped += rightMax - height[right];
            }
        }

        return waterTrapped;
    }

    public static void main(String[] args) {
        Solution42 solution = new Solution42();

        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result1 = solution.trap(height1);
        System.out.println("示例 1 的输出：" + result1);  // 输出：6

        int[] height2 = {4,2,0,3,2,5};
        int result2 = solution.trap(height2);
        System.out.println("示例 2 的输出：" + result2);  // 输出：9
    }
}
