package easy;

import dataStructure.sort.Quickly;

import java.util.Arrays;

/*
    35. ��������λ��
    ����һ�����������һ��Ŀ��ֵ�����������ҵ�Ŀ��ֵ�������������������Ŀ��ֵ�������������У����������ᱻ��˳������λ�á�
    �����ʹ��ʱ�临�Ӷ�Ϊ O(log n) ���㷨��
*/
public class SearchInsert {

    public static void main(String[] args) {
        int[] a = {1};
        int i = searchInsert(a, 0);
        System.out.println("i = " + i);
        System.out.println("a.toString() = " + Arrays.toString(a));
    }

    public static int searchInsert(int[] nums, int target) {
        int result = find(nums, target);

        if (result > -1) {
            return result;
        }

        sort(nums);

        int insert = insert(nums, target);
        return insert;
    }

    /*
        ������뷽��
     */
    public static int insert(int[] a, int h) {
        for (int i = 0; i < a.length ; i++) {
            if (a[i] >= h ) {
                return i;
            }
        }
        return a.length;
    }

    /*
        ������ҷ���
     */
    public static int find(int[] a, int byFind) {
        int left = 0;
        int right = a.length;

        for (int i = 0; i < a.length; i++) {
            if (a[left] == byFind) {
                return left;
            }
            if (a[--right] == byFind) {
                return right;
            }
            left++;
            if (left > right) {
                return -1;
            }
        }
        return -1;
    }

    /*
        ����������
     */
    public static void sort(int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        sort(a, lo, hi);
    }

    public static int partition(int[] a, int lo, int hi) {
        int key = a[lo];//������ߵĵ�Ԫ�ص�����׼
        int left = lo;//����һ�����ָ�룬��ʼָ�����ұ�Ԫ��
        int right = hi + 1;//�Ҳ� ���Ҳ����һ��Ԫ��

        //�����з�
        while (true) {
            //�ȴ�������ɨ��
            while (less(key, a[--right])) {
                //ѭ��ֹͣ��֤���ҵ���һ���Ȼ�׼ֵС��Ԫ��
                if (right == lo) {
                    break;//�Ѿ�ɨ�赽������ˣ��������ɨ��
                }
            }

            //��֮����ɨ��
            while (less(a[++left], key)) {
                //ѭ��ֹͣ��֤���ҵ���һ���Ȼ�׼ֵ���Ԫ��
                if (left == hi) {
                    break;//�Ѿ�ɨ�赽�����ұ��ˣ��������ɨ��
                }
            }

            //��ʾɨ����������Ԫ��
            if (left >= right) {
                //ѭ��ֹͣ
                break;
            } else {
                //����left��right��������Ԫ��
                exch(a, left, right);
            }
        }

        //�������right�������ͻ�׼ֵ���ڵ���������ֵ
        exch(a, lo, right);
        return right;//right�����зֵĽ���

    }

    //����Ԫ��i��j����λ��
    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    //�Ƚ�v���Ƿ�С��w
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    //����
    private static void sort(int[] a, int lo, int hi) {
        //��ȫУ��
        if (hi <= lo) {
            return;
        }

        //��Ҫ��������lo��hi���з���
        int partition = partition(a, lo, hi);//���ص��Ƿ���ķֽ�ֵ�������� �ֽ��ӱ任�������
        //������������
        sort(a, lo, partition - 1);
        //������
        sort(a, partition + 1, hi);
    }

}
