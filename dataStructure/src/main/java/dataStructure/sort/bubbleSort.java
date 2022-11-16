package dataStructure.sort;

import java.util.Arrays;

/*
    冒泡排序法
 */
public class bubbleSort {

    public static void main(String[] args) {
        Integer[] arr={4,6,8,7,9,2,10,1};
        sort(arr);

        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    //冒泡排序
    private static void sort(Comparable[] a ){
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                //比较索引
                if (greater(a[j],a[j+1])){
                    exch(a,j,j+1);
                }
            }
        }
    }

    //比较v否大于w
    public static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }

    //数组元素i和j交换位置
    private static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp=a[i];
        a[i] = a[j];
        a[j]=temp;
    }
}
