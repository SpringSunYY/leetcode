package easy;

import dataStructure.sort.Quickly;

import java.util.Arrays;

/*
    35. 搜索插入位置
    给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    请必须使用时间复杂度为 O(log n) 的算法。
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
        定义插入方法
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
        定义查找方法
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
        以下是排序
     */
    public static void sort(int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        sort(a, lo, hi);
    }

    public static int partition(int[] a, int lo, int hi) {
        int key = a[lo];//把最左边的的元素当作基准
        int left = lo;//定义一个左侧指针，初始指向最右边元素
        int right = hi + 1;//右侧 最右侧的下一个元素

        //进行切分
        while (true) {
            //先从左往右扫描
            while (less(key, a[--right])) {
                //循环停止，证明找到了一个比基准值小的元素
                if (right == lo) {
                    break;//已经扫描到最左边了，无需继续扫描
                }
            }

            //反之从左扫描
            while (less(a[++left], key)) {
                //循环停止，证明找到了一个比基准值大的元素
                if (left == hi) {
                    break;//已经扫描到了最右边了，无需继续扫描
                }
            }

            //表示扫描完了所有元素
            if (left >= right) {
                //循环停止
                break;
            } else {
                //交换left和right索引处的元素
                exch(a, left, right);
            }
        }

        //交换最后right索引处和基准值所在的索引处的值
        exch(a, lo, right);
        return right;//right就是切分的界限

    }

    //数组元素i和j交换位置
    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    //比较v数是否小于w
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    //排序
    private static void sort(int[] a, int lo, int hi) {
        //安全校验
        if (hi <= lo) {
            return;
        }

        //需要对数组中lo到hi进行分组
        int partition = partition(a, lo, hi);//返回的是分组的分界值所在索引 分界子变换后的索引
        //让左子组有序
        sort(a, lo, partition - 1);
        //右子组
        sort(a, partition + 1, hi);
    }

}
