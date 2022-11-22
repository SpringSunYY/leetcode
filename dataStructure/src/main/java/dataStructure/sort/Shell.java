package dataStructure.sort;


import java.util.Arrays;

/*
    希尔排序
    时间复杂度
 */
public class Shell {
    public static void main(String[] args) {
        Integer[] a = {9, 1, 2, 5, 7, 4, 8, 6, 3, 5};
        sort(a);
        System.out.println("a = " + Arrays.toString(a));
    }

    public static void sort(Comparable[] a) {
        //根据的长度确定增长量h的初始值
        int h = 1;
        while (h < a.length / 2) {
            h = 2 * h + 1;
        }

        //希尔排序
        while (h >= 1) {
            //排序
            //1找到待插入的元素
            for (int i = h; i < a.length; i++) {
                //把待插入的元素插入到有序序列中
                for (int j = i; j >= h; j--) {
                    //待插入的元素是a[j],比较a[j]和a[j-h]
                    if (greater(a[j - h], a[j])) {
                        //交换元素
                        exch(a, j - h, j);
                    } else {
                        break;
                    }
                }
            }
            //2把待插入的元素
            //减小h的值
            h /= 2;
        }
    }

    //比较v否大于w
    public static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    //数组元素i和j交换位置
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
