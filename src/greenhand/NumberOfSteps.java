package greenhand;

public class NumberOfSteps {
    public static void main(String[] args) {
        int i = numberOfSteps1(0);
        System.out.println(i);
    }

    public static int numberOfSteps1(int num) {

        int a = 1;
        while (true) {
            if (num % 2 == 0) {
                num = num / 2;
                a++;
            } else if (num % 2 == 1) {
                num = num - 1;
                a++;
            }
            if (num == 0) {
                return a;
            }
        }
    }
}
