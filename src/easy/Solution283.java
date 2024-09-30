package easy;

/**
 * @Project: leetcode
 * @Package: easy
 * @Author: YY
 * @CreateTime: 2024-09-29  19:43
 * @Description: Solution283
 * 283. �ƶ���
 * ����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��

 * ��ע�� �������ڲ���������������ԭ�ض�������в�����
 * ʾ�� 1:
 * ����: nums = [0,1,0,3,12]
 * ���: [1,3,12,0,0]
 * ʾ�� 2:
 * ����: nums = [0]
 * ���: [0]
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * @Version: 1.0
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        //��¼��0������
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0) {
                nums[j++]=nums[i];
            }
        }
        //��������ȫ����0
        for (int i = j; i < nums.length; i++) {
            nums[i]=0;
        }
    }
}
