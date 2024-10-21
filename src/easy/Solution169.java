package easy;

/**
 * @Project: leetcode
 * @Package: easy
 * @Author: YY
 * @CreateTime: 2024-10-21  22:25
 * @Description: Solution169
 * 169. ����Ԫ��
 * ����һ����СΪ n ������ nums ���������еĶ���Ԫ�ء�����Ԫ����ָ�������г��ִ��� ���� ? n/2 ? ��Ԫ�ء�
 * ����Լ��������Ƿǿյģ����Ҹ������������Ǵ��ڶ���Ԫ�ء�
 * ʾ�� 1��
 * ���룺nums = [3,2,3]
 * ʾ�� 2��
 * ���룺nums = [2,2,1,1,1,2,2]
 * �����2
 * @Version: 1.0
 */
public class Solution169 {
    public static void main(String[] args) {
        Solution169 solution169 = new Solution169();
        int i = solution169.majorityElement(new int[]{1, 1, 2, 4, 5, 5, 5, 6, 4});
        System.out.println("i = " + i);
    }

    public int majorityElement(int[] nums) {
        //���ִ���
        int x = 0;
        //���ؽ��
        int res = 0;
        for (int num : nums) {
            //���x=0���¼�������
             if (num == res) {    //������ڵ�ǰ���������ִ���++
                x++;
            } else {    //��֮--
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
