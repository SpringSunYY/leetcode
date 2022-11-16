package greenhand;

class AddDigits {
    public static void main(String[] args) {
        int i = addDigits(57569205);
        System.out.println(i);
        System.out.println(57569205%9);
    }
    public static int addDigits(int num) {
        int a=0;
        int b=0;
        while (num!=0){
            a+=num%10;
            num/=10;
        }
        System.out.println(a);
        while (a!=0){
            b+=a%10;
            a/=10;
            if(b>=10&&a<=10){
                System.out.println(b);
                System.out.println(a);
                a=b;
                b = 0;
            }
        }
        return b;
    }
}