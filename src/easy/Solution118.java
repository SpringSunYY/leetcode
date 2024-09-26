package easy;

import java.util.*;

/**
 * @Project: leetcode
 * @Package: easy
 * @Author: YY
 * @CreateTime: 2024-09-26  19:22
 * @Description: Solution118
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 示例 1:
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 * 输入: numRows = 1
 * 输出: [[1]]
 * @Version: 1.0
 */
public class Solution118 {
    public static void main(String[] args) {
        Solution118 solution118 = new Solution118();
        List<List<Integer>> generate = solution118.generate(10);
        for (List<Integer> integers : generate) {
            for (Integer integer : integers) {
                System.out.print(integer+"\t");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> lists = new ArrayList<>(numRows);
        lists.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>(i + 1);
            list.add(1);
            for (int i1 = 1; i1 < i; i1++) {
                // 左上方的数 + 正上方的数
                list.add(lists.get(i - 1).get(i1 - 1) + lists.get(i - 1).get(i1));
            }
            list.add(1);
            lists.add(list);
        }
        return lists;
    }
}
