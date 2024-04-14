package medium;

import java.util.Arrays;

public class SmallestDifference {
    public static void main(String[] args) {
        int[] a={23, 127, 235, 19, 8};
        int[] b={1, 3, 15, 11, 2};
        int i = smallestDifference(a, b);
        System.out.println("i = " + i);
    }
    public static int smallestDifference(int[] a, int[] b) {
        //先给数组排序
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0;
        int j = 0;
        long min = Long.MAX_VALUE;
        //给排序后的数组作比较
        while (i < a.length && j < b.length) {
            int ai = a[i];
            int bj = b[j];
            if (ai == bj) {
                return 0;
            }
            if (ai > bj) {
                min = Math.min(min, (long)ai - bj);
                j++;
            } else {
                min = Math.min(min, (long)bj - ai);
                i++;
            }
        }
        return (int)min;

    }
}
