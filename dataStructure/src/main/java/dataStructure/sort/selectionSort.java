package dataStructure.sort;

import java.util.Arrays;

/*
    选择排序
 */
public class selectionSort {

    public static void main(String[] args) {
        Integer[] arr={4,6,8,7,9,2,10,1};
        sort(arr);

        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    //选择排序
    public static void sort(Comparable[] a){
        for (int i = 0; i < a.length-2;i++) {
            //第一一个变量记录最小索引 默认第一个
            int minIndex=i;
            for (int j = i+1; j <a.length ; j++) {
                //比较最小索引处值和j索引处的值
                if (greater(a[minIndex],a[j])){
                    minIndex=j;
                }
            }

            //交换最小值所在索引index的值和索引i处的值
            exch(a,i,minIndex);
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
