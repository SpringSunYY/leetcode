package dataStructure.sort;

import java.util.Arrays;

/*
    插入排序
    时间复杂度n**2
 */
public class Insertion {
    public static void main(String[] args) {
        Integer[] arr={4,6,8,7,9,2,10,1};
        insertion(arr);

        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    public static void insertion(Comparable[] a ){
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j >0 ; j--) {
                //比较比j和j-1的值 找到合适位置退出
                if (greater(a[j-1],a[j])){
                    exch(a,j-1,j);
                }else {
                    break;
                }
            }
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
