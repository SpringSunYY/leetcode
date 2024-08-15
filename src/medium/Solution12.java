package medium;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Project: leetcode
 * @Package: medium
 * @Author: YY
 * @CreateTime: 2024-08-15  15:53
 * @Description: Solution12
 * �߸���ͬ�ķ��Ŵ����������֣���ֵ���£�
 * <p>
 * ����	ֵ
 * I	1
 * V	5
 * X	10
 * L	50
 * C	100
 * D	500
 * M	1000
 * ����������ͨ����Ӵ���ߵ���͵�С��λֵ��ת�����γɵġ���С��λֵת��Ϊ�������������¹���
 * <p>
 * �����ֵ������ 4 �� 9 ��ͷ����ѡ����Դ������м�ȥ�����ֵ�ķ��ţ����÷��Ÿ��ӵ��������ȥ��ֵ��Ȼ�����ಿ��ת��Ϊ�������֡�
 * �����ֵ�� 4 �� 9 ��ͷ��ʹ�� ������ʽ����ʾ�����·����м�ȥһ�����ţ����� 4 �� 5 (V) �� 1 (I): IV ��9 �� 10 (X) �� 1 (I)��IX����ʹ�����¼�����ʽ��4 (IV)��9 (IX)��40 (XL)��90 (XC)��400 (CD) �� 900 (CM)��
 * ֻ�� 10 �Ĵη���I, X, C, M���������������� 3 ���Դ��� 10 �ı������㲻�ܶ�θ��� 5 (V)��50 (L) �� 500 (D)�������Ҫ�����Ÿ���4�Σ���ʹ�� ������ʽ��
 * ����һ������������ת��Ϊ�������֡�
 * ʾ�� 1��
 * ���룺num = 3749
 * ����� "MMMDCCXLIX"
 * ���ͣ�
 * 3000 = MMM ���� 1000 (M) + 1000 (M) + 1000 (M)
 * 700 = DCC ���� 500 (D) + 100 (C) + 100 (C)
 * 40 = XL ���� 50 (L) �� 10 (X)
 * 9 = IX ���� 10 (X) �� 1 (I)
 * ע�⣺49 ���� 50 (L) �� 1 (I) ��Ϊת���ǻ���С��λ
 * ʾ�� 2��
 * ���룺num = 58
 * �����"LVIII"
 * ���ͣ�
 * 50 = L
 * 8 = VIII
 * ʾ�� 3��
 * ���룺num = 1994
 * �����"MCMXCIV"
 * ���ͣ�
 * 1000 = M
 * 900 = CM
 * 90 = XC
 * 4 = IV
 * @Version: 1.0
 */
public class Solution12 {
    public static void main(String[] args) {
        romanToString(3749);  // ���: MMMDCCXLIX
        romanToString(1994);  // ���: MCMXCIV
        romanToString(58);    // ���: LVIII
        romanToString(10);    // ���: LVIII
    }

    public static String romanToString(int num) {
        System.out.println("num = " + num);
        String numberStr = Integer.toString(num);
        StringBuffer stringBuffer = new StringBuffer();
        int length = numberStr.length();

        for (int i = 0; i < length; i++) {
            // ��ȡ��ǰ����λ��ֵ
            int digit = Character.getNumericValue(numberStr.charAt(i));
            // ���㵱ǰ����λ��Ӧ��Ȩֵ����ǧλ����λ��ʮλ����λ��
            int position = (int) Math.pow(10, length - 1 - i);
            // ��ȡ��ǰ����λ�ľ���ֵ
            int positionNum = position * digit;

            // ����ǰ����λת��Ϊ�������ֲ�׷�ӵ������
            stringBuffer.append(convertToRoman(positionNum, position));
        }

        System.out.println("Roman Numeral: " + stringBuffer.toString());
        return stringBuffer.toString();
    }

    // ���ݵ�ǰλ��ֵ�����ض�Ӧ����������
    private static String convertToRoman(int num, int position) {
        StringBuffer result = new StringBuffer();
        ArrayList<String> strings = new ArrayList<>();
        while (num > 0) {
            String value = getValue(num);
            if (!value.isEmpty()) {
                strings.add(value);
                break;
            } else {
                // �Ҳ�������ƥ��ʱ���� num ���Ϊ��С����
                num -= position;
                strings.add(getValue(position));
            }
        }
        System.out.println("strings.size() = " + strings.size());
        if (!strings.isEmpty() && getValue(strings.get(0)) < getValue(strings.get(strings.size() - 1))) {
            // ��ת�б��е�����Ԫ��
            Collections.reverse(strings);
        }
        System.out.println("strings = " + strings.toString());
        for (String string : strings) {
            result.append(string);
            System.out.println("string = " + string);
        }
        return result.toString();
    }

    private static int getValue(String c) {
        switch (c) {
            case "I":
                return 1;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "IX":
                return 9;
            case "X":
                return 10;
            case "XL":
                return 40;
            case "L":
                return 50;
            case "XC":
                return 90;
            case "C":
                return 100;
            case "CD":
                return 400;
            case "D":
                return 500;
            case "CM":
                return 900;
            case "M":
                return 1000;
            default:
                return 0;
        }
    }

    // ��ȡ������ֵ��Ӧ����������
    private static String getValue(int c) {
        switch (c) {
            case 1:
                return "I";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 9:
                return "IX";
            case 10:
                return "X";
            case 40:
                return "XL";
            case 50:
                return "L";
            case 90:
                return "XC";
            case 100:
                return "C";
            case 400:
                return "CD";
            case 500:
                return "D";
            case 900:
                return "CM";
            case 1000:
                return "M";
            default:
                return "";
        }
    }
}
