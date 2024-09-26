package easy;

import java.util.*;

/**
 * @Project: leetcode
 * @Package: easy
 * @Author: YY
 * @CreateTime: 2024-09-26  19:22
 * @Description: Solution118
 * ����һ���Ǹ����� numRows�����ɡ�������ǡ���ǰ numRows �С�
 * �ڡ�������ǡ��У�ÿ�����������Ϸ������Ϸ������ĺ͡�
 * ʾ�� 1:
 * ����: numRows = 5
 * ���: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * ʾ�� 2:
 * ����: numRows = 1
 * ���: [[1]]
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
                // ���Ϸ����� + ���Ϸ�����
                list.add(lists.get(i - 1).get(i1 - 1) + lists.get(i - 1).get(i1));
            }
            list.add(1);
            lists.add(list);
        }
        return lists;
    }
}
