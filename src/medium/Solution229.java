package medium;

import java.util.*;

/**
 * @Project: leetcode
 * @Package: medium
 * @Author: YY
 * @CreateTime: 2024-10-21  22:46
 * @Description: Solution229
 * 229. 多数元素 II
 * 提示
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ? n/3 ? 次的元素。
 * 示例 1：
 * 输入：nums = [3,2,3]
 * 输出：[3]
 * 示例 2：
 * 输入：nums = [1]
 * 输出：[1]
 * 示例 3：
 * 输入：nums = [1,2]
 * 输出：[1,2]
 * @Version: 1.0
 */
public class Solution229 {
    public static void main(String[] args) {

    }

    public List<Integer> majorityElement(int[] nums) {
        int length = nums.length / 3;
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        for (int num : nums) {
            if (resultMap.containsKey(num)) {
                resultMap.put(num, resultMap.get(num) + 1);
            } else {
                resultMap.put(num, 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer integer : resultMap.keySet()) {
            if (resultMap.get(integer) > length) {
                list.add(integer);
            }
        }
        return list;
    }
}
