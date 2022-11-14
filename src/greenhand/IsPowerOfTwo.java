package greenhand;

import java.util.List;

public class IsPowerOfTwo {
    public static void main(String[] args) {
        System.out.println(1 % 2);
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
}
