package medium;

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        int[] a = {3,30,34,5,9};
        System.out.println(2008 / 1 % 10);
        System.out.println(32 / 1 % 10 > 31 / 1 % 10);
        largestNumber(a);
        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));
    }

    public static String largestNumber(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                compare(nums, j, j+1 );
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int num : nums) {
            stringBuffer.append(num);
        }
        //System.out.println(Arrays.toString(nums));
        return stringBuffer.toString();
    }

    public static void compare(int a[], int i, int j) {
        int x = 1;
        int y = 1;
        int b = a[i];
        int c = a[j];
        while (a[i] > x * 10) {
            x *= 10;
        }
        while (a[j] > y * 10) {
            y *= 10;
        }
        int x1 = x;
        int y1 = y;
        while (x>=1) {
            if (a[i] == a[j]) {
                break;
            }
            System.out.println(b + "b/x----->" + b / x + "  x=" + x);
            System.out.println(b + "b/x----->" + b / x % 10);
//            System.out.println(c+"c/x----->"+c/y);
//            System.out.println(c+"c/x----->"+c/y%10);
            if ((b / x % 10) < (c / y % 10)) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                break;
            }if (x==1){
                x=x1;
                break;
            }if (y==1){

                y=y1;
                break;
            }
            else {
                x /= 10;
                y /= 10;
                System.out.println("x = " + x);
                if (x == 0) {

                    x = 1;
                }
                if (y == 0) {
                    y = 1;
                }
            }
        }
    }
}
