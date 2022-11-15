package greenhand;

import java.util.List;

public class IsPowerOfTwo {
    public static void main(String[] args) {
        System.out.println("isPowerOfTwo2(10) = " + isPowerOfTwo2(-1));
        int a= (int) Math.pow(2,0);
        System.out.println(a);
        for (int i = 0; i < 10; i++) {
            if (Math.pow(2,i)==5){
                System.out.println(1);
            }
            if (i==5){
                System.out.println(12);
            }
        }
        System.out.println(1 % 2);
    }

    public static boolean isPowerOfTwo2(int n){
        for (int i = 0; i < n; i++) {
            int a= (int) Math.pow(2,i);
            if (a==n){
                return true;
            }
            if (i>n/2){
                return false;
            }
        }
        return false;
    }
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n / 2 == 0) {
            return true;
        }

        if (n % 2 == 1) {
            return false;
        }

        while (n > 2) {
            if (n % 2 == 1) {
                return false;
            }
            n = n / 2;
        }


        return true;
    }
}
