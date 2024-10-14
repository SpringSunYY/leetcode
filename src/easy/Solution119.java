package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Project: leetcode
 * @Package: easy
 * @Author: YY
 * @CreateTime: 2024-10-14  19:01
 * @Description: Solution119
 * 119. 杨辉三角 II
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * @Version: 1.0
 */
public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> resultList = new LinkedList<>();
        resultList.add(1);
        ArrayList<Integer> rowList = new ArrayList<>();
        for (int i = 1; i < rowIndex; i++) {
            rowList = new ArrayList<>(i);
            rowList.add(1);
            for (int i1 = 1; i1 < i; i1++) {
                //上一层
                rowList.add(resultList.get(i1 - 1) + resultList.get(i1));
            }
            rowList.add(1);
            resultList = rowList;
        }
        return resultList;
    }

    public static void main(String[] args) {
        Solution119 solution119 = new Solution119();
        List<Integer> row = solution119.getRow(3);
        for (Integer i : row) {
            System.out.print(i + "\t");
        }
    }
}
