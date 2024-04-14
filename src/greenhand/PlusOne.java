package greenhand;


/*
66. º”“ª
 */
public class PlusOne {

    public static void main(String[] args) {
        int a[]={9,8,7,6,5,4,3,2,1,0};
        int[] ints = plusOne(a);
        System.out.println(ints);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
    public static int[] plusOne(int[] digits) {
//       int re=digits[digits.length-1]+1;
//        String s = String.valueOf(re);
//        int[] a= new int[s.length()];
//        for (int i = 0; i < a.length; i++) {
//            a[i]=s.charAt(i)-48;
//        }
//
//        int[] result=new int[a.length+digits.length];
//        for (int i = 0; i <digits.length; i++) {
//            result[i]=digits[i];
//        }
//
//        for (int i = digits.length-1; i <result.length-1 ; i++) {
//            if (a.length==1){
//                result[digits.length-1]=a[0];
//            }if (a.length==2){
//                result[digits.length-2]=a[0];
//                result[digits.length-1]=a[1];
//            }
//        }
        for (int i = digits.length-1; i >=0; i--) {
            if (digits[i]==9){
                digits[i]=0;
            }else {
                digits[i]+=1;
                return digits;
            }
        }

        digits=new int[digits.length+1];
        digits[0]=1;

        return digits;

    }
}
