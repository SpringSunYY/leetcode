package easy;

/**
 * @Project: leetcode
 * @Package: easy
 * @Author: YY
 * @CreateTime: 2024-09-25  18:54
 * @Description: Solution22
 * ����һ�� ���ϸ�������� ������ nums ������ ԭ�� ɾ���ظ����ֵ�Ԫ�أ�ʹÿ��Ԫ�� ֻ����һ�� ������ɾ����������³��ȡ�Ԫ�ص� ���˳�� Ӧ�ñ��� һ�� ��Ȼ�󷵻� nums ��ΨһԪ�صĸ�����
 * ���� nums ��ΨһԪ�ص�����Ϊ k ������Ҫ����������ȷ����������Ա�ͨ����
 * �������� nums ��ʹ nums ��ǰ k ��Ԫ�ذ���ΨһԪ�أ���������������� nums �г��ֵ�˳�����С�nums ������Ԫ���� nums �Ĵ�С����Ҫ��
 * ���� k ��
 * @Version: 1.0
 */
public class Solution22 {
    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        System.out.println("solution22 = " + solution22.removeDuplicates(new int[]{1, 1, 2}));
    }

    public int removeDuplicates(int[] nums) {
        int result = 0;
        int current = 1;
        while (current < nums.length) {
            if (nums[result] == nums[current]) {
                current++;
                continue;
            }
            result++;
            nums[result] = nums[current];
            current++;
        }
        for (int num : nums) {
            System.out.println(num);
        }
        return result;
    }
}
