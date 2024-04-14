package easy;

public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println("lengthOfLastWord(\"Hello World\") = " + lengthOfLastWord("Hello World"));
    }
    public static int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");
        return strings[strings.length-1].length();
    }
}
