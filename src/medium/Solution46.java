package medium;

import java.time.temporal.ValueRange;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Project: leetcode
 * @Package: medium
 * @Author: YY
 * @CreateTime: 2024-09-30  19:15
 * @Description: Solution46
 * 46. ȫ����
 * ����һ�������ظ����ֵ����� nums �������� ���п��ܵ�ȫ���� ������� ������˳�� ���ش𰸡�
 * ʾ�� 1��
 * ���룺nums = [1,2,3]
 * �����[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * ʾ�� 2��
 * ���룺nums = [0,1]
 * �����[[0,1],[1,0]]
 * ʾ�� 3��
 * ���룺nums = [1]
 * �����[[1]]
 * ��ʾ��
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums �е��������� ������ͬ
 * @Version: 1.0
 */
public class Solution46 {
    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        int nums = 0;
        List<List<Integer>> permute = solution46.permute(new int[]{1, 2, 3});
        for (List<Integer> integers : permute) {
            for (Integer integer : integers) {
                System.out.print(integer + ",");
            }
            System.out.println();
            nums++;
        }
        System.out.println("nums = " + nums);
    }


    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // ʹ��һ����̬���鱣�����п��ܵ�ȫ����
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;

                System.out.println("  �ݹ�֮ǰ => " + path);
                dfs(nums, len, depth + 1, path, used, res);

                used[i] = false;
                path.removeLast();
                System.out.println("�ݹ�֮�� => " + path);
            }
        }
    }
}
