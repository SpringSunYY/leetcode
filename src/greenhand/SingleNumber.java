package greenhand;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 260. ֻ����һ�ε����� III
 * ����һ���������� nums������ǡ��������Ԫ��ֻ����һ�Σ���������Ԫ�ؾ��������Ρ�
 * �ҳ�ֻ����һ�ε�������Ԫ�ء�����԰� ����˳�� ���ش𰸡�
 * �������Ʋ�ʵ������ʱ�临�Ӷȵ��㷨�ҽ�ʹ�ó�������ռ�����������⡣
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        int[] ints = singleNumber(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] singleNumber(int[] nums) {
        //���nums����Ϊ2����ֱ�ӷ���
        if (nums.length<=2){
            return nums;
        }

        //��hashSet����������
        HashSet<Integer> set = new HashSet<>();
        for (int n:nums){
            //��nums����set�����set�������Ԫ�أ���ֱ��ɾ�����Ԫ��
            if (set.contains(n)){
                set.remove(n);
            }else {     //���û�����Ԫ�أ���ֱ�Ӵ���set
                set.add(n);
            }
        }

        int[] result = new int[2];
        int i=0;
        for (Integer integer : set) {
            result[i]=integer;
            i++;
        }

        return result;
    }
}
