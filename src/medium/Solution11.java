package medium;

/**
 * @Project: leetcode
 * @Package: medium
 * @Author: YY
 * @CreateTime: 2024-08-16  14:13
 * @Description: Solution11
 * 11. 盛最多水的容器
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * @Version: 1.0
 */
public class Solution11 {
    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int i1 = solution11.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println("i = " + i1);
        int i2 = solution11.maxArea(new int[]{1, 1, 12, 12, 12});
        System.out.println("i = " + i2);
    }

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                max = Math.max(max, (right - left) * height[left]);
                left++;
            } else {
                max = Math.max(max, (right - left) * height[right]);
                right--;
            }
        }
        return max;
    }
}
