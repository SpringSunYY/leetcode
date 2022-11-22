package medium;

import dataStructure.sort.Shell;

import java.util.Arrays;

/*
    ��ָ Offer II 076. �����еĵ� k �������
        54

        ������������ nums ������ k���뷵�������е� k ������Ԫ�ء�
        ��ע�⣬����Ҫ�ҵ������������ĵ� k ������Ԫ�أ������ǵ� k ����ͬ��Ԫ�ء�
 */
public class FindKthLargest {
    public static void main(String[] args) {
        int[] a = {9, 1, 2, 5, 7, 4, 8, 6, 3, 5};
        sort(a);
        System.out.println("a = " + Arrays.toString(a));
    }
    public int findKthLargest(int[] nums, int k) {
        sort(nums);
        return nums[nums.length-k-1];
    }

    public static void sort(int[] a){
        int h=1;
        while (h<a.length/2){
            h=2*h+1;
        }

        while (h>=1){
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >=h ; j--) {
                    if (a[j-h]>a[j]){
                        int temp=a[j-h];
                        a[j-h]=a[j];
                        a[j]=temp;
                    }else {
                        break;
                    }
                }
            }
            h/=2;
        }
    }
}
