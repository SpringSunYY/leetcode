package greenhand;

import java.util.Arrays;

/*
    03. �������ظ�������
        �ҳ��������ظ������֡�
        ��һ������Ϊ n ������ nums ����������ֶ��� 0��n-1 �ķ�Χ�ڡ�������ĳЩ�������ظ��ģ�����֪���м��������ظ��ˣ�Ҳ��֪��ÿ�������ظ��˼��Ρ����ҳ�����������һ���ظ������֡�

 */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length-1; i++) {
//            if (nums[i]==nums[i+1]){
//                return nums[i];
//            }
//        }
//        return 1;
        int a=nums[0];
        int i=1;
        while (a<nums.length){
            if (nums[a]!=nums[i]){
                i++;
                a=nums[a];
            }
            else if (nums[a]==nums[i]){
                return nums[i];
            }
        }
        return -1;
    }
}
