package greenhand;
/*
268. ��ʧ������
����һ������ [0, n] �� n ���������� nums ���ҳ� [0, n] �����Χ��û�г����������е��Ǹ�����
 */

import java.util.Arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] + 1 != nums[i + 1]) {
//                return nums[i] + 1;
//            }
//        }
//
//        if (nums[0]==0){
//            return 1;
//        }
////�ж����鳤���Ƿ����1 �������1���ж�nums0�Ƿ����1��������ڷ���0 ����������ж�nums0�Ƿ����0��������ڷ���num0-1������Ƿ������һλ+1 ������
        return nums.length == 1 ? nums[nums.length - 1] == 1 ? nums[0] - 1 : nums[nums.length - 1]:nums[0]>0?nums[0]-1:nums[nums.length-1]+1;

        int a=nums.length-1;
        for (int i = nums.length-1; i >0; i--) {
            if (nums[i]==a){
                a--;
            }if (a==0&&nums[i]==0){
                return nums[nums.length-1]+1;
            }
            if (a!=nums[i]){
                return a;
            }
        }

        return nums[0]==0?1:nums[nums.length-1]+1;
    }
}
