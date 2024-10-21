package medium;

import java.util.*;

/**
 * @Project: leetcode
 * @Package: medium
 * @Author: YY
 * @CreateTime: 2024-10-21  22:46
 * @Description: Solution229
 * 229. ����Ԫ�� II
 * ��ʾ
 * ����һ����СΪ n ���������飬�ҳ��������г��ֳ��� ? n/3 ? �ε�Ԫ�ء�
 * ʾ�� 1��
 * ���룺nums = [3,2,3]
 * �����[3]
 * ʾ�� 2��
 * ���룺nums = [1]
 * �����[1]
 * ʾ�� 3��
 * ���룺nums = [1,2]
 * �����[1,2]
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
