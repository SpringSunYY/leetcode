package medium;

/**
 * @Project: leetcode
 * @Package: medium
 * @Author: YY
 * @CreateTime: 2024-05-31  17:16
 * @Description: Solution6
 * 6. Z ���α任
 * �е�
 * ��һ�������ַ��� s ���ݸ��������� numRows ���Դ������¡������ҽ��� Z �������С�
 * ���������ַ���Ϊ "PAYPALISHIRING" ����Ϊ 3 ʱ���������£�
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * ֮����������Ҫ�����������ж�ȡ��������һ���µ��ַ��������磺"PAHNAPLSIIGYIR"��
 * ����ʵ��������ַ�������ָ�������任�ĺ�����
 * string convert(string s, int numRows);
 * @Version: 1.0
 */
public class Solution6 {
    public static String convert(String s, int numRows) {
        // �������Ϊ 1 �����������ڵ����ַ������ȣ�ֱ�ӷ���ԭ�ַ���
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        // ����һ�� StringBuilder ���飬ÿ�� StringBuilder ����һ��
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;  // ��ǰ�к�
        boolean goingDown = false;  // �����־

        // �����ַ����е�ÿ���ַ�
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);  // ���ַ���ӵ���ǰ��

            // ����л��������ʱ�ı䷽��
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // ���ݷ�����µ�ǰ�к�
            currentRow += goingDown ? 1 : -1;
        }

        // �������е�����ƴ�ӳ����ս��
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            System.out.println("row = " + row);
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(myConvert(s, numRows));  // ���: "PAHNAPLSIIGYIR"
    }

    public static String myConvert(String s, int numRows) {
        // �������Ϊ 1 �����������ڵ����ַ������ȣ�ֱ�ӷ���ԭ�ַ���
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        // ����һ�� StringBuilder ���飬ÿ�� StringBuilder ����һ��
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;  // ��ǰ�к�
        boolean goingDown = false;  // �����־

        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            System.out.println("c = " + c);
            rows[currentRow].append(c);
        }

        // �������е�����ƴ�ӳ����ս��
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            System.out.println("row = " + row);
            result.append(row);

            //����˻�����Ͷ˻���
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            //���ݷ�����µ�ǰ�к�
            currentRow += goingDown ? 1 : -1;
        }

        return result.toString();
    }
}
